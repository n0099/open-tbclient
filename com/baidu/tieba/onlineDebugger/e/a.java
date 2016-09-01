package com.baidu.tieba.onlineDebugger.e;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.onlineDebugger.a.c;
import com.baidu.tieba.onlineDebugger.d;
import com.baidu.tieba.onlineDebugger.framework.LoopQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/* loaded from: classes.dex */
public class a {
    private Class<?> egq;
    private Stack<com.baidu.tieba.onlineDebugger.a.b> egr;
    private String egs;

    public void ov(String str) {
        this.egs = str;
        String[] ow = ow(str);
        if (ow == null || ow.length != 2) {
            throw new RuntimeException("anaylze class name return error");
        }
        this.egq = com.baidu.tieba.onlineDebugger.c.a.findClass(ow[0]);
        if (this.egq == null) {
            this.egq = d.oi(ow[0]);
        }
        if (this.egq == null) {
            throw new RuntimeException("cannot find class for command " + str);
        }
        this.egr = new Stack<>();
        List<String> ox = ox(ow[1]);
        for (int size = ox.size() - 1; size >= 0; size--) {
            this.egr.push(oz(ox.get(size)));
        }
    }

    private String[] ow(String str) {
        if (str.startsWith("$")) {
            String[] strArr = new String[2];
            strArr[0] = LoopQueue.class.getName();
            int indexOf = str.indexOf(".");
            if (indexOf > 0) {
                int g = com.baidu.adp.lib.h.b.g(str.substring(1, indexOf), -1);
                if (g >= 0) {
                    strArr[1] = "getInstance().get(" + g + ")" + str.substring(indexOf);
                    return strArr;
                }
            } else {
                int g2 = com.baidu.adp.lib.h.b.g(str.substring(1), -1);
                if (g2 >= 0) {
                    strArr[1] = "getInstance().get(" + g2 + ")";
                    return strArr;
                }
            }
            throw new RuntimeException("command start with $ must like $11");
        }
        int indexOf2 = str.indexOf("#");
        if (indexOf2 > 0) {
            return new String[]{str.substring(0, indexOf2), str.substring(indexOf2 + 1)};
        }
        throw new RuntimeException("cannot find class");
    }

    private List<String> ox(String str) {
        char[] charArray = str.toCharArray();
        ArrayList<String> arrayList = new ArrayList();
        int i = 0;
        boolean z = false;
        int i2 = -1;
        for (int i3 = 0; i3 < charArray.length; i3++) {
            if (charArray[i3] == '.') {
                if (!z) {
                    if (i2 < 0) {
                        arrayList.add(new String(a(charArray, 0, i3)));
                    } else {
                        arrayList.add(new String(a(charArray, i2 + 1, (i3 - i2) - 1)));
                    }
                    i2 = i3;
                }
            } else if (charArray[i3] == '(') {
                if (z) {
                    i++;
                } else {
                    z = true;
                    i++;
                }
            } else if (charArray[i3] == ')') {
                if (z) {
                    i--;
                    if (i == 0) {
                        z = false;
                    }
                } else {
                    throw new RuntimeException("command parser error before ) must have (");
                }
            } else if (charArray[i3] == '=') {
                break;
            }
        }
        if (i2 >= 0 && i2 != charArray.length - 1) {
            arrayList.add(new String(a(charArray, i2 + 1, (charArray.length - i2) - 1)));
        } else if (i2 == -1) {
            arrayList.add(str);
        }
        for (String str2 : arrayList) {
            BdLog.e(str2);
        }
        return arrayList;
    }

    private char[] a(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return new char[0];
        }
        if (i < 0 || i + i2 > cArr.length) {
            return new char[0];
        }
        char[] cArr2 = new char[i2];
        for (int i3 = 0; i3 < cArr2.length; i3++) {
            cArr2[i3] = cArr[i + i3];
        }
        return cArr2;
    }

    private String[] oy(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains(",")) {
            if (!str.contains("(") || !str.contains(")")) {
                return str.split(",");
            }
            char[] charArray = str.toCharArray();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            boolean z = false;
            int i2 = -1;
            for (int i3 = 0; i3 < charArray.length; i3++) {
                if (charArray[i3] == ',') {
                    if (!z) {
                        if (i2 < 0) {
                            str2 = new String(a(charArray, 0, i3));
                        } else {
                            str2 = new String(a(charArray, i2 + 1, (i3 - i2) - 1));
                        }
                        if (str2 != null && str2.startsWith("\"") && str2.endsWith("\"")) {
                            arrayList.add(str2.substring(1, str2.length() - 1));
                        } else {
                            arrayList.add(str2);
                        }
                        i2 = i3;
                    }
                } else if (charArray[i3] == '(') {
                    if (z) {
                        i++;
                    } else {
                        i++;
                        z = true;
                    }
                } else if (charArray[i3] != ')') {
                    continue;
                } else if (z) {
                    i--;
                    if (i == 0) {
                        z = false;
                    }
                } else {
                    throw new RuntimeException("command parser error before ) must have (");
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        return new String[]{str};
    }

    private com.baidu.tieba.onlineDebugger.a.b oz(String str) {
        if (str != null) {
            int indexOf = str.indexOf(40);
            int lastIndexOf = str.lastIndexOf(41);
            boolean z = str.lastIndexOf(61) > 0;
            boolean z2 = indexOf > 0 && lastIndexOf > 0 && lastIndexOf > indexOf;
            if (z) {
                String[] split = str.split("=");
                if (split != null && split.length == 2) {
                    com.baidu.tieba.onlineDebugger.a.d dVar = new com.baidu.tieba.onlineDebugger.a.d();
                    dVar.oj(split[0]);
                    dVar.ol(split[1]);
                    return dVar;
                }
                throw new RuntimeException("parser action error " + str);
            } else if (z2) {
                String substring = str.substring(0, indexOf);
                String[] oy = oy(str.substring(indexOf + 1, lastIndexOf));
                c cVar = new c();
                cVar.ok(substring);
                cVar.C(oy);
                return cVar;
            } else {
                com.baidu.tieba.onlineDebugger.a.a aVar = new com.baidu.tieba.onlineDebugger.a.a();
                aVar.oj(str);
                return aVar;
            }
        }
        return null;
    }

    public Class<?> aKN() {
        return this.egq;
    }

    public Stack<com.baidu.tieba.onlineDebugger.a.b> aKO() {
        return this.egr;
    }
}

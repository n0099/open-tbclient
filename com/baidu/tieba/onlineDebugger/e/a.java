package com.baidu.tieba.onlineDebugger.e;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.onlineDebugger.a.d;
import com.baidu.tieba.onlineDebugger.c;
import com.baidu.tieba.onlineDebugger.framework.LoopQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/* loaded from: classes.dex */
public class a {
    private Class<?> cvK;
    private Stack<com.baidu.tieba.onlineDebugger.a.b> cvL;
    private String cvM;

    public void kh(String str) {
        this.cvM = str;
        String[] ki = ki(str);
        if (ki == null || ki.length != 2) {
            throw new RuntimeException("anaylze class name return error");
        }
        this.cvK = com.baidu.tieba.onlineDebugger.c.a.findClass(ki[0]);
        if (this.cvK == null) {
            this.cvK = c.jW(ki[0]);
        }
        if (this.cvK == null) {
            throw new RuntimeException("cannot find class for command " + str);
        }
        this.cvL = new Stack<>();
        List<String> kj = kj(ki[1]);
        for (int size = kj.size() - 1; size >= 0; size--) {
            this.cvL.push(kl(kj.get(size)));
        }
    }

    private String[] ki(String str) {
        if (str.startsWith("$")) {
            return new String[]{LoopQueue.class.getName(), str.substring(1)};
        }
        int indexOf = str.indexOf("#");
        if (indexOf > 0) {
            return new String[]{str.substring(0, indexOf), str.substring(indexOf + 1)};
        }
        throw new RuntimeException("cannot find class");
    }

    private List<String> kj(String str) {
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

    private String[] kk(String str) {
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

    private com.baidu.tieba.onlineDebugger.a.b kl(String str) {
        if (str != null) {
            int indexOf = str.indexOf(40);
            int lastIndexOf = str.lastIndexOf(41);
            boolean z = str.lastIndexOf(61) > 0;
            boolean z2 = indexOf > 0 && lastIndexOf > 0 && lastIndexOf > indexOf;
            if (z) {
                String[] split = str.split("=");
                if (split != null && split.length == 2) {
                    d dVar = new d();
                    dVar.jX(split[0]);
                    dVar.jZ(split[1]);
                    return dVar;
                }
                throw new RuntimeException("parser action error " + str);
            } else if (z2) {
                String substring = str.substring(0, indexOf);
                String[] kk = kk(str.substring(indexOf + 1, lastIndexOf));
                com.baidu.tieba.onlineDebugger.a.c cVar = new com.baidu.tieba.onlineDebugger.a.c();
                cVar.jY(substring);
                cVar.u(kk);
                return cVar;
            } else {
                com.baidu.tieba.onlineDebugger.a.a aVar = new com.baidu.tieba.onlineDebugger.a.a();
                aVar.jX(str);
                return aVar;
            }
        }
        return null;
    }

    public Class<?> aiF() {
        return this.cvK;
    }

    public Stack<com.baidu.tieba.onlineDebugger.a.b> aiG() {
        return this.cvL;
    }
}

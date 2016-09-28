package com.baidu.tieba.onlineDebugger.command;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.onlineDebugger.framework.LoopQueue;
import java.lang.reflect.Constructor;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes.dex */
public class i implements h {
    private String eim;
    private Stack<String> ein = new Stack<>();
    private Queue<Object> eio = new LinkedBlockingQueue();

    public i(String str) {
        this.eim = str;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public Object aLi() throws Exception {
        String trim;
        int lastIndexOf;
        String str = this.eim;
        String substring = str.substring(str.indexOf(" ") + 1);
        int indexOf = substring.indexOf("=");
        int g = com.baidu.adp.lib.h.b.g(substring.substring(0, indexOf + 1).trim().substring(1, trim.length() - 1), -1);
        if (g == -1) {
            throw new InvalidAlgorithmParameterException("new cmd must like $11 = com.baidu.tieba.a()");
        }
        String substring2 = substring.substring(indexOf + 1);
        int indexOf2 = substring2.indexOf("(");
        if (indexOf2 >= 0 && (lastIndexOf = substring2.lastIndexOf(")")) >= 0) {
            Class<?> cls = Class.forName(substring2.substring(0, indexOf2));
            if (lastIndexOf == indexOf2 + 1) {
                Constructor<?> constructor = cls.getConstructor(new Class[0]);
                constructor.setAccessible(true);
                Object newInstance = constructor.newInstance(new Object[0]);
                LoopQueue.getInstance().set(g, newInstance);
                return newInstance;
            }
            String substring3 = substring2.substring(indexOf2 + 1, lastIndexOf);
            String[] split = substring3.split(",");
            Constructor<?>[] constructors = cls.getConstructors();
            ArrayList<Constructor> arrayList = new ArrayList();
            if (constructors != null) {
                for (Constructor<?> constructor2 : constructors) {
                    if (constructor2 != null && constructor2.getParameterTypes() != null && constructor2.getParameterTypes().length == split.length) {
                        arrayList.add(constructor2);
                    }
                }
            }
            if (arrayList.size() > 0) {
                Class[] clsArr = new Class[split.length];
                Object[] objArr = new Object[split.length];
                for (int i = 0; i < split.length; i++) {
                    try {
                        Object aLi = com.baidu.tieba.onlineDebugger.e.b.oO("get " + substring3).aLi();
                        if (aLi != null) {
                            objArr[i] = aLi;
                            clsArr[i] = aLi.getClass();
                        }
                    } catch (Exception e) {
                        BdLog.e(e);
                    }
                }
                if (arrayList.size() == 1) {
                    Constructor constructor3 = (Constructor) arrayList.get(0);
                    constructor3.setAccessible(true);
                    Object newInstance2 = constructor3.newInstance(new Object[0]);
                    LoopQueue.getInstance().set(g, newInstance2);
                    return newInstance2;
                }
                for (Constructor constructor4 : arrayList) {
                    try {
                        constructor4.setAccessible(true);
                        Object newInstance3 = constructor4.newInstance(new Object[0]);
                        LoopQueue.getInstance().set(g, newInstance3);
                        return newInstance3;
                    } catch (Throwable th) {
                    }
                }
            }
            return new com.baidu.tieba.onlineDebugger.a(this.eim).get();
        }
        return null;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aLj() {
        int indexOf;
        String str = this.eim;
        String substring = str.substring(str.indexOf(" ") + 1);
        if (substring.length() < 5) {
            return false;
        }
        char charAt = substring.charAt(0);
        char charAt2 = substring.charAt(1);
        char charAt3 = substring.charAt(2);
        if (charAt != '$' || charAt2 < '0' || charAt2 > '9') {
            return false;
        }
        if (!((charAt3 >= '0' && charAt2 <= '9') || charAt3 == ' ' || charAt3 == '=') || (indexOf = substring.indexOf("=")) == -1) {
            return false;
        }
        for (int i = indexOf - 1; i > 1; i--) {
            if ((substring.charAt(i) < '0' || substring.charAt(i) > '9') && substring.charAt(i) != ' ') {
                return false;
            }
        }
        String trim = substring.substring(0, indexOf + 1).trim();
        if (trim.length() >= 5 || com.baidu.adp.lib.h.b.g(trim.substring(1, trim.length() - 1), -1) == -1) {
            return false;
        }
        String trim2 = substring.substring(indexOf + 1).trim();
        for (String str2 : com.baidu.tieba.onlineDebugger.d.a.eix) {
            if (trim2.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }
}

package com.baidu.tieba.onlineDebugger.command;

import java.util.Stack;
/* loaded from: classes.dex */
public class f implements h {
    public Class<?> dSP;
    public Stack<com.baidu.tieba.onlineDebugger.a.b> dSQ = new Stack<>();

    public f(Class<?> cls, Stack<com.baidu.tieba.onlineDebugger.a.b> stack) {
        this.dSP = cls;
        this.dSQ.addAll(stack);
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public Object aHc() {
        Object obj;
        if (this.dSQ != null && this.dSQ.size() > 0) {
            Object obj2 = this.dSP;
            while (true) {
                obj = obj2;
                if (this.dSQ.size() <= 0 || obj == null || (obj instanceof Void)) {
                    break;
                }
                obj2 = this.dSQ.pop().V(obj);
            }
            if (this.dSQ.size() != 0) {
                throw new RuntimeException("process command error");
            }
            return obj;
        }
        return null;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aHd() {
        String name = this.dSP.getPackage().getName();
        for (String str : com.baidu.tieba.onlineDebugger.d.a.dTc) {
            if (name.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}

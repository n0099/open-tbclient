package com.baidu.tieba.onlineDebugger.command;

import java.util.Stack;
/* loaded from: classes.dex */
public class f implements h {
    public Class<?> dUk;
    public Stack<com.baidu.tieba.onlineDebugger.a.b> dUl = new Stack<>();

    public f(Class<?> cls, Stack<com.baidu.tieba.onlineDebugger.a.b> stack) {
        this.dUk = cls;
        this.dUl.addAll(stack);
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public Object aFP() {
        Object obj;
        if (this.dUl != null && this.dUl.size() > 0) {
            Object obj2 = this.dUk;
            while (true) {
                obj = obj2;
                if (this.dUl.size() <= 0 || obj == null || (obj instanceof Void)) {
                    break;
                }
                obj2 = this.dUl.pop().Q(obj);
            }
            if (this.dUl.size() != 0) {
                throw new RuntimeException("process command error");
            }
            return obj;
        }
        return null;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aFQ() {
        String name = this.dUk.getPackage().getName();
        for (String str : com.baidu.tieba.onlineDebugger.d.a.dUx) {
            if (name.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}

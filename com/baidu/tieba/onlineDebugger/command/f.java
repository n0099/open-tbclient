package com.baidu.tieba.onlineDebugger.command;

import java.util.Stack;
/* loaded from: classes.dex */
public class f implements h {
    public Class<?> egq;
    public Stack<com.baidu.tieba.onlineDebugger.a.b> egr = new Stack<>();

    public f(Class<?> cls, Stack<com.baidu.tieba.onlineDebugger.a.b> stack) {
        this.egq = cls;
        this.egr.addAll(stack);
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public Object aKH() {
        Object obj;
        if (this.egr != null && this.egr.size() > 0) {
            Object obj2 = this.egq;
            while (true) {
                obj = obj2;
                if (this.egr.size() <= 0 || obj == null || (obj instanceof Void)) {
                    break;
                }
                obj2 = this.egr.pop().S(obj);
            }
            if (this.egr.size() != 0) {
                throw new RuntimeException("process command error");
            }
            return obj;
        }
        return null;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aKI() {
        String name = this.egq.getPackage().getName();
        for (String str : com.baidu.tieba.onlineDebugger.d.a.egD) {
            if (name.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}

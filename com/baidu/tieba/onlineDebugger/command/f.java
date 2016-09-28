package com.baidu.tieba.onlineDebugger.command;

import java.util.Stack;
/* loaded from: classes.dex */
public class f implements h {
    public Class<?> eik;
    public Stack<com.baidu.tieba.onlineDebugger.a.b> eil = new Stack<>();

    public f(Class<?> cls, Stack<com.baidu.tieba.onlineDebugger.a.b> stack) {
        this.eik = cls;
        this.eil.addAll(stack);
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public Object aLi() {
        Object obj;
        if (this.eil != null && this.eil.size() > 0) {
            Object obj2 = this.eik;
            while (true) {
                obj = obj2;
                if (this.eil.size() <= 0 || obj == null || (obj instanceof Void)) {
                    break;
                }
                obj2 = this.eil.pop().S(obj);
            }
            if (this.eil.size() != 0) {
                throw new RuntimeException("process command error");
            }
            return obj;
        }
        return null;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aLj() {
        String name = this.eik.getPackage().getName();
        for (String str : com.baidu.tieba.onlineDebugger.d.a.eix) {
            if (name.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}

package com.baidu.tieba.onlineDebugger.command;

import java.util.Stack;
/* loaded from: classes.dex */
public class f implements h {
    public Class<?> eoj;
    public Stack<com.baidu.tieba.onlineDebugger.a.b> eok = new Stack<>();

    public f(Class<?> cls, Stack<com.baidu.tieba.onlineDebugger.a.b> stack) {
        this.eoj = cls;
        this.eok.addAll(stack);
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public Object aNb() {
        Object obj;
        if (this.eok != null && this.eok.size() > 0) {
            Object obj2 = this.eoj;
            while (true) {
                obj = obj2;
                if (this.eok.size() <= 0 || obj == null || (obj instanceof Void)) {
                    break;
                }
                obj2 = this.eok.pop().V(obj);
            }
            if (this.eok.size() != 0) {
                throw new RuntimeException("process command error");
            }
            return obj;
        }
        return null;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aNc() {
        String name = this.eoj.getPackage().getName();
        for (String str : com.baidu.tieba.onlineDebugger.d.a.eow) {
            if (name.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}

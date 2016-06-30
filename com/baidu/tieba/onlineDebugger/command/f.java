package com.baidu.tieba.onlineDebugger.command;

import java.util.Stack;
/* loaded from: classes.dex */
public class f implements h {
    public Class<?> dIb;
    public Stack<com.baidu.tieba.onlineDebugger.a.b> dIc = new Stack<>();

    public f(Class<?> cls, Stack<com.baidu.tieba.onlineDebugger.a.b> stack) {
        this.dIb = cls;
        this.dIc.addAll(stack);
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public Object aCF() {
        Object obj;
        if (this.dIc != null && this.dIc.size() > 0) {
            Object obj2 = this.dIb;
            while (true) {
                obj = obj2;
                if (this.dIc.size() <= 0 || obj == null || (obj instanceof Void)) {
                    break;
                }
                obj2 = this.dIc.pop().N(obj);
            }
            if (this.dIc.size() != 0) {
                throw new RuntimeException("process command error");
            }
            return obj;
        }
        return null;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aCG() {
        String name = this.dIb.getPackage().getName();
        for (String str : com.baidu.tieba.onlineDebugger.d.a.dIo) {
            if (name.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}

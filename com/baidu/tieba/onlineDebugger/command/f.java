package com.baidu.tieba.onlineDebugger.command;

import java.util.Stack;
/* loaded from: classes.dex */
public class f implements h {
    public Class<?> ebI;
    public Stack<com.baidu.tieba.onlineDebugger.a.b> ebJ = new Stack<>();

    public f(Class<?> cls, Stack<com.baidu.tieba.onlineDebugger.a.b> stack) {
        this.ebI = cls;
        this.ebJ.addAll(stack);
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public Object aIQ() {
        Object obj;
        if (this.ebJ != null && this.ebJ.size() > 0) {
            Object obj2 = this.ebI;
            while (true) {
                obj = obj2;
                if (this.ebJ.size() <= 0 || obj == null || (obj instanceof Void)) {
                    break;
                }
                obj2 = this.ebJ.pop().Y(obj);
            }
            if (this.ebJ.size() != 0) {
                throw new RuntimeException("process command error");
            }
            return obj;
        }
        return null;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.h
    public boolean aIR() {
        String name = this.ebI.getPackage().getName();
        for (String str : com.baidu.tieba.onlineDebugger.d.a.ebV) {
            if (name.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}

package com.baidu.tieba.onlineDebugger.command;

import java.util.Stack;
/* loaded from: classes.dex */
public class b implements d {
    public Class<?> cvK;
    public Stack<com.baidu.tieba.onlineDebugger.a.b> cvL = new Stack<>();

    public b(Class<?> cls, Stack<com.baidu.tieba.onlineDebugger.a.b> stack) {
        this.cvK = cls;
        this.cvL.addAll(stack);
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public Object aiA() {
        Object obj;
        if (this.cvL != null && this.cvL.size() > 0) {
            Object obj2 = this.cvK;
            while (true) {
                obj = obj2;
                if (this.cvL.size() <= 0 || obj == null || (obj instanceof Void)) {
                    break;
                }
                obj2 = this.cvL.pop().K(obj);
            }
            if (this.cvL.size() != 0) {
                throw new RuntimeException("process command error");
            }
            return obj;
        }
        return null;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public boolean aiB() {
        String name = this.cvK.getPackage().getName();
        for (String str : com.baidu.tieba.onlineDebugger.d.a.cvU) {
            if (name.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}

package com.baidu.tieba.onlineDebugger.command;

import java.util.Stack;
/* loaded from: classes.dex */
public class b implements d {
    public Class<?> dbu;
    public Stack<com.baidu.tieba.onlineDebugger.a.b> dbv = new Stack<>();

    public b(Class<?> cls, Stack<com.baidu.tieba.onlineDebugger.a.b> stack) {
        this.dbu = cls;
        this.dbv.addAll(stack);
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public Object aux() {
        Object obj;
        if (this.dbv != null && this.dbv.size() > 0) {
            Object obj2 = this.dbu;
            while (true) {
                obj = obj2;
                if (this.dbv.size() <= 0 || obj == null || (obj instanceof Void)) {
                    break;
                }
                obj2 = this.dbv.pop().L(obj);
            }
            if (this.dbv.size() != 0) {
                throw new RuntimeException("process command error");
            }
            return obj;
        }
        return null;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public boolean auy() {
        String name = this.dbu.getPackage().getName();
        for (String str : com.baidu.tieba.onlineDebugger.d.a.dbH) {
            if (name.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}

package com.baidu.tieba.onlineDebugger.command;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes.dex */
public class e implements d {
    private String cvM;
    private Stack<String> cvN = new Stack<>();
    private Queue<Object> cvO = new LinkedBlockingQueue();

    public e(String str) {
        this.cvM = str;
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public Object aiA() {
        return new com.baidu.tieba.onlineDebugger.a(this.cvM).get();
    }

    @Override // com.baidu.tieba.onlineDebugger.command.d
    public boolean aiB() {
        String substring = this.cvM.substring(this.cvM.indexOf(" ") + 1);
        for (String str : com.baidu.tieba.onlineDebugger.d.a.cvU) {
            if (substring.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}

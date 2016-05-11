package com.baidu.tieba.onlineDebugger.framework;
/* loaded from: classes.dex */
public class LoopQueue {
    private static LoopQueue queue;
    private Object[] cache = new Object[100];

    public static LoopQueue getInstance() {
        synchronized (LoopQueue.class) {
            if (queue == null) {
                synchronized (LoopQueue.class) {
                    queue = new LoopQueue();
                }
            }
        }
        return queue;
    }

    private LoopQueue() {
    }

    public synchronized void set(int i, Object obj) {
        if (i >= 0 && i < 100) {
            this.cache[i] = obj;
        }
    }

    public synchronized Object get(int i) {
        return (i < 0 || i >= 100) ? null : this.cache[i];
    }
}

package com.baidu.tieba.onlineDebugger.framework;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class LoopQueue {
    private static LoopQueue queue;
    private int capacity = 7;
    private int cur = 0;
    private ArrayList<Object> list = new ArrayList<>();

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

    public synchronized int add(Object obj) {
        int i;
        this.list.add(this.cur, obj);
        i = this.cur;
        this.cur = (this.cur + 1) % this.capacity;
        return i;
    }

    public synchronized Object get(int i) {
        return i >= this.list.size() ? null : this.list.get(i);
    }

    public synchronized void clear() {
        this.list.clear();
    }
}

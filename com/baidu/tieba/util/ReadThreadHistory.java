package com.baidu.tieba.util;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class ReadThreadHistory {
    private volatile int mMaxNum;
    private volatile HashMap<Long, Integer> mThread = new HashMap<>();
    private volatile int mWeight = 0;

    public ReadThreadHistory(int maxNum) {
        this.mMaxNum = maxNum;
    }

    public void addThread(String id) {
        try {
            Long threadId = Long.valueOf(Long.parseLong(id));
            synchronized (this) {
                if (this.mThread.size() >= this.mMaxNum) {
                    deleteThread();
                }
                this.mWeight++;
                this.mThread.put(threadId, Integer.valueOf(this.mWeight));
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "addThread", ex.getMessage());
        }
    }

    public void deleteThread() {
        synchronized (this) {
            Long key = null;
            int tmp = 134217727;
            for (Map.Entry<Long, Integer> entry : this.mThread.entrySet()) {
                if (entry.getValue().intValue() < tmp) {
                    tmp = entry.getValue().intValue();
                    key = entry.getKey();
                }
            }
            if (key != null) {
                this.mThread.remove(key);
            } else {
                this.mThread.clear();
            }
        }
    }

    public boolean getThread(String id) {
        boolean z = false;
        try {
            Long threadId = Long.valueOf(Long.parseLong(id));
            synchronized (this) {
                if (this.mThread.get(threadId) != null) {
                    z = true;
                }
            }
        } catch (Exception ex) {
            TiebaLog.e(getClass().getName(), "getThread", ex.getMessage());
        }
        return z;
    }

    public void clearAllThread() {
        synchronized (this) {
            this.mThread.clear();
        }
    }
}

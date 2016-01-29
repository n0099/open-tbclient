package com.baidu.tieba.recommendfrs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a dCY = new a();
    private long dCZ = 0;
    private SparseArray<Long> dDa = new SparseArray<>();
    private SparseArray<Long> dDb = new SparseArray<>();

    private a() {
    }

    public static a aER() {
        return dCY;
    }

    public long getCreateTime() {
        return this.dCZ;
    }

    public void setCreateTime(long j) {
        this.dCZ = j;
    }

    public long nq(int i) {
        Long l = this.dDb.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void e(long j, int i) {
        this.dDb.put(i, Long.valueOf(j));
    }

    public long nr(int i) {
        Long l = this.dDa.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void f(long j, int i) {
        this.dDa.put(i, Long.valueOf(j));
    }
}

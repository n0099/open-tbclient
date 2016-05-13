package com.baidu.tieba.recommendfrs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a dXI = new a();
    private long dXJ = 0;
    private SparseArray<Long> dXK = new SparseArray<>();
    private SparseArray<Long> dXL = new SparseArray<>();
    private SparseArray<Long> dXM = new SparseArray<>();
    private SparseArray<Long> dXN = new SparseArray<>();

    private a() {
    }

    public static a aLQ() {
        return dXI;
    }

    public long getCreateTime() {
        return this.dXJ;
    }

    public void setCreateTime(long j) {
        this.dXJ = j;
    }

    public long oi(int i) {
        Long l = this.dXL.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void r(long j, int i) {
        this.dXL.put(i, Long.valueOf(j));
    }

    public long oj(int i) {
        Long l = this.dXK.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void s(long j, int i) {
        this.dXK.put(i, Long.valueOf(j));
    }

    public long ok(int i) {
        Long l = this.dXM.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void t(long j, int i) {
        this.dXM.put(i, Long.valueOf(j));
    }

    public long ol(int i) {
        Long l = this.dXN.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void u(long j, int i) {
        this.dXN.put(i, Long.valueOf(j));
    }
}

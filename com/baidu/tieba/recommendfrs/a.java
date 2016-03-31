package com.baidu.tieba.recommendfrs;

import android.util.SparseArray;
/* loaded from: classes.dex */
public class a {
    private static a dUQ = new a();
    private long dUR = 0;
    private SparseArray<Long> dUS = new SparseArray<>();
    private SparseArray<Long> dUT = new SparseArray<>();
    private SparseArray<Long> dUU = new SparseArray<>();
    private SparseArray<Long> dUV = new SparseArray<>();

    private a() {
    }

    public static a aLJ() {
        return dUQ;
    }

    public long getCreateTime() {
        return this.dUR;
    }

    public void setCreateTime(long j) {
        this.dUR = j;
    }

    public long ot(int i) {
        Long l = this.dUT.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void q(long j, int i) {
        this.dUT.put(i, Long.valueOf(j));
    }

    public long ou(int i) {
        Long l = this.dUS.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void r(long j, int i) {
        this.dUS.put(i, Long.valueOf(j));
    }

    public long ov(int i) {
        Long l = this.dUU.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void s(long j, int i) {
        this.dUU.put(i, Long.valueOf(j));
    }

    public long ow(int i) {
        Long l = this.dUV.get(i);
        if (l == null) {
            return -1L;
        }
        return l.longValue();
    }

    public void t(long j, int i) {
        this.dUV.put(i, Long.valueOf(j));
    }
}

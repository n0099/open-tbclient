package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class e<T> {
    private T hvd;
    private int hve;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.hvd = t;
        this.hve = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bDc() {
        return this.hve;
    }

    public void wS(int i) {
        this.hve = i;
    }

    public T getValue() {
        return this.hvd;
    }

    public void setValue(T t) {
        this.hvd = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

package com.baidu.tieba.video.record;
/* loaded from: classes23.dex */
public class e<T> {
    private String mName;
    private int mType;
    private int nHt;
    private T zJ;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.zJ = t;
        this.nHt = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int dVI() {
        return this.nHt;
    }

    public void Mj(int i) {
        this.nHt = i;
    }

    public T getValue() {
        return this.zJ;
    }

    public void setValue(T t) {
        this.zJ = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

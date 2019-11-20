package com.baidu.tieba.video.record;
/* loaded from: classes5.dex */
public class e<T> {
    private T bw;
    private int jCy;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.bw = t;
        this.jCy = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int cuE() {
        return this.jCy;
    }

    public void AY(int i) {
        this.jCy = i;
    }

    public T getValue() {
        return this.bw;
    }

    public void setValue(T t) {
        this.bw = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

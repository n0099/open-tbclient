package com.baidu.tieba.video.record;
/* loaded from: classes7.dex */
public class e<T> {
    private T bA;
    private int kwn;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.bA = t;
        this.kwn = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int cOA() {
        return this.kwn;
    }

    public void Dt(int i) {
        this.kwn = i;
    }

    public T getValue() {
        return this.bA;
    }

    public void setValue(T t) {
        this.bA = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

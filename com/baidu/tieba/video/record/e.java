package com.baidu.tieba.video.record;
/* loaded from: classes8.dex */
public class e<T> {
    private String mName;
    private int mType;
    private T mValue;
    private int nKK;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.mValue = t;
        this.nKK = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int dVk() {
        return this.nKK;
    }

    public void LW(int i) {
        this.nKK = i;
    }

    public T getValue() {
        return this.mValue;
    }

    public void setValue(T t) {
        this.mValue = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

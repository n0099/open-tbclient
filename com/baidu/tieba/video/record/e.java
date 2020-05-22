package com.baidu.tieba.video.record;
/* loaded from: classes10.dex */
public class e<T> {
    private int lFT;
    private String mName;
    private int mType;
    private T mValue;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.mValue = t;
        this.lFT = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int djF() {
        return this.lFT;
    }

    public void Fc(int i) {
        this.lFT = i;
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

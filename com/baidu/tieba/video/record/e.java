package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class e<T> {
    private T huF;
    private int huG;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.huF = t;
        this.huG = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bCX() {
        return this.huG;
    }

    public void wS(int i) {
        this.huG = i;
    }

    public T getValue() {
        return this.huF;
    }

    public void setValue(T t) {
        this.huF = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

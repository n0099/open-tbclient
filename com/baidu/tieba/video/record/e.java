package com.baidu.tieba.video.record;
/* loaded from: classes5.dex */
public class e<T> {
    private T bY;
    private int jDp;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.bY = t;
        this.jDp = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int cuG() {
        return this.jDp;
    }

    public void AZ(int i) {
        this.jDp = i;
    }

    public T getValue() {
        return this.bY;
    }

    public void setValue(T t) {
        this.bY = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

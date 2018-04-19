package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class e<T> {
    private T gQm;
    private int gQn;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.gQm = t;
        this.gQn = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bxV() {
        return this.gQn;
    }

    public void uu(int i) {
        this.gQn = i;
    }

    public T getValue() {
        return this.gQm;
    }

    public void setValue(T t) {
        this.gQm = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

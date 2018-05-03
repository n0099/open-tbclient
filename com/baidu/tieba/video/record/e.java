package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class e<T> {
    private T gQj;
    private int gQk;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.gQj = t;
        this.gQk = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bxV() {
        return this.gQk;
    }

    public void uu(int i) {
        this.gQk = i;
    }

    public T getValue() {
        return this.gQj;
    }

    public void setValue(T t) {
        this.gQj = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

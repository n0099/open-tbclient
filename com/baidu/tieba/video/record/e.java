package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class e<T> {
    private T gWw;
    private int gWx;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.gWw = t;
        this.gWx = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bDr() {
        return this.gWx;
    }

    public void vA(int i) {
        this.gWx = i;
    }

    public T getValue() {
        return this.gWw;
    }

    public void setValue(T t) {
        this.gWw = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

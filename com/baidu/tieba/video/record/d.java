package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class d<T> {
    private T gIn;
    private int gIo;
    private String mName;
    private int mType;

    public d() {
    }

    public d(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.gIn = t;
        this.gIo = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bAc() {
        return this.gIo;
    }

    public void uS(int i) {
        this.gIo = i;
    }

    public T getValue() {
        return this.gIn;
    }

    public void setValue(T t) {
        this.gIn = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

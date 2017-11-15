package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class d<T> {
    private T gJv;
    private int gJw;
    private String mName;
    private int mType;

    public d() {
    }

    public d(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.gJv = t;
        this.gJw = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bAo() {
        return this.gJw;
    }

    public void uW(int i) {
        this.gJw = i;
    }

    public T getValue() {
        return this.gJv;
    }

    public void setValue(T t) {
        this.gJv = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

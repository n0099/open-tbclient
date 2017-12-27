package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class e<T> {
    private T hDF;
    private int hDG;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.hDF = t;
        this.hDG = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bIQ() {
        return this.hDG;
    }

    public void yq(int i) {
        this.hDG = i;
    }

    public T getValue() {
        return this.hDF;
    }

    public void setValue(T t) {
        this.hDF = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

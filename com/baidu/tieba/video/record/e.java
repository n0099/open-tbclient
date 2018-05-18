package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class e<T> {
    private T gRn;
    private int gRo;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.gRn = t;
        this.gRo = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bxT() {
        return this.gRo;
    }

    public void ut(int i) {
        this.gRo = i;
    }

    public T getValue() {
        return this.gRn;
    }

    public void setValue(T t) {
        this.gRn = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

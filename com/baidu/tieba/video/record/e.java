package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class e<T> {
    private T gTN;
    private int gTO;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.gTN = t;
        this.gTO = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bCL() {
        return this.gTO;
    }

    public void vp(int i) {
        this.gTO = i;
    }

    public T getValue() {
        return this.gTN;
    }

    public void setValue(T t) {
        this.gTN = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

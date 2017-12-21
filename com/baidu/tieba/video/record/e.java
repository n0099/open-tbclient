package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class e<T> {
    private T gWB;
    private int gWC;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.gWB = t;
        this.gWC = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bDr() {
        return this.gWC;
    }

    public void vA(int i) {
        this.gWC = i;
    }

    public T getValue() {
        return this.gWB;
    }

    public void setValue(T t) {
        this.gWB = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

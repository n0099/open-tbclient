package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class e<T> {
    private T huS;
    private int huT;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.huS = t;
        this.huT = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bCY() {
        return this.huT;
    }

    public void wR(int i) {
        this.huT = i;
    }

    public T getValue() {
        return this.huS;
    }

    public void setValue(T t) {
        this.huS = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

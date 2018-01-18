package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class e<T> {
    private T htj;
    private int htk;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.htj = t;
        this.htk = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bCn() {
        return this.htk;
    }

    public void wS(int i) {
        this.htk = i;
    }

    public T getValue() {
        return this.htj;
    }

    public void setValue(T t) {
        this.htj = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

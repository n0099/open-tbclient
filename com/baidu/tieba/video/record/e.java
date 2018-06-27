package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class e<T> {
    private int hgU;
    private T jp;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.jp = t;
        this.hgU = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bDz() {
        return this.hgU;
    }

    public void uO(int i) {
        this.hgU = i;
    }

    public T getValue() {
        return this.jp;
    }

    public void setValue(T t) {
        this.jp = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

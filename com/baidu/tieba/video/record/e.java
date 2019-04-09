package com.baidu.tieba.video.record;
/* loaded from: classes5.dex */
public class e<T> {
    private int jaN;
    private T jp;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.jp = t;
        this.jaN = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int ckP() {
        return this.jaN;
    }

    public void Ay(int i) {
        this.jaN = i;
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

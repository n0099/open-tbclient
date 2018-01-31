package com.baidu.tieba.video.record;
/* loaded from: classes2.dex */
public class e<T> {
    private T htD;
    private int htE;
    private String mName;
    private int mType;

    public e() {
    }

    public e(int i, String str, T t, int i2) {
        this.mType = i;
        this.mName = str;
        this.htD = t;
        this.htE = i2;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public int bCp() {
        return this.htE;
    }

    public void wS(int i) {
        this.htE = i;
    }

    public T getValue() {
        return this.htD;
    }

    public void setValue(T t) {
        this.htD = t;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }
}

package com.baidu.ueg.encrypt.entity;
/* loaded from: classes.dex */
public class a {
    private String hMA;
    private EncryptAlgorithm hMz;

    public a(EncryptAlgorithm encryptAlgorithm, String str) {
        this.hMz = encryptAlgorithm;
        this.hMA = str;
    }

    public EncryptAlgorithm bIW() {
        return this.hMz;
    }

    public String bIX() {
        return this.hMA;
    }
}

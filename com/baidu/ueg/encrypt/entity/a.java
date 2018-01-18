package com.baidu.ueg.encrypt.entity;
/* loaded from: classes.dex */
public class a {
    private EncryptAlgorithm hMf;
    private String hMg;

    public a(EncryptAlgorithm encryptAlgorithm, String str) {
        this.hMf = encryptAlgorithm;
        this.hMg = str;
    }

    public EncryptAlgorithm bIU() {
        return this.hMf;
    }

    public String bIV() {
        return this.hMg;
    }
}

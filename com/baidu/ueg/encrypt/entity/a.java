package com.baidu.ueg.encrypt.entity;
/* loaded from: classes.dex */
public class a {
    private EncryptAlgorithm gIV;
    private String gIW;

    public a(EncryptAlgorithm encryptAlgorithm, String str) {
        this.gIV = encryptAlgorithm;
        this.gIW = str;
    }

    public EncryptAlgorithm bAK() {
        return this.gIV;
    }

    public String bAL() {
        return this.gIW;
    }
}

package com.baidu.ueg.encrypt.entity;
/* loaded from: classes6.dex */
public class a {
    private EncryptAlgorithm oKx;
    private String oKy;

    public a(EncryptAlgorithm encryptAlgorithm, String str) {
        this.oKx = encryptAlgorithm;
        this.oKy = str;
    }

    public EncryptAlgorithm ega() {
        return this.oKx;
    }

    public String egb() {
        return this.oKy;
    }
}

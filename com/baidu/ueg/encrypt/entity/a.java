package com.baidu.ueg.encrypt.entity;
/* loaded from: classes.dex */
public class a {
    private EncryptAlgorithm fKA;
    private String fKB;

    public a(EncryptAlgorithm encryptAlgorithm, String str) {
        this.fKA = encryptAlgorithm;
        this.fKB = str;
    }

    public EncryptAlgorithm bmK() {
        return this.fKA;
    }

    public String bmL() {
        return this.fKB;
    }
}

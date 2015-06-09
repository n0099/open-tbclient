package com.baidu.ueg.encrypt.entity;
/* loaded from: classes.dex */
public class a {
    private EncryptAlgorithm cDB;
    private String cDC;

    public a(EncryptAlgorithm encryptAlgorithm, String str) {
        this.cDB = encryptAlgorithm;
        this.cDC = str;
    }

    public EncryptAlgorithm atz() {
        return this.cDB;
    }

    public String atA() {
        return this.cDC;
    }
}

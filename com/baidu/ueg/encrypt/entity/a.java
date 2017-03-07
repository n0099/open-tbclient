package com.baidu.ueg.encrypt.entity;
/* loaded from: classes.dex */
public class a {
    private EncryptAlgorithm fRF;
    private String fRG;

    public a(EncryptAlgorithm encryptAlgorithm, String str) {
        this.fRF = encryptAlgorithm;
        this.fRG = str;
    }

    public EncryptAlgorithm bpg() {
        return this.fRF;
    }

    public String bph() {
        return this.fRG;
    }
}

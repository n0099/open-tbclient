package com.baidu.ueg.encrypt.entity;
/* loaded from: classes.dex */
public class a {
    private EncryptAlgorithm dtL;
    private String dtM;

    public a(EncryptAlgorithm encryptAlgorithm, String str) {
        this.dtL = encryptAlgorithm;
        this.dtM = str;
    }

    public EncryptAlgorithm aEM() {
        return this.dtL;
    }

    public String aEN() {
        return this.dtM;
    }
}

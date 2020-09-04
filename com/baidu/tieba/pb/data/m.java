package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class m {
    private String content;
    private String duringTime;
    private Bitmap kyb;
    private Bitmap kyc;
    private String kyd;
    private boolean kye;

    public Bitmap cWb() {
        return this.kyb;
    }

    public void E(Bitmap bitmap) {
        this.kyb = bitmap;
    }

    public Bitmap cWc() {
        return this.kyc;
    }

    public void F(Bitmap bitmap) {
        this.kyc = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String cWd() {
        return this.duringTime;
    }

    public void Nn(String str) {
        this.duringTime = str;
    }

    public String getThreadImgUrl() {
        return this.kyd;
    }

    public void No(String str) {
        this.kyd = str;
    }

    public boolean cWe() {
        return this.kye;
    }

    public void sD(boolean z) {
        this.kye = z;
    }
}

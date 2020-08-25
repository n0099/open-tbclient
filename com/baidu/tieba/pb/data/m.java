package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class m {
    private String content;
    private String duringTime;
    private Bitmap kxU;
    private Bitmap kxV;
    private String kxW;
    private boolean kxX;

    public Bitmap cWa() {
        return this.kxU;
    }

    public void E(Bitmap bitmap) {
        this.kxU = bitmap;
    }

    public Bitmap cWb() {
        return this.kxV;
    }

    public void F(Bitmap bitmap) {
        this.kxV = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String cWc() {
        return this.duringTime;
    }

    public void Nm(String str) {
        this.duringTime = str;
    }

    public String getThreadImgUrl() {
        return this.kxW;
    }

    public void Nn(String str) {
        this.kxW = str;
    }

    public boolean cWd() {
        return this.kxX;
    }

    public void sB(boolean z) {
        this.kxX = z;
    }
}

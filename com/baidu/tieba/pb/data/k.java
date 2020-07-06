package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class k {
    private String content;
    private String duringTime;
    private Bitmap jZU;
    private Bitmap jZV;
    private String jZW;
    private boolean jZX;

    public Bitmap cHC() {
        return this.jZU;
    }

    public void B(Bitmap bitmap) {
        this.jZU = bitmap;
    }

    public Bitmap cHD() {
        return this.jZV;
    }

    public void C(Bitmap bitmap) {
        this.jZV = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String cHE() {
        return this.duringTime;
    }

    public void JH(String str) {
        this.duringTime = str;
    }

    public String getThreadImgUrl() {
        return this.jZW;
    }

    public void JI(String str) {
        this.jZW = str;
    }

    public boolean cHF() {
        return this.jZX;
    }

    public void rp(boolean z) {
        this.jZX = z;
    }
}

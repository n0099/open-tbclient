package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class m {
    private String content;
    private String duringTime;
    private Bitmap kiC;
    private Bitmap kiD;
    private String kiE;
    private boolean kiF;

    public Bitmap cLm() {
        return this.kiC;
    }

    public void E(Bitmap bitmap) {
        this.kiC = bitmap;
    }

    public Bitmap cLn() {
        return this.kiD;
    }

    public void F(Bitmap bitmap) {
        this.kiD = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String cLo() {
        return this.duringTime;
    }

    public void Kt(String str) {
        this.duringTime = str;
    }

    public String getThreadImgUrl() {
        return this.kiE;
    }

    public void Ku(String str) {
        this.kiE = str;
    }

    public boolean cLp() {
        return this.kiF;
    }

    public void rU(boolean z) {
        this.kiF = z;
    }
}

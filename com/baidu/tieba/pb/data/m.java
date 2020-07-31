package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class m {
    private String content;
    private String duringTime;
    private Bitmap kiA;
    private Bitmap kiB;
    private String kiC;
    private boolean kiD;

    public Bitmap cLm() {
        return this.kiA;
    }

    public void E(Bitmap bitmap) {
        this.kiA = bitmap;
    }

    public Bitmap cLn() {
        return this.kiB;
    }

    public void F(Bitmap bitmap) {
        this.kiB = bitmap;
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
        return this.kiC;
    }

    public void Ku(String str) {
        this.kiC = str;
    }

    public boolean cLp() {
        return this.kiD;
    }

    public void rU(boolean z) {
        this.kiD = z;
    }
}

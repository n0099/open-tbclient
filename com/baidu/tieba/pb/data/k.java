package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class k {
    private String content;
    private String duringTime;
    private Bitmap jFe;
    private Bitmap jFf;
    private String jFg;
    private boolean jFh;

    public Bitmap cCV() {
        return this.jFe;
    }

    public void B(Bitmap bitmap) {
        this.jFe = bitmap;
    }

    public Bitmap cCW() {
        return this.jFf;
    }

    public void C(Bitmap bitmap) {
        this.jFf = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String cCX() {
        return this.duringTime;
    }

    public void Je(String str) {
        this.duringTime = str;
    }

    public String getThreadImgUrl() {
        return this.jFg;
    }

    public void Jf(String str) {
        this.jFg = str;
    }

    public boolean cCY() {
        return this.jFh;
    }

    public void rc(boolean z) {
        this.jFh = z;
    }
}

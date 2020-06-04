package com.baidu.tieba.pb.data;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class k {
    private String content;
    private String duringTime;
    private Bitmap jGk;
    private Bitmap jGl;
    private String jGm;
    private boolean jGn;

    public Bitmap cDl() {
        return this.jGk;
    }

    public void B(Bitmap bitmap) {
        this.jGk = bitmap;
    }

    public Bitmap cDm() {
        return this.jGl;
    }

    public void C(Bitmap bitmap) {
        this.jGl = bitmap;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String cDn() {
        return this.duringTime;
    }

    public void Jf(String str) {
        this.duringTime = str;
    }

    public String getThreadImgUrl() {
        return this.jGm;
    }

    public void Jg(String str) {
        this.jGm = str;
    }

    public boolean cDo() {
        return this.jGn;
    }

    public void rc(boolean z) {
        this.jGn = z;
    }
}

package com.baidu.tieba.video.localvideo;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class d {
    private String cuO;
    private long duration;
    private long gdk;
    private String gxe;
    private Bitmap gxf;
    private boolean gxg = false;
    private String mimeType;
    private int videoHeight;
    private String videoPath;
    private int videoWidth;

    public void sF(String str) {
        this.cuO = str;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public void sG(String str) {
        this.gxe = str;
    }

    public long getLastModified() {
        return this.gdk;
    }

    public void cL(long j) {
        this.gdk = j;
    }

    public synchronized Bitmap bwp() {
        return this.gxf;
    }

    public void s(Bitmap bitmap) {
        this.gxf = bitmap;
    }

    public void nd(boolean z) {
        this.gxg = z;
    }

    public boolean bwq() {
        return this.gxg;
    }
}

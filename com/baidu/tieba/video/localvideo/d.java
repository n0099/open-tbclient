package com.baidu.tieba.video.localvideo;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class d {
    private String cCu;
    private long duration;
    private String gGK;
    private Bitmap gGL;
    private boolean gGM = false;
    private long glW;
    private String mimeType;
    private int videoHeight;
    private String videoPath;
    private int videoWidth;

    public void tr(String str) {
        this.cCu = str;
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

    public void ts(String str) {
        this.gGK = str;
    }

    public long getLastModified() {
        return this.glW;
    }

    public void cM(long j) {
        this.glW = j;
    }

    public synchronized Bitmap bzC() {
        return this.gGL;
    }

    public void s(Bitmap bitmap) {
        this.gGL = bitmap;
    }

    public void mY(boolean z) {
        this.gGM = z;
    }

    public boolean bzD() {
        return this.gGM;
    }
}

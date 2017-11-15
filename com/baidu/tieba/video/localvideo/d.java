package com.baidu.tieba.video.localvideo;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class d {
    private String cCN;
    private long duration;
    private String gHS;
    private Bitmap gHT;
    private boolean gHU = false;
    private long gmY;
    private String mimeType;
    private int videoHeight;
    private String videoPath;
    private int videoWidth;

    public void tx(String str) {
        this.cCN = str;
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

    public void ty(String str) {
        this.gHS = str;
    }

    public long getLastModified() {
        return this.gmY;
    }

    public void cO(long j) {
        this.gmY = j;
    }

    public synchronized Bitmap bzO() {
        return this.gHT;
    }

    public void s(Bitmap bitmap) {
        this.gHT = bitmap;
    }

    public void ng(boolean z) {
        this.gHU = z;
    }

    public boolean bzP() {
        return this.gHU;
    }
}

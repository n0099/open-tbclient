package com.baidu.tieba.video.localvideo;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class d {
    private String cva;
    private long duration;
    private long gdz;
    private String gxt;
    private Bitmap gxu;
    private boolean gxv = false;
    private String mimeType;
    private int videoHeight;
    private String videoPath;
    private int videoWidth;

    public void sG(String str) {
        this.cva = str;
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

    public void sH(String str) {
        this.gxt = str;
    }

    public long getLastModified() {
        return this.gdz;
    }

    public void cK(long j) {
        this.gdz = j;
    }

    public synchronized Bitmap bwy() {
        return this.gxu;
    }

    public void s(Bitmap bitmap) {
        this.gxu = bitmap;
    }

    public void ne(boolean z) {
        this.gxv = z;
    }

    public boolean bwz() {
        return this.gxv;
    }
}

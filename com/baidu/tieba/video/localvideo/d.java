package com.baidu.tieba.video.localvideo;

import android.graphics.Bitmap;
/* loaded from: classes2.dex */
public class d {
    private String cva;
    private long duration;
    private long gdy;
    private String gxs;
    private Bitmap gxt;
    private boolean gxu = false;
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
        this.gxs = str;
    }

    public long getLastModified() {
        return this.gdy;
    }

    public void cK(long j) {
        this.gdy = j;
    }

    public synchronized Bitmap bwx() {
        return this.gxt;
    }

    public void s(Bitmap bitmap) {
        this.gxt = bitmap;
    }

    public void ne(boolean z) {
        this.gxu = z;
    }

    public boolean bwy() {
        return this.gxu;
    }
}

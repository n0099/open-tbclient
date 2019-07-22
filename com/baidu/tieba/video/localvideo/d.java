package com.baidu.tieba.video.localvideo;

import android.graphics.Bitmap;
/* loaded from: classes5.dex */
public class d {
    private long duration;
    private boolean hasLoaded = false;
    private String jzd;
    private long lastModified;
    private String mimeType;
    private Bitmap thumbnailBitmap;
    private int videoHeight;
    private String videoId;
    private String videoPath;
    private int videoWidth;

    public void setVideoId(String str) {
        this.videoId = str;
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

    public void FU(String str) {
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

    public void FV(String str) {
        this.jzd = str;
    }

    public long cvs() {
        return this.lastModified;
    }

    public void eD(long j) {
        this.lastModified = j;
    }

    public synchronized Bitmap cvt() {
        return this.thumbnailBitmap;
    }

    public void M(Bitmap bitmap) {
        this.thumbnailBitmap = bitmap;
    }

    public void rH(boolean z) {
        this.hasLoaded = z;
    }

    public boolean cvu() {
        return this.hasLoaded;
    }
}

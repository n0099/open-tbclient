package com.baidu.tieba.video.localvideo;
/* loaded from: classes8.dex */
public class b {
    private long duration;
    private boolean hasLoaded = false;
    private long lastModified;
    private String mimeType;
    private String nJT;
    private String videoId;
    private String videoPath;

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

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void UC(String str) {
        this.nJT = str;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void cp(long j) {
        this.lastModified = j;
    }
}

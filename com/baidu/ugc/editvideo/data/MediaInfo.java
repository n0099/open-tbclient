package com.baidu.ugc.editvideo.data;

import android.graphics.Bitmap;
import com.baidu.tieba.rkb;
/* loaded from: classes9.dex */
public class MediaInfo {
    public static final int minimumDuration = 3000;
    public long duration;
    public String durationText;
    public boolean hasLoaded = false;
    public long inStepVideoDuration = 0;
    public long lastModified;
    public String mimeType;
    public int rotation;
    public Bitmap thumbnailBitmap;
    public String thumbnailPath;
    public int videoHeight;
    public String videoId;
    public String videoPath;
    public int videoWidth;

    public long getDuration() {
        return this.duration;
    }

    public String getDurationText() {
        return this.durationText;
    }

    public long getInStepVideoDuration() {
        return this.inStepVideoDuration;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public int getRotation() {
        return this.rotation;
    }

    @Deprecated
    public synchronized Bitmap getThumbnailBitmap() {
        return this.thumbnailBitmap;
    }

    public String getThumbnailPath() {
        return this.thumbnailPath;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public String getVideoId() {
        return this.videoId;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public boolean hasLoaded() {
        return this.hasLoaded;
    }

    public boolean isMore3s() {
        if (this.duration >= 3000) {
            return true;
        }
        return false;
    }

    public boolean isSelectable() {
        long j = this.inStepVideoDuration / 1000;
        long j2 = this.duration / 1000;
        boolean isMore3s = isMore3s();
        boolean z = true;
        if (j > 0) {
            if (j2 >= j && isMore3s()) {
                isMore3s = true;
            } else {
                isMore3s = false;
            }
        }
        if (!rkb.a) {
            if (this.duration > 15000) {
                z = false;
            }
            return z;
        }
        return isMore3s;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setDurationText(String str) {
        this.durationText = str;
    }

    public void setHasLoaded(boolean z) {
        this.hasLoaded = z;
    }

    public void setInStepVideoDuration(long j) {
        this.inStepVideoDuration = j;
    }

    public void setLastModified(long j) {
        this.lastModified = j;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setRotation(int i) {
        this.rotation = i;
    }

    @Deprecated
    public void setThumbnailBitmap(Bitmap bitmap) {
        this.thumbnailBitmap = bitmap;
    }

    public void setThumbnailPath(String str) {
        this.thumbnailPath = str;
    }

    public void setVideoHeight(int i) {
        this.videoHeight = i;
    }

    public void setVideoId(String str) {
        this.videoId = str;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public void setVideoWidth(int i) {
        this.videoWidth = i;
    }
}

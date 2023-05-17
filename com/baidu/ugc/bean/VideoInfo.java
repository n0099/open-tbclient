package com.baidu.ugc.bean;

import android.media.MediaMetadataRetriever;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class VideoInfo implements Serializable {
    public int bitRate;
    public long cutDuration;
    public long cutPoint;
    public int duration;
    public int expHeight;
    public int expWidth;
    public int frameInterval;
    public int frameRate;
    public int height;
    public String path;
    public int rotation;
    public int width;

    public static VideoInfo getVideoInfo(String str) {
        VideoInfo videoInfo;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        VideoInfo videoInfo2 = null;
        try {
            mediaMetadataRetriever.setDataSource(str);
            videoInfo = new VideoInfo();
        } catch (Exception e) {
            e = e;
        }
        try {
            String extractMetadata = mediaMetadataRetriever.extractMetadata(24);
            String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
            String extractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
            String extractMetadata4 = mediaMetadataRetriever.extractMetadata(9);
            videoInfo.path = str;
            videoInfo.width = Integer.parseInt(extractMetadata2);
            videoInfo.height = Integer.parseInt(extractMetadata3);
            videoInfo.duration = Integer.parseInt(extractMetadata4);
            videoInfo.rotation = Integer.parseInt(extractMetadata);
            return videoInfo;
        } catch (Exception e2) {
            e = e2;
            videoInfo2 = videoInfo;
            e.printStackTrace();
            return videoInfo2;
        }
    }

    public String getInfo() {
        return "path:" + this.path + ", rotation:" + this.rotation + ", width:" + this.width + ", height:" + this.height + ", bitRate:" + this.bitRate + ", frameRate:" + this.frameRate + ", frameInterval:" + this.frameInterval + ", duration:" + this.duration + ", expWidth:" + this.expWidth + ", expHeight:" + this.expHeight + ", cutPoint:" + this.cutPoint + ", cutDuration:" + this.cutDuration;
    }
}

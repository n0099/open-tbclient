package com.baidu.tieba.play;

import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class ac {
    private int duration;
    private long eZl;
    private String eZm;
    private String videoUrl;

    public void c(VideoInfo videoInfo) {
        if (videoInfo != null) {
            this.videoUrl = videoInfo.video_url;
            this.eZl = videoInfo.video_length.intValue();
            this.duration = videoInfo.video_duration.intValue();
            this.eZm = videoInfo.video_width + "x" + videoInfo.video_height;
        }
    }

    public void d(com.baidu.tbadk.widget.richText.o oVar) {
        if (oVar != null) {
            this.videoUrl = oVar.getVideoUrl();
            this.eZl = oVar.IM();
            this.duration = oVar.getDuration();
            this.eZm = String.valueOf(oVar.getWidth()) + "x" + oVar.getHeight();
        }
    }

    public long baE() {
        return this.eZl;
    }

    public int getDuration() {
        return this.duration;
    }

    public String baF() {
        return this.eZm;
    }
}

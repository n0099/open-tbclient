package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import java.util.Iterator;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class av {
    private int duration;
    private long fgH;
    private String fgI;
    private String videoUrl;

    public void a(VideoInfo videoInfo, boolean z) {
        String str;
        String str2;
        String str3;
        VideoDesc videoDesc;
        if (videoInfo != null) {
            String str4 = videoInfo.video_url;
            String num = videoInfo.video_width.toString();
            String num2 = videoInfo.video_height.toString();
            if (z && videoInfo.video_select_flag.intValue() == 1 && !com.baidu.tbadk.core.util.x.t(videoInfo.video_desc)) {
                Iterator<VideoDesc> it = videoInfo.video_desc.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        videoDesc = null;
                        break;
                    }
                    videoDesc = it.next();
                    if (videoDesc != null && !StringUtils.isNull(videoDesc.video_url) && ((videoDesc.video_id.intValue() == 2 && com.baidu.adp.lib.util.i.gn()) || (videoDesc.video_id.intValue() == 3 && com.baidu.adp.lib.util.i.go()))) {
                        break;
                    }
                }
                if (videoDesc != null) {
                    str3 = videoDesc.video_url;
                    str2 = videoDesc.video_width;
                    str = videoDesc.video_height;
                    this.videoUrl = str3;
                    this.fgH = videoInfo.video_length.intValue();
                    this.duration = videoInfo.video_duration.intValue();
                    this.fgI = String.valueOf(str2) + "x" + str;
                }
            }
            str = num2;
            str2 = num;
            str3 = str4;
            this.videoUrl = str3;
            this.fgH = videoInfo.video_length.intValue();
            this.duration = videoInfo.video_duration.intValue();
            this.fgI = String.valueOf(str2) + "x" + str;
        }
    }

    public void c(VideoInfo videoInfo) {
        a(videoInfo, false);
    }

    public void e(com.baidu.tbadk.widget.richText.o oVar) {
        if (oVar != null) {
            this.videoUrl = oVar.getVideoUrl();
            this.fgH = oVar.IP();
            this.duration = oVar.getDuration();
            this.fgI = String.valueOf(oVar.getWidth()) + "x" + oVar.getHeight();
        }
    }

    public long bdc() {
        return this.fgH;
    }

    public int getDuration() {
        return this.duration;
    }

    public String bdd() {
        return this.fgI;
    }
}

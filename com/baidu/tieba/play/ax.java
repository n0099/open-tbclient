package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import java.util.Iterator;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class ax {
    private int duration;
    private long eTo;
    private String eTp;
    private String videoUrl;

    public void a(VideoInfo videoInfo, boolean z) {
        String str;
        if (videoInfo != null) {
            String str2 = videoInfo.video_url;
            videoInfo.video_width.toString();
            videoInfo.video_height.toString();
            if (z && videoInfo.video_select_flag.intValue() == 1 && !com.baidu.tbadk.core.util.x.r(videoInfo.video_desc)) {
                VideoDesc videoDesc = null;
                Iterator<VideoDesc> it = videoInfo.video_desc.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    VideoDesc next = it.next();
                    if (next != null && !StringUtils.isNull(next.video_url)) {
                        if (next.video_id.intValue() != 2 || !com.baidu.adp.lib.util.i.hl()) {
                            if (next.video_id.intValue() == 3 && com.baidu.adp.lib.util.i.hm()) {
                                videoDesc = next;
                                break;
                            }
                        } else {
                            videoDesc = next;
                            break;
                        }
                    }
                }
                if (videoDesc != null) {
                    str = videoDesc.video_url;
                    String str3 = videoDesc.video_width;
                    String str4 = videoDesc.video_height;
                    this.videoUrl = str;
                    this.eTo = videoInfo.video_length.intValue();
                    this.duration = videoInfo.video_duration.intValue();
                    this.eTp = videoInfo.video_width + "x" + videoInfo.video_height;
                }
            }
            str = str2;
            this.videoUrl = str;
            this.eTo = videoInfo.video_length.intValue();
            this.duration = videoInfo.video_duration.intValue();
            this.eTp = videoInfo.video_width + "x" + videoInfo.video_height;
        }
    }

    public void c(VideoInfo videoInfo) {
        a(videoInfo, false);
    }

    public void a(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            this.videoUrl = cVar.hls_url;
        }
    }

    public long aWK() {
        return this.eTo;
    }

    public int getDuration() {
        return this.duration;
    }

    public String aWL() {
        return this.eTp;
    }
}

package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import java.util.Iterator;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class u {
    private long cuU;
    private int duration;
    private String fxY;
    private String videoMd5;
    private String videoUrl;

    public void a(VideoInfo videoInfo, boolean z) {
        String str;
        if (videoInfo != null) {
            String str2 = videoInfo.video_url;
            videoInfo.video_width.toString();
            videoInfo.video_height.toString();
            if (z && videoInfo.video_select_flag.intValue() == 1 && !com.baidu.tbadk.core.util.v.u(videoInfo.video_desc)) {
                VideoDesc videoDesc = null;
                Iterator<VideoDesc> it = videoInfo.video_desc.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    VideoDesc next = it.next();
                    if (next != null && !StringUtils.isNull(next.video_url)) {
                        if (next.video_id.intValue() != 2 || !com.baidu.adp.lib.util.j.hi()) {
                            if (next.video_id.intValue() == 3 && com.baidu.adp.lib.util.j.hj()) {
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
                    this.cuU = videoInfo.video_length.intValue();
                    this.duration = videoInfo.video_duration.intValue();
                    this.fxY = videoInfo.video_width + "x" + videoInfo.video_height;
                    this.videoMd5 = videoInfo.video_md5;
                }
            }
            str = str2;
            this.videoUrl = str;
            this.cuU = videoInfo.video_length.intValue();
            this.duration = videoInfo.video_duration.intValue();
            this.fxY = videoInfo.video_width + "x" + videoInfo.video_height;
            this.videoMd5 = videoInfo.video_md5;
        }
    }

    public void d(VideoInfo videoInfo) {
        a(videoInfo, false);
    }

    public void b(com.baidu.tbadk.core.data.c cVar) {
        if (cVar != null) {
            this.videoUrl = cVar.hls_url;
        }
    }

    public long beC() {
        return this.cuU;
    }

    public int getDuration() {
        return this.duration;
    }

    public String beD() {
        return this.fxY;
    }
}

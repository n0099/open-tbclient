package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AlaInfoData;
import java.util.Iterator;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class u {
    private int duration;
    private String ggZ;
    private String videoMd5;
    private long videoSize;
    private String videoUrl;

    public void a(VideoInfo videoInfo, boolean z) {
        String str;
        if (videoInfo != null) {
            String str2 = videoInfo.video_url;
            videoInfo.video_width.toString();
            videoInfo.video_height.toString();
            if (z && videoInfo.video_select_flag.intValue() == 1 && !com.baidu.tbadk.core.util.w.z(videoInfo.video_desc)) {
                VideoDesc videoDesc = null;
                Iterator<VideoDesc> it = videoInfo.video_desc.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    VideoDesc next = it.next();
                    if (next != null && !StringUtils.isNull(next.video_url)) {
                        if (next.video_id.intValue() != 2 || !com.baidu.adp.lib.util.j.jF()) {
                            if (next.video_id.intValue() == 3 && com.baidu.adp.lib.util.j.jG()) {
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
                    this.videoSize = videoInfo.video_length.intValue();
                    this.duration = videoInfo.video_duration.intValue();
                    this.ggZ = videoInfo.video_width + "x" + videoInfo.video_height;
                    this.videoMd5 = videoInfo.video_md5;
                }
            }
            str = str2;
            this.videoUrl = str;
            this.videoSize = videoInfo.video_length.intValue();
            this.duration = videoInfo.video_duration.intValue();
            this.ggZ = videoInfo.video_width + "x" + videoInfo.video_height;
            this.videoMd5 = videoInfo.video_md5;
        }
    }

    public void g(VideoInfo videoInfo) {
        a(videoInfo, false);
    }

    public void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null) {
            this.videoUrl = alaInfoData.hls_url;
        }
    }

    public long bkL() {
        return this.videoSize;
    }

    public int getDuration() {
        return this.duration;
    }

    public String bkM() {
        return this.ggZ;
    }
}

package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.data.AlaInfoData;
import java.util.Iterator;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class v {
    private int duration;
    private String hYk;
    private int videoHeight;
    private String videoMd5;
    private long videoSize;
    private String videoUrl;
    private int videoWidth;

    public void a(VideoInfo videoInfo, boolean z) {
        String str;
        if (videoInfo != null) {
            String str2 = videoInfo.video_url;
            this.videoWidth = videoInfo.video_width.intValue();
            this.videoHeight = videoInfo.video_height.intValue();
            if (z && videoInfo.video_select_flag.intValue() == 1 && !com.baidu.tbadk.core.util.v.T(videoInfo.video_desc)) {
                VideoDesc videoDesc = null;
                Iterator<VideoDesc> it = videoInfo.video_desc.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    VideoDesc next = it.next();
                    if (next != null && !StringUtils.isNull(next.video_url)) {
                        if (next.video_id.intValue() != 2 || !com.baidu.adp.lib.util.j.kZ()) {
                            if (next.video_id.intValue() == 3 && com.baidu.adp.lib.util.j.la()) {
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
                    this.videoWidth = com.baidu.adp.lib.g.b.l(videoDesc.video_width, 0);
                    this.videoHeight = com.baidu.adp.lib.g.b.l(videoDesc.video_height, 0);
                    this.videoUrl = str;
                    this.videoSize = videoInfo.video_length.intValue();
                    this.duration = videoInfo.video_duration.intValue();
                    this.hYk = videoInfo.video_width + Config.EVENT_HEAT_X + videoInfo.video_height;
                    this.videoMd5 = videoInfo.video_md5;
                }
            }
            str = str2;
            this.videoUrl = str;
            this.videoSize = videoInfo.video_length.intValue();
            this.duration = videoInfo.video_duration.intValue();
            this.hYk = videoInfo.video_width + Config.EVENT_HEAT_X + videoInfo.video_height;
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

    public int getVideoWidth() {
        return this.videoWidth;
    }

    public int getVideoHeight() {
        return this.videoHeight;
    }

    public long bTN() {
        return this.videoSize;
    }

    public int getDuration() {
        return this.duration;
    }

    public String bTO() {
        return this.hYk;
    }
}

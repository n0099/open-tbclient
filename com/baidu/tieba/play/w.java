package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.AlaInfoData;
import java.util.Iterator;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class w {
    private long dFG;
    private int duration;
    private String gts;
    private String videoMd5;
    private String videoUrl;

    public void a(VideoInfo videoInfo, boolean z) {
        String str;
        if (videoInfo != null) {
            String str2 = videoInfo.video_url;
            videoInfo.video_width.toString();
            videoInfo.video_height.toString();
            if (z && videoInfo.video_select_flag.intValue() == 1 && !com.baidu.tbadk.core.util.v.E(videoInfo.video_desc)) {
                VideoDesc videoDesc = null;
                Iterator<VideoDesc> it = videoInfo.video_desc.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    VideoDesc next = it.next();
                    if (next != null && !StringUtils.isNull(next.video_url)) {
                        if (next.video_id.intValue() != 2 || !com.baidu.adp.lib.util.j.oJ()) {
                            if (next.video_id.intValue() == 3 && com.baidu.adp.lib.util.j.oK()) {
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
                    this.dFG = videoInfo.video_length.intValue();
                    this.duration = videoInfo.video_duration.intValue();
                    this.gts = videoInfo.video_width + "x" + videoInfo.video_height;
                    this.videoMd5 = videoInfo.video_md5;
                }
            }
            str = str2;
            this.videoUrl = str;
            this.dFG = videoInfo.video_length.intValue();
            this.duration = videoInfo.video_duration.intValue();
            this.gts = videoInfo.video_width + "x" + videoInfo.video_height;
            this.videoMd5 = videoInfo.video_md5;
        }
    }

    public void d(VideoInfo videoInfo) {
        a(videoInfo, false);
    }

    public void b(AlaInfoData alaInfoData) {
        if (alaInfoData != null) {
            this.videoUrl = alaInfoData.hls_url;
        }
    }

    public long bkz() {
        return this.dFG;
    }

    public int getDuration() {
        return this.duration;
    }

    public String bkA() {
        return this.gts;
    }
}

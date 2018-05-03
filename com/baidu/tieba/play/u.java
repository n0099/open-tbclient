package com.baidu.tieba.play;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.tbadk.core.data.AlaInfoData;
import java.util.Iterator;
import tbclient.VideoDesc;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class u {
    private int duration;
    private String fQh;
    private String videoMd5;
    private long videoSize;
    private String videoUrl;

    public void a(VideoInfo videoInfo, boolean z) {
        String str;
        if (videoInfo != null) {
            String str2 = videoInfo.video_url;
            videoInfo.video_width.toString();
            videoInfo.video_height.toString();
            if (z && videoInfo.video_select_flag.intValue() == 1 && !com.baidu.tbadk.core.util.v.w(videoInfo.video_desc)) {
                VideoDesc videoDesc = null;
                Iterator<VideoDesc> it = videoInfo.video_desc.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    VideoDesc next = it.next();
                    if (next != null && !StringUtils.isNull(next.video_url)) {
                        if (next.video_id.intValue() != 2 || !com.baidu.adp.lib.util.j.gQ()) {
                            if (next.video_id.intValue() == 3 && com.baidu.adp.lib.util.j.gR()) {
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
                    this.fQh = videoInfo.video_width + Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_X + videoInfo.video_height;
                    this.videoMd5 = videoInfo.video_md5;
                }
            }
            str = str2;
            this.videoUrl = str;
            this.videoSize = videoInfo.video_length.intValue();
            this.duration = videoInfo.video_duration.intValue();
            this.fQh = videoInfo.video_width + Constants.MSG_SDK_LUA_BRIDGE_ACCELERATION_X + videoInfo.video_height;
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

    public long bgT() {
        return this.videoSize;
    }

    public int getDuration() {
        return this.duration;
    }

    public String bgU() {
        return this.fQh;
    }
}

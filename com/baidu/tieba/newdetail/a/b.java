package com.baidu.tieba.newdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import java.util.Iterator;
import tbclient.ThreadInfo;
/* loaded from: classes21.dex */
public class b implements q {
    public int auV;
    public String cover;
    public String desc;
    public bw exA;
    public boolean iCv;
    public int likeNum;
    public int time;

    public b(ThreadInfo threadInfo, boolean z) {
        c(threadInfo);
        this.iCv = z;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.lcm;
    }

    private void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.exA = new bw();
            this.exA.a(threadInfo);
            this.desc = threadInfo.title;
            this.auV = threadInfo.reply_num.intValue();
            this.likeNum = threadInfo.agree_num.intValue();
            if (!y.isEmpty(this.exA.bmJ())) {
                Iterator<MediaData> it = this.exA.bmJ().iterator();
                while (it.hasNext()) {
                    MediaData next = it.next();
                    if (next != null && next.getType() == 3) {
                        this.cover = next.getPicUrl();
                        if (StringUtils.isNull(this.cover)) {
                            this.cover = next.getSmallUrl();
                        }
                        if (StringUtils.isNull(this.cover)) {
                            this.cover = next.getThumbnails_url();
                        }
                        if (StringUtils.isNull(this.cover)) {
                            this.cover = next.getSrc_pic();
                        }
                        if (!StringUtils.isNull(this.cover)) {
                            break;
                        }
                    }
                }
            }
            if (threadInfo.video_info != null) {
                this.time = threadInfo.video_info.video_duration.intValue();
            }
        }
    }
}

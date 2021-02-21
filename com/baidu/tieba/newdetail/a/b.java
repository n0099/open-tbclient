package com.baidu.tieba.newdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.y;
import java.util.Iterator;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class b implements n {
    public String cover;
    public String desc;
    public cb eJQ;
    public int iBA;
    public boolean jbD;
    public int likeNum;
    public int time;

    public b(ThreadInfo threadInfo, boolean z) {
        c(threadInfo);
        this.jbD = z;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return a.lzb;
    }

    private void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.eJQ = new cb();
            this.eJQ.a(threadInfo);
            this.desc = threadInfo.title;
            this.iBA = threadInfo.reply_num.intValue();
            this.likeNum = threadInfo.agree_num.intValue();
            if (!y.isEmpty(this.eJQ.bnZ())) {
                Iterator<MediaData> it = this.eJQ.bnZ().iterator();
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

package com.baidu.tieba.newdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.x;
import java.util.Iterator;
import tbclient.ThreadInfo;
/* loaded from: classes15.dex */
public class b implements q {
    public int aoJ;
    public String cover;
    public bv dLK;
    public String desc;
    public boolean isLast;
    public int likeNum;
    public int time;

    public b(ThreadInfo threadInfo, boolean z) {
        c(threadInfo);
        this.isLast = z;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.jWE;
    }

    private void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.dLK = new bv();
            this.dLK.a(threadInfo);
            this.desc = threadInfo.title;
            this.aoJ = threadInfo.reply_num.intValue();
            this.likeNum = threadInfo.agree_num.intValue();
            if (!x.isEmpty(this.dLK.aWu())) {
                Iterator<MediaData> it = this.dLK.aWu().iterator();
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

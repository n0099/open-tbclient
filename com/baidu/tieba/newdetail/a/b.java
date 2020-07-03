package com.baidu.tieba.newdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.w;
import java.util.Iterator;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public class b implements q {
    public int aoN;
    public String cover;
    public bu dLi;
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
        return a.jOe;
    }

    private void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.dLi = new bu();
            this.dLi.a(threadInfo);
            this.desc = threadInfo.title;
            this.aoN = threadInfo.reply_num.intValue();
            this.likeNum = threadInfo.agree_num.intValue();
            if (!w.isEmpty(this.dLi.aSy())) {
                Iterator<MediaData> it = this.dLi.aSy().iterator();
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

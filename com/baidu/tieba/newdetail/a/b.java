package com.baidu.tieba.newdetail.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.y;
import java.util.Iterator;
import tbclient.ThreadInfo;
/* loaded from: classes21.dex */
public class b implements q {
    public String cover;
    public String desc;
    public by eCR;
    public boolean iOe;
    public int inP;
    public int likeNum;
    public int time;

    public b(ThreadInfo threadInfo, boolean z) {
        c(threadInfo);
        this.iOe = z;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return a.lqg;
    }

    private void c(ThreadInfo threadInfo) {
        if (threadInfo != null) {
            this.eCR = new by();
            this.eCR.a(threadInfo);
            this.desc = threadInfo.title;
            this.inP = threadInfo.reply_num.intValue();
            this.likeNum = threadInfo.agree_num.intValue();
            if (!y.isEmpty(this.eCR.boY())) {
                Iterator<MediaData> it = this.eCR.boY().iterator();
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

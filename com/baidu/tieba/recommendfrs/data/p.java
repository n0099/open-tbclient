package com.baidu.tieba.recommendfrs.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class p implements com.baidu.tbadk.mvc.b.a {
    private int dXa;
    private long dXb;
    private long dXc;
    private long dcp;
    private String desc;
    private long excId;
    private String forumName;
    private long threadId;
    private int thread_type;
    private List<String> thumbnail;
    private String title;
    private ZhiBoInfoTW twzhibo_info;
    private int type;
    private boolean apY = true;
    public String dWN = "";
    public String dXd = "";
    public String abtest = "";

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0082: IGET  (r1v0 java.lang.Integer A[REMOVE]) = (r3v0 tbclient.ExcFrsPage.ExcellentThreadInfo) tbclient.ExcFrsPage.ExcellentThreadInfo.source java.lang.Integer)] */
    public p b(ExcellentThreadInfo excellentThreadInfo) {
        if (excellentThreadInfo != null) {
            if (excellentThreadInfo.rank != null) {
                this.dXc = excellentThreadInfo.rank.longValue();
            }
            if (excellentThreadInfo.excid != null) {
                this.excId = excellentThreadInfo.excid.longValue();
            }
            this.threadId = excellentThreadInfo.thread_id.longValue();
            this.title = excellentThreadInfo.title;
            this.type = excellentThreadInfo.frs_type.intValue();
            this.dXa = excellentThreadInfo.pb_type.intValue();
            this.desc = excellentThreadInfo._abstract;
            this.thumbnail = new ArrayList();
            if (excellentThreadInfo.thumbnail != null) {
                this.thumbnail.addAll(excellentThreadInfo.thumbnail);
            }
            this.forumName = excellentThreadInfo.forum_name;
            if (excellentThreadInfo.post_num != null) {
                this.dXb = excellentThreadInfo.post_num.longValue();
            }
            if (excellentThreadInfo.zansum != null) {
                this.dcp = excellentThreadInfo.zansum.longValue();
            }
            if (excellentThreadInfo.thread_type != null) {
                this.thread_type = excellentThreadInfo.thread_type.intValue();
            }
            this.twzhibo_info = excellentThreadInfo.twzhibo_info;
            this.dWN = excellentThreadInfo.tag_name;
            this.dXd = new StringBuilder().append(excellentThreadInfo.source).toString();
            this.abtest = excellentThreadInfo.abtest;
        }
        return this;
    }

    public long aMl() {
        return this.dXc;
    }

    public long aMm() {
        return this.dcp;
    }

    public long aMn() {
        return this.dXb;
    }

    public long aMo() {
        return this.excId;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getDesc() {
        return this.desc;
    }

    public List<String> aMp() {
        return this.thumbnail;
    }

    public String getForumName() {
        return this.forumName;
    }

    public int aMq() {
        return this.thread_type;
    }

    public ZhiBoInfoTW aMr() {
        return this.twzhibo_info;
    }

    public boolean aMj() {
        return this.apY;
    }

    public void setShowImage(boolean z) {
        this.apY = z;
    }

    public int aMs() {
        return this.dXa;
    }

    public long getThreadId() {
        return this.threadId;
    }
}

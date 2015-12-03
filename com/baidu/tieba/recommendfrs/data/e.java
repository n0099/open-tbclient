package com.baidu.tieba.recommendfrs.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class e {
    private long cyW;
    private String desc;
    private int diO;
    private long diP;
    private long diQ;
    private long excId;
    private String forumName;
    private long threadId;
    private int thread_type;
    private List<String> thumbnail;
    private String title;
    private ZhiBoInfoTW twzhibo_info;
    private int type;
    private boolean anE = true;
    public String diR = "";
    public String diS = "";
    public String abtest = "";

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Integer : 0x0082: IGET  (r1v0 java.lang.Integer A[REMOVE]) = (r3v0 tbclient.ExcFrsPage.ExcellentThreadInfo) tbclient.ExcFrsPage.ExcellentThreadInfo.source java.lang.Integer)] */
    public e b(ExcellentThreadInfo excellentThreadInfo) {
        if (excellentThreadInfo != null) {
            if (excellentThreadInfo.rank != null) {
                this.diQ = excellentThreadInfo.rank.longValue();
            }
            if (excellentThreadInfo.excid != null) {
                this.excId = excellentThreadInfo.excid.longValue();
            }
            this.threadId = excellentThreadInfo.thread_id.longValue();
            this.title = excellentThreadInfo.title;
            this.type = excellentThreadInfo.frs_type.intValue();
            this.diO = excellentThreadInfo.pb_type.intValue();
            this.desc = excellentThreadInfo._abstract;
            this.thumbnail = new ArrayList();
            if (excellentThreadInfo.thumbnail != null) {
                this.thumbnail.addAll(excellentThreadInfo.thumbnail);
            }
            this.forumName = excellentThreadInfo.forum_name;
            if (excellentThreadInfo.post_num != null) {
                this.diP = excellentThreadInfo.post_num.longValue();
            }
            if (excellentThreadInfo.zansum != null) {
                this.cyW = excellentThreadInfo.zansum.longValue();
            }
            if (excellentThreadInfo.thread_type != null) {
                this.thread_type = excellentThreadInfo.thread_type.intValue();
            }
            this.twzhibo_info = excellentThreadInfo.twzhibo_info;
            this.diR = excellentThreadInfo.tag_name;
            this.diS = new StringBuilder().append(excellentThreadInfo.source).toString();
            this.abtest = excellentThreadInfo.abtest;
        }
        return this;
    }

    public long awo() {
        return this.diQ;
    }

    public long awp() {
        return this.cyW;
    }

    public long awq() {
        return this.diP;
    }

    public long awr() {
        return this.excId;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public List<String> aws() {
        return this.thumbnail;
    }

    public String getForumName() {
        return this.forumName;
    }

    public int awt() {
        return this.thread_type;
    }

    public ZhiBoInfoTW awu() {
        return this.twzhibo_info;
    }

    public boolean awl() {
        return this.anE;
    }

    public void setShowImage(boolean z) {
        this.anE = z;
    }

    public int awv() {
        return this.diO;
    }

    public long getThreadId() {
        return this.threadId;
    }
}

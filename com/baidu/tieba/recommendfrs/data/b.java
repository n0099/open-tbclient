package com.baidu.tieba.recommendfrs.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FineFrsPage.FineThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class b extends i {
    private int cKg;
    private boolean cKh;
    private long cKi;
    private int cKj;
    private long cgv;
    private String desc;
    private String forumName;
    private long ftid;
    private int thread_type;
    private List<String> thumbnail;
    private String title;
    private ZhiBoInfoTW twzhibo_info;
    private int type;

    public b a(FineThreadInfo fineThreadInfo) {
        if (fineThreadInfo != null) {
            if (fineThreadInfo.forder != null) {
                this.cKj = fineThreadInfo.forder.intValue();
            }
            if (fineThreadInfo.ftid != null) {
                this.ftid = fineThreadInfo.ftid.longValue();
            }
            this.title = fineThreadInfo.title;
            if (fineThreadInfo.type != null) {
                this.type = fineThreadInfo.type.intValue();
            }
            this.desc = fineThreadInfo._abstract;
            this.thumbnail = new ArrayList();
            if (fineThreadInfo.thumbnail != null) {
                this.thumbnail.addAll(fineThreadInfo.thumbnail);
            }
            if (fineThreadInfo.publish_time != null) {
                this.cKg = fineThreadInfo.publish_time.intValue();
            }
            this.forumName = fineThreadInfo.fromfname;
            if (fineThreadInfo.threadsnum != null) {
                this.cKi = fineThreadInfo.threadsnum.longValue();
            }
            if (fineThreadInfo.zansum != null) {
                this.cgv = fineThreadInfo.zansum.longValue();
            }
            if (fineThreadInfo.thread_type != null) {
                this.thread_type = fineThreadInfo.thread_type.intValue();
            }
            this.twzhibo_info = fineThreadInfo.twzhibo_info;
        }
        return this;
    }

    public int aqA() {
        return this.cKj;
    }

    public long aqB() {
        return this.cgv;
    }

    public long aqC() {
        return this.cKi;
    }

    public long aqD() {
        return this.ftid;
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

    public List<String> aqE() {
        return this.thumbnail;
    }

    public int aqF() {
        return this.cKg;
    }

    public String getForumName() {
        return this.forumName;
    }

    public boolean aqG() {
        return this.cKh;
    }

    public void fR(boolean z) {
        this.cKh = z;
    }

    public int aqH() {
        return this.thread_type;
    }

    public ZhiBoInfoTW aqI() {
        return this.twzhibo_info;
    }
}

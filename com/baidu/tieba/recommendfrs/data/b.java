package com.baidu.tieba.recommendfrs.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FineFrsPage.FineThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class b extends i {
    private long btq;
    private int cIK;
    private boolean cIL;
    private long cIM;
    private int cIN;
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
                this.cIN = fineThreadInfo.forder.intValue();
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
                this.cIK = fineThreadInfo.publish_time.intValue();
            }
            this.forumName = fineThreadInfo.fromfname;
            if (fineThreadInfo.threadsnum != null) {
                this.cIM = fineThreadInfo.threadsnum.longValue();
            }
            if (fineThreadInfo.zansum != null) {
                this.btq = fineThreadInfo.zansum.longValue();
            }
            if (fineThreadInfo.thread_type != null) {
                this.thread_type = fineThreadInfo.thread_type.intValue();
            }
            this.twzhibo_info = fineThreadInfo.twzhibo_info;
        }
        return this;
    }

    public int apU() {
        return this.cIN;
    }

    public long apV() {
        return this.btq;
    }

    public long apW() {
        return this.cIM;
    }

    public long apX() {
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

    public List<String> apY() {
        return this.thumbnail;
    }

    public int apZ() {
        return this.cIK;
    }

    public String getForumName() {
        return this.forumName;
    }

    public boolean aqa() {
        return this.cIL;
    }

    public void fO(boolean z) {
        this.cIL = z;
    }

    public int aqb() {
        return this.thread_type;
    }

    public ZhiBoInfoTW aqc() {
        return this.twzhibo_info;
    }
}

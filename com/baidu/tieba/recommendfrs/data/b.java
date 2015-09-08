package com.baidu.tieba.recommendfrs.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FineFrsPage.FineThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class b extends i {
    private long bqe;
    private int cBj;
    private boolean cBk;
    private long cBl;
    private int cBm;
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
                this.cBm = fineThreadInfo.forder.intValue();
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
                this.cBj = fineThreadInfo.publish_time.intValue();
            }
            this.forumName = fineThreadInfo.fromfname;
            if (fineThreadInfo.threadsnum != null) {
                this.cBl = fineThreadInfo.threadsnum.longValue();
            }
            if (fineThreadInfo.zansum != null) {
                this.bqe = fineThreadInfo.zansum.longValue();
            }
            if (fineThreadInfo.thread_type != null) {
                this.thread_type = fineThreadInfo.thread_type.intValue();
            }
            this.twzhibo_info = fineThreadInfo.twzhibo_info;
        }
        return this;
    }

    public int anA() {
        return this.cBm;
    }

    public long anB() {
        return this.bqe;
    }

    public long anC() {
        return this.cBl;
    }

    public long anD() {
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

    public List<String> anE() {
        return this.thumbnail;
    }

    public int anF() {
        return this.cBj;
    }

    public String getForumName() {
        return this.forumName;
    }

    public boolean anG() {
        return this.cBk;
    }

    public void fD(boolean z) {
        this.cBk = z;
    }

    public int anH() {
        return this.thread_type;
    }

    public ZhiBoInfoTW anI() {
        return this.twzhibo_info;
    }
}

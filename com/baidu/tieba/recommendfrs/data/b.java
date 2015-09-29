package com.baidu.tieba.recommendfrs.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FineFrsPage.FineThreadInfo;
import tbclient.ZhiBoInfoTW;
/* loaded from: classes.dex */
public class b extends i {
    private long btf;
    private int cIl;
    private boolean cIm;
    private long cIn;
    private int cIo;
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
                this.cIo = fineThreadInfo.forder.intValue();
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
                this.cIl = fineThreadInfo.publish_time.intValue();
            }
            this.forumName = fineThreadInfo.fromfname;
            if (fineThreadInfo.threadsnum != null) {
                this.cIn = fineThreadInfo.threadsnum.longValue();
            }
            if (fineThreadInfo.zansum != null) {
                this.btf = fineThreadInfo.zansum.longValue();
            }
            if (fineThreadInfo.thread_type != null) {
                this.thread_type = fineThreadInfo.thread_type.intValue();
            }
            this.twzhibo_info = fineThreadInfo.twzhibo_info;
        }
        return this;
    }

    public int apS() {
        return this.cIo;
    }

    public long apT() {
        return this.btf;
    }

    public long apU() {
        return this.cIn;
    }

    public long apV() {
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

    public List<String> apW() {
        return this.thumbnail;
    }

    public int apX() {
        return this.cIl;
    }

    public String getForumName() {
        return this.forumName;
    }

    public boolean apY() {
        return this.cIm;
    }

    public void fO(boolean z) {
        this.cIm = z;
    }

    public int apZ() {
        return this.thread_type;
    }

    public ZhiBoInfoTW aqa() {
        return this.twzhibo_info;
    }
}

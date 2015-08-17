package com.baidu.tieba.recommendfrs.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FineFrsPage.FineThreadInfo;
/* loaded from: classes.dex */
public class b extends i {
    private long bpG;
    private int csR;
    private boolean csS;
    private long csT;
    private int csU;
    private String desc;
    private String forumName;
    private long ftid;
    private List<String> thumbnail;
    private String title;
    private int type;

    public b a(FineThreadInfo fineThreadInfo) {
        if (fineThreadInfo != null) {
            if (fineThreadInfo.forder != null) {
                this.csU = fineThreadInfo.forder.intValue();
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
                this.csR = fineThreadInfo.publish_time.intValue();
            }
            this.forumName = fineThreadInfo.fromfname;
            if (fineThreadInfo.threadsnum != null) {
                this.csT = fineThreadInfo.threadsnum.longValue();
            }
            if (fineThreadInfo.zansum != null) {
                this.bpG = fineThreadInfo.zansum.longValue();
            }
        }
        return this;
    }

    public int ajw() {
        return this.csU;
    }

    public long ajx() {
        return this.bpG;
    }

    public long ajy() {
        return this.csT;
    }

    public long ajz() {
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

    public List<String> ajA() {
        return this.thumbnail;
    }

    public int ajB() {
        return this.csR;
    }

    public String getForumName() {
        return this.forumName;
    }

    public boolean ajC() {
        return this.csS;
    }

    public void eR(boolean z) {
        this.csS = z;
    }
}

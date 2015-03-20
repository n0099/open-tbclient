package com.baidu.tieba.recommendfrs.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FineFrsPage.FineThreadInfo;
/* loaded from: classes.dex */
public class b {
    private int bXK;
    private int bXL;
    private boolean bXM;
    private String desc;
    private long ftid;
    private String tag;
    private List<String> thumbnail;
    private String title;
    private int type;

    public b a(FineThreadInfo fineThreadInfo) {
        if (fineThreadInfo != null) {
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
                this.bXK = fineThreadInfo.publish_time.intValue();
            }
            this.tag = fineThreadInfo.tag;
        }
        return this;
    }

    public long afA() {
        return this.ftid;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String qa() {
        return this.desc;
    }

    public List<String> afB() {
        return this.thumbnail;
    }

    public int afC() {
        return this.bXK;
    }

    public String getTag() {
        return this.tag;
    }

    public int afD() {
        return this.bXL;
    }

    public void hK(int i) {
        this.bXL = i;
    }

    public boolean afE() {
        return this.bXM;
    }

    public void en(boolean z) {
        this.bXM = z;
    }
}

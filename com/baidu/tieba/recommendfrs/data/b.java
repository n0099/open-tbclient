package com.baidu.tieba.recommendfrs.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.FineFrsPage.FineThreadInfo;
/* loaded from: classes.dex */
public class b extends h {
    private int cbW;
    private boolean cbX;
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
                this.cbW = fineThreadInfo.publish_time.intValue();
            }
            this.tag = fineThreadInfo.tag;
        }
        return this;
    }

    public long ahx() {
        return this.ftid;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String qG() {
        return this.desc;
    }

    public List<String> ahy() {
        return this.thumbnail;
    }

    public int ahz() {
        return this.cbW;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean ahA() {
        return this.cbX;
    }

    public void eA(boolean z) {
        this.cbX = z;
    }
}

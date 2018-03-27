package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.ActivityConfig;
/* loaded from: classes.dex */
public class e {
    private long gXP;
    private String gXL = "";
    private String gXM = "";
    private String gXN = "";
    private String gXO = "";
    private int type = 1;

    public void a(ActivityConfig activityConfig) {
        this.gXL = activityConfig.agree_icon;
        this.gXN = activityConfig.agreed_icon;
        this.gXM = activityConfig.night_agree_icon;
        this.gXO = activityConfig.night_agreed_icon;
        this.gXP = activityConfig.activity_id.longValue();
        this.type = activityConfig.type.intValue();
    }

    public long buJ() {
        return this.gXP;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}

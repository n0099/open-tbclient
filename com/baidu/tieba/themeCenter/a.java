package com.baidu.tieba.themeCenter;

import tbclient.ThemeCardPropMain;
/* loaded from: classes9.dex */
public class a {
    public static long nFo = 1350000;
    private String activityUrl;
    private long cardId;
    private int dailyPrevilegeStatus = 0;
    private String description;
    private int freeUserLevel;
    private int inUse;
    private String lmL;
    private String nFp;
    private String nFq;
    private int nFr;
    private String title;

    public void a(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain != null) {
            this.cardId = themeCardPropMain.props_id.longValue();
            this.title = themeCardPropMain.title;
            this.description = themeCardPropMain.description;
            this.nFp = themeCardPropMain.example_url;
            this.lmL = themeCardPropMain.permission;
            this.nFq = themeCardPropMain.props_state_img;
            this.inUse = themeCardPropMain.in_use.intValue();
            this.freeUserLevel = themeCardPropMain.free_user_level.intValue();
            this.activityUrl = themeCardPropMain.activity_url;
            this.nFr = themeCardPropMain.is_finished.intValue();
        }
    }

    public long getCardId() {
        return this.cardId;
    }

    public void setCardId(long j) {
        this.cardId = j;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String dQO() {
        return this.nFp;
    }

    public void TR(String str) {
        this.nFp = str;
    }

    public String dQP() {
        return this.lmL;
    }

    public void TS(String str) {
        this.lmL = str;
    }

    public String dQQ() {
        return this.nFq;
    }

    public void TT(String str) {
        this.nFq = str;
    }

    public int dQR() {
        return this.inUse;
    }

    public void Kd(int i) {
        this.inUse = i;
    }

    public int getFreeUserLevel() {
        return this.freeUserLevel;
    }

    public void setFreeUserLevel(int i) {
        this.freeUserLevel = i;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public int dQS() {
        return this.nFr;
    }

    public void Ke(int i) {
        this.nFr = i;
    }

    public void setDailyPrevilegeStatus(int i) {
        this.dailyPrevilegeStatus = i;
    }

    public int getDailyPrevilegeStatus() {
        return this.dailyPrevilegeStatus;
    }
}

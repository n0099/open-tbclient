package com.baidu.tieba.themeCenter;

import tbclient.ThemeCardPropMain;
/* loaded from: classes9.dex */
public class a {
    public static long nFO = 1350000;
    private String activityUrl;
    private long cardId;
    private int dailyPrevilegeStatus = 0;
    private String description;
    private int freeUserLevel;
    private int inUse;
    private String lmZ;
    private String nFP;
    private String nFQ;
    private int nFR;
    private String title;

    public void a(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain != null) {
            this.cardId = themeCardPropMain.props_id.longValue();
            this.title = themeCardPropMain.title;
            this.description = themeCardPropMain.description;
            this.nFP = themeCardPropMain.example_url;
            this.lmZ = themeCardPropMain.permission;
            this.nFQ = themeCardPropMain.props_state_img;
            this.inUse = themeCardPropMain.in_use.intValue();
            this.freeUserLevel = themeCardPropMain.free_user_level.intValue();
            this.activityUrl = themeCardPropMain.activity_url;
            this.nFR = themeCardPropMain.is_finished.intValue();
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

    public String dQW() {
        return this.nFP;
    }

    public void Ud(String str) {
        this.nFP = str;
    }

    public String dQX() {
        return this.lmZ;
    }

    public void Ue(String str) {
        this.lmZ = str;
    }

    public String dQY() {
        return this.nFQ;
    }

    public void Uf(String str) {
        this.nFQ = str;
    }

    public int dQZ() {
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

    public int dRa() {
        return this.nFR;
    }

    public void Ke(int i) {
        this.nFR = i;
    }

    public void setDailyPrevilegeStatus(int i) {
        this.dailyPrevilegeStatus = i;
    }

    public int getDailyPrevilegeStatus() {
        return this.dailyPrevilegeStatus;
    }
}

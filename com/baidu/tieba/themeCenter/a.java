package com.baidu.tieba.themeCenter;

import tbclient.ThemeCardPropMain;
/* loaded from: classes8.dex */
public class a {
    public static long nvD = 1350000;
    private String activityUrl;
    private long cardId;
    private int dailyPrevilegeStatus = 0;
    private String description;
    private int freeUserLevel;
    private int inUse;
    private String leJ;
    private String nvE;
    private String nvF;
    private int nvG;
    private String title;

    public void a(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain != null) {
            this.cardId = themeCardPropMain.props_id.longValue();
            this.title = themeCardPropMain.title;
            this.description = themeCardPropMain.description;
            this.nvE = themeCardPropMain.example_url;
            this.leJ = themeCardPropMain.permission;
            this.nvF = themeCardPropMain.props_state_img;
            this.inUse = themeCardPropMain.in_use.intValue();
            this.freeUserLevel = themeCardPropMain.free_user_level.intValue();
            this.activityUrl = themeCardPropMain.activity_url;
            this.nvG = themeCardPropMain.is_finished.intValue();
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

    public String dOD() {
        return this.nvE;
    }

    public void ST(String str) {
        this.nvE = str;
    }

    public String dOE() {
        return this.leJ;
    }

    public void SU(String str) {
        this.leJ = str;
    }

    public String dOF() {
        return this.nvF;
    }

    public void SV(String str) {
        this.nvF = str;
    }

    public int dOG() {
        return this.inUse;
    }

    public void JJ(int i) {
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

    public int dOH() {
        return this.nvG;
    }

    public void JK(int i) {
        this.nvG = i;
    }

    public void setDailyPrevilegeStatus(int i) {
        this.dailyPrevilegeStatus = i;
    }

    public int getDailyPrevilegeStatus() {
        return this.dailyPrevilegeStatus;
    }
}

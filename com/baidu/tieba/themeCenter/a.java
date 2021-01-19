package com.baidu.tieba.themeCenter;

import tbclient.ThemeCardPropMain;
/* loaded from: classes8.dex */
public class a {
    public static long nvE = 1350000;
    private String activityUrl;
    private long cardId;
    private int dailyPrevilegeStatus = 0;
    private String description;
    private int freeUserLevel;
    private int inUse;
    private String leJ;
    private String nvF;
    private String nvG;
    private int nvH;
    private String title;

    public void a(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain != null) {
            this.cardId = themeCardPropMain.props_id.longValue();
            this.title = themeCardPropMain.title;
            this.description = themeCardPropMain.description;
            this.nvF = themeCardPropMain.example_url;
            this.leJ = themeCardPropMain.permission;
            this.nvG = themeCardPropMain.props_state_img;
            this.inUse = themeCardPropMain.in_use.intValue();
            this.freeUserLevel = themeCardPropMain.free_user_level.intValue();
            this.activityUrl = themeCardPropMain.activity_url;
            this.nvH = themeCardPropMain.is_finished.intValue();
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
        return this.nvF;
    }

    public void SU(String str) {
        this.nvF = str;
    }

    public String dOE() {
        return this.leJ;
    }

    public void SV(String str) {
        this.leJ = str;
    }

    public String dOF() {
        return this.nvG;
    }

    public void SW(String str) {
        this.nvG = str;
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
        return this.nvH;
    }

    public void JK(int i) {
        this.nvH = i;
    }

    public void setDailyPrevilegeStatus(int i) {
        this.dailyPrevilegeStatus = i;
    }

    public int getDailyPrevilegeStatus() {
        return this.dailyPrevilegeStatus;
    }
}

package com.baidu.tieba.themeCenter;

import tbclient.ThemeCardPropMain;
/* loaded from: classes8.dex */
public class a {
    public static long nHU = 1350000;
    private String activityUrl;
    private long cardId;
    private int dailyPrevilegeStatus = 0;
    private String description;
    private int freeUserLevel;
    private int inUse;
    private String lpg;
    private String nHV;
    private String nHW;
    private int nHX;
    private String title;

    public void a(ThemeCardPropMain themeCardPropMain) {
        if (themeCardPropMain != null) {
            this.cardId = themeCardPropMain.props_id.longValue();
            this.title = themeCardPropMain.title;
            this.description = themeCardPropMain.description;
            this.nHV = themeCardPropMain.example_url;
            this.lpg = themeCardPropMain.permission;
            this.nHW = themeCardPropMain.props_state_img;
            this.inUse = themeCardPropMain.in_use.intValue();
            this.freeUserLevel = themeCardPropMain.free_user_level.intValue();
            this.activityUrl = themeCardPropMain.activity_url;
            this.nHX = themeCardPropMain.is_finished.intValue();
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

    public String dRf() {
        return this.nHV;
    }

    public void Uk(String str) {
        this.nHV = str;
    }

    public String dRg() {
        return this.lpg;
    }

    public void Ul(String str) {
        this.lpg = str;
    }

    public String dRh() {
        return this.nHW;
    }

    public void Um(String str) {
        this.nHW = str;
    }

    public int dRi() {
        return this.inUse;
    }

    public void Ki(int i) {
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

    public int dRj() {
        return this.nHX;
    }

    public void Kj(int i) {
        this.nHX = i;
    }

    public void setDailyPrevilegeStatus(int i) {
        this.dailyPrevilegeStatus = i;
    }

    public int getDailyPrevilegeStatus() {
        return this.dailyPrevilegeStatus;
    }
}

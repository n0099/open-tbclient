package com.baidu.tieba.tbadkCore;

import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class g {
    private String icon;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void ob(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        setType(starEnter.type.intValue());
        setUrl(starEnter.url);
        ob(starEnter.weight.intValue());
    }
}

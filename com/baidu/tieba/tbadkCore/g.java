package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes6.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    private int fJL;
    private String hbt;
    private int hbu;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int bzm() {
        return this.hbu;
    }

    public void uG(int i) {
        this.hbu = i;
    }

    public int bzn() {
        return this.fJL;
    }

    public void uH(int i) {
        this.fJL = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void uI(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void uJ(int i) {
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

    public String bzo() {
        return this.obj_id;
    }

    public String bzp() {
        return this.hbt;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        uJ(starEnter.type.intValue());
        setUrl(starEnter.url);
        uI(starEnter.weight.intValue());
        uH(starEnter.rank_num.intValue());
        uG(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.hbt = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    private int hkq;
    private String iDW;
    private int iDX;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int cdt() {
        return this.iDX;
    }

    public void ze(int i) {
        this.iDX = i;
    }

    public int cdu() {
        return this.hkq;
    }

    public void zf(int i) {
        this.hkq = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void zg(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void zh(int i) {
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

    public String cdv() {
        return this.obj_id;
    }

    public String cdw() {
        return this.iDW;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        zh(starEnter.type.intValue());
        setUrl(starEnter.url);
        zg(starEnter.weight.intValue());
        zf(starEnter.rank_num.intValue());
        ze(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.iDW = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

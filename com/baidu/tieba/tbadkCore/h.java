package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    private int hkp;
    private String iDV;
    private int iDW;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int cdt() {
        return this.iDW;
    }

    public void ze(int i) {
        this.iDW = i;
    }

    public int cdu() {
        return this.hkp;
    }

    public void zf(int i) {
        this.hkp = i;
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
        return this.iDV;
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
        this.iDV = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

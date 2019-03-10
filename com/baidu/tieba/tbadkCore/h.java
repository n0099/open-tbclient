package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    private int hkD;
    private String iEt;
    private int iEu;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int cdv() {
        return this.iEu;
    }

    public void zi(int i) {
        this.iEu = i;
    }

    public int cdw() {
        return this.hkD;
    }

    public void zj(int i) {
        this.hkD = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void zk(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void zl(int i) {
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

    public String cdx() {
        return this.obj_id;
    }

    public String cdy() {
        return this.iEt;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        zl(starEnter.type.intValue());
        setUrl(starEnter.url);
        zk(starEnter.weight.intValue());
        zj(starEnter.rank_num.intValue());
        zi(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.iEt = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

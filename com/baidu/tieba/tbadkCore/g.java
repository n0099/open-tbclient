package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes2.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    private String eWE;
    private int fsS;
    private int gKb;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int bvr() {
        return this.gKb;
    }

    public void ts(int i) {
        this.gKb = i;
    }

    public int bvs() {
        return this.fsS;
    }

    public void tt(int i) {
        this.fsS = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void tu(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void tv(int i) {
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

    public String bvt() {
        return this.obj_id;
    }

    public String aUt() {
        return this.eWE;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        tv(starEnter.type.intValue());
        setUrl(starEnter.url);
        tu(starEnter.weight.intValue());
        tt(starEnter.rank_num.intValue());
        ts(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.eWE = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

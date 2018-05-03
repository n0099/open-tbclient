package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes2.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    private String eGl;
    private int fcv;
    private int gtG;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int bpS() {
        return this.gtG;
    }

    public void sX(int i) {
        this.gtG = i;
    }

    public int bpT() {
        return this.fcv;
    }

    public void sY(int i) {
        this.fcv = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void sZ(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void ta(int i) {
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

    public String bpU() {
        return this.obj_id;
    }

    public String aOQ() {
        return this.eGl;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        ta(starEnter.type.intValue());
        setUrl(starEnter.url);
        sZ(starEnter.weight.intValue());
        sY(starEnter.rank_num.intValue());
        sX(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.eGl = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

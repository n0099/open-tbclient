package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes2.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    private String eHt;
    private int fdC;
    private int guK;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int bpQ() {
        return this.guK;
    }

    public void sW(int i) {
        this.guK = i;
    }

    public int bpR() {
        return this.fdC;
    }

    public void sX(int i) {
        this.fdC = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void sY(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void sZ(int i) {
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

    public String bpS() {
        return this.obj_id;
    }

    public String aOQ() {
        return this.eHt;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        sZ(starEnter.type.intValue());
        setUrl(starEnter.url);
        sY(starEnter.weight.intValue());
        sX(starEnter.rank_num.intValue());
        sW(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.eHt = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

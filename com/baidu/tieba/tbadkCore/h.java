package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class h implements com.baidu.adp.widget.ListView.i {
    private int fHT;
    private String flL;
    private int gYm;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int buL() {
        return this.gYm;
    }

    public void vv(int i) {
        this.gYm = i;
    }

    public int buM() {
        return this.fHT;
    }

    public void vw(int i) {
        this.fHT = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void vx(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void vy(int i) {
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

    public String buN() {
        return this.obj_id;
    }

    public String aTT() {
        return this.flL;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        vy(starEnter.type.intValue());
        setUrl(starEnter.url);
        vx(starEnter.weight.intValue());
        vw(starEnter.rank_num.intValue());
        vv(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.flL = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

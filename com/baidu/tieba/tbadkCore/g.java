package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes2.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    private int fte;
    private String gKX;
    private int gKY;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int btU() {
        return this.gKY;
    }

    public void tq(int i) {
        this.gKY = i;
    }

    public int btV() {
        return this.fte;
    }

    public void tr(int i) {
        this.fte = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void ts(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void tt(int i) {
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

    public String btW() {
        return this.obj_id;
    }

    public String btX() {
        return this.gKX;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        tt(starEnter.type.intValue());
        setUrl(starEnter.url);
        ts(starEnter.weight.intValue());
        tr(starEnter.rank_num.intValue());
        tq(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.gKX = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

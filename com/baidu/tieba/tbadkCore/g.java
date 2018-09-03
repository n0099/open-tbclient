package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes2.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    private int fsX;
    private String gKZ;
    private int gLa;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int btV() {
        return this.gLa;
    }

    public void tq(int i) {
        this.gLa = i;
    }

    public int btW() {
        return this.fsX;
    }

    public void tr(int i) {
        this.fsX = i;
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

    public String btX() {
        return this.obj_id;
    }

    public String btY() {
        return this.gKZ;
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
        this.gKZ = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

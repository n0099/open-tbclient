package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes6.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    private int fIm;
    private String gZV;
    private int gZW;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int bzQ() {
        return this.gZW;
    }

    public void un(int i) {
        this.gZW = i;
    }

    public int bzR() {
        return this.fIm;
    }

    public void uo(int i) {
        this.fIm = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void up(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void uq(int i) {
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

    public String bzS() {
        return this.obj_id;
    }

    public String bzT() {
        return this.gZV;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        uq(starEnter.type.intValue());
        setUrl(starEnter.url);
        up(starEnter.weight.intValue());
        uo(starEnter.rank_num.intValue());
        un(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.gZV = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

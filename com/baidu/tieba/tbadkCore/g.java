package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes6.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    private int fUq;
    private String hmB;
    private int hmC;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int bCG() {
        return this.hmC;
    }

    public void vs(int i) {
        this.hmC = i;
    }

    public int bCH() {
        return this.fUq;
    }

    public void vt(int i) {
        this.fUq = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void vu(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void vv(int i) {
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

    public String bCI() {
        return this.obj_id;
    }

    public String bCJ() {
        return this.hmB;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        vv(starEnter.type.intValue());
        setUrl(starEnter.url);
        vu(starEnter.weight.intValue());
        vt(starEnter.rank_num.intValue());
        vs(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.hmB = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes6.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    private int fUr;
    private String hmC;
    private int hmD;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int bCG() {
        return this.hmD;
    }

    public void vs(int i) {
        this.hmD = i;
    }

    public int bCH() {
        return this.fUr;
    }

    public void vt(int i) {
        this.fUr = i;
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
        return this.hmC;
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
        this.hmC = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes2.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    private int fAK;
    private String gSA;
    private int gSB;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int bwB() {
        return this.gSB;
    }

    public void tQ(int i) {
        this.gSB = i;
    }

    public int bwC() {
        return this.fAK;
    }

    public void tR(int i) {
        this.fAK = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void tS(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void tT(int i) {
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

    public String bwD() {
        return this.obj_id;
    }

    public String bwE() {
        return this.gSA;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        tT(starEnter.type.intValue());
        setUrl(starEnter.url);
        tS(starEnter.weight.intValue());
        tR(starEnter.rank_num.intValue());
        tQ(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.gSA = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

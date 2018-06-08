package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes2.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    private String eSM;
    private int foY;
    private int gGi;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int buR() {
        return this.gGi;
    }

    public void ti(int i) {
        this.gGi = i;
    }

    public int buS() {
        return this.foY;
    }

    public void tj(int i) {
        this.foY = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void tk(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void tl(int i) {
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

    public String buT() {
        return this.obj_id;
    }

    public String aTM() {
        return this.eSM;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        tl(starEnter.type.intValue());
        setUrl(starEnter.url);
        tk(starEnter.weight.intValue());
        tj(starEnter.rank_num.intValue());
        ti(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.eSM = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

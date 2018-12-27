package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes6.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    private int fTt;
    private String hlx;
    private int hly;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int bBX() {
        return this.hly;
    }

    public void vp(int i) {
        this.hly = i;
    }

    public int bBY() {
        return this.fTt;
    }

    public void vq(int i) {
        this.fTt = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void vr(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void vs(int i) {
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

    public String bBZ() {
        return this.obj_id;
    }

    public String bCa() {
        return this.hlx;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        vs(starEnter.type.intValue());
        setUrl(starEnter.url);
        vr(starEnter.weight.intValue());
        vq(starEnter.rank_num.intValue());
        vp(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.hlx = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

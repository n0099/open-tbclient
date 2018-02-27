package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.i {
    private int fHD;
    private String flv;
    private int gXR;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int buJ() {
        return this.gXR;
    }

    public void vv(int i) {
        this.gXR = i;
    }

    public int buK() {
        return this.fHD;
    }

    public void vw(int i) {
        this.fHD = i;
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

    public String buL() {
        return this.obj_id;
    }

    public String aTS() {
        return this.flv;
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
        this.flv = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.i {
    private int fHO;
    private String flH;
    private int gYg;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int buK() {
        return this.gYg;
    }

    public void vu(int i) {
        this.gYg = i;
    }

    public int buL() {
        return this.fHO;
    }

    public void vv(int i) {
        this.fHO = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void vw(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void vx(int i) {
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

    public String buM() {
        return this.obj_id;
    }

    public String aTT() {
        return this.flH;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        vx(starEnter.type.intValue());
        setUrl(starEnter.url);
        vw(starEnter.weight.intValue());
        vv(starEnter.rank_num.intValue());
        vu(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.flH = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

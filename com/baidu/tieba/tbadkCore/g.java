package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes6.dex */
public class g implements com.baidu.adp.widget.ListView.h {
    private int fQB;
    private String him;
    private int hin;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int bBg() {
        return this.hin;
    }

    public void vc(int i) {
        this.hin = i;
    }

    public int bBh() {
        return this.fQB;
    }

    public void vd(int i) {
        this.fQB = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void ve(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void vf(int i) {
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

    public String bBi() {
        return this.obj_id;
    }

    public String bBj() {
        return this.him;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        vf(starEnter.type.intValue());
        setUrl(starEnter.url);
        ve(starEnter.weight.intValue());
        vd(starEnter.rank_num.intValue());
        vc(starEnter.bazhu_mark.intValue());
        this.obj_id = starEnter.obj_id;
        this.him = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

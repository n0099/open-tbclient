package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    private int eGl;
    private String ebZ;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int aQr() {
        return this.eGl;
    }

    public void td(int i) {
        this.eGl = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void te(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void tf(int i) {
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

    public String brd() {
        return this.obj_id;
    }

    public String aHd() {
        return this.ebZ;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        tf(starEnter.type.intValue());
        setUrl(starEnter.url);
        te(starEnter.weight.intValue());
        td(starEnter.rank_num.intValue());
        this.obj_id = starEnter.obj_id;
        this.ebZ = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class e implements com.baidu.adp.widget.ListView.f {
    private int eFB;
    private String ejC;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int aPJ() {
        return this.eFB;
    }

    public void th(int i) {
        this.eFB = i;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void ti(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void tj(int i) {
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

    public String bqw() {
        return this.obj_id;
    }

    public String aIW() {
        return this.ejC;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        tj(starEnter.type.intValue());
        setUrl(starEnter.url);
        ti(starEnter.weight.intValue());
        th(starEnter.rank_num.intValue());
        this.obj_id = starEnter.obj_id;
        this.ejC = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

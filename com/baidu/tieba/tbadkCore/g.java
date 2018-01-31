package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class g implements com.baidu.adp.widget.ListView.i {
    private int fEr;
    private String fif;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int aZo() {
        return this.fEr;
    }

    public void vv(int i) {
        this.fEr = i;
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

    public String btx() {
        return this.obj_id;
    }

    public String aSk() {
        return this.fif;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        vx(starEnter.type.intValue());
        setUrl(starEnter.url);
        vw(starEnter.weight.intValue());
        vv(starEnter.rank_num.intValue());
        this.obj_id = starEnter.obj_id;
        this.fif = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

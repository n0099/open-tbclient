package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.q {
    public static final String lLl = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private String icon;
    private int kil;
    private String lLm;
    private int lLn;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int dko() {
        return this.lLn;
    }

    public void Fj(int i) {
        this.lLn = i;
    }

    public int dkp() {
        return this.kil;
    }

    public void Fk(int i) {
        this.kil = i;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setWeight(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int dkq() {
        return this.type;
    }

    public void Fl(int i) {
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

    public String dkr() {
        return this.obj_id;
    }

    public String dks() {
        return this.lLm;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        Fl(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        Fk(starEnter.rank_num.intValue());
        Fj(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.lLn == 1) {
            this.title = lLl;
        }
        this.obj_id = starEnter.obj_id;
        this.lLm = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

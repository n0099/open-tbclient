package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final String kgt = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private int iEf;
    private String icon;
    private String kgu;
    private int kgv;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int cKD() {
        return this.kgv;
    }

    public void Cv(int i) {
        this.kgv = i;
    }

    public int cKE() {
        return this.iEf;
    }

    public void Cw(int i) {
        this.iEf = i;
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

    public int cKF() {
        return this.type;
    }

    public void Cx(int i) {
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

    public String cKG() {
        return this.obj_id;
    }

    public String cKH() {
        return this.kgu;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        Cx(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        Cw(starEnter.rank_num.intValue());
        Cv(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.kgv == 1) {
            this.title = kgt;
        }
        this.obj_id = starEnter.obj_id;
        this.kgu = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

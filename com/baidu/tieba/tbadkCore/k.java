package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.m {
    public static final String kQy = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private String icon;
    private int jol;
    private int kQA;
    private String kQz;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int cVz() {
        return this.kQA;
    }

    public void CZ(int i) {
        this.kQA = i;
    }

    public int cVA() {
        return this.jol;
    }

    public void Da(int i) {
        this.jol = i;
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

    public int cVB() {
        return this.type;
    }

    public void Db(int i) {
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

    public String cVC() {
        return this.obj_id;
    }

    public String cVD() {
        return this.kQz;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        Db(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        Da(starEnter.rank_num.intValue());
        CZ(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.kQA == 1) {
            this.title = kQy;
        }
        this.obj_id = starEnter.obj_id;
        this.kQz = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

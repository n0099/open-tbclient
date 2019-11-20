package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes3.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final String jfI = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private int hIF;
    private String icon;
    private String jfJ;
    private int jfK;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int cnq() {
        return this.jfK;
    }

    public void zE(int i) {
        this.jfK = i;
    }

    public int cnr() {
        return this.hIF;
    }

    public void zF(int i) {
        this.hIF = i;
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

    public int cns() {
        return this.type;
    }

    public void zG(int i) {
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

    public String cnt() {
        return this.obj_id;
    }

    public String cnu() {
        return this.jfJ;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        zG(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        zF(starEnter.rank_num.intValue());
        zE(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.jfK == 1) {
            this.title = jfI;
        }
        this.obj_id = starEnter.obj_id;
        this.jfJ = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

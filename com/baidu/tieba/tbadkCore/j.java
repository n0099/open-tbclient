package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes6.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final String kdD = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private int iAx;
    private String icon;
    private String kdE;
    private int kdF;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int cIC() {
        return this.kdF;
    }

    public void Cg(int i) {
        this.kdF = i;
    }

    public int cID() {
        return this.iAx;
    }

    public void Ch(int i) {
        this.iAx = i;
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

    public int cIE() {
        return this.type;
    }

    public void Ci(int i) {
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

    public String cIF() {
        return this.obj_id;
    }

    public String cIG() {
        return this.kdE;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        Ci(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        Ch(starEnter.rank_num.intValue());
        Cg(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.kdF == 1) {
            this.title = kdD;
        }
        this.obj_id = starEnter.obj_id;
        this.kdE = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

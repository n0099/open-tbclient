package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final String iWP = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private int hBN;
    private String iWQ;
    private int iWR;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int clA() {
        return this.iWR;
    }

    public void Am(int i) {
        this.iWR = i;
    }

    public int clB() {
        return this.hBN;
    }

    public void An(int i) {
        this.hBN = i;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void Ao(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int clC() {
        return this.type;
    }

    public void Ap(int i) {
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

    public String clD() {
        return this.obj_id;
    }

    public String clE() {
        return this.iWQ;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        Ap(starEnter.type.intValue());
        setUrl(starEnter.url);
        Ao(starEnter.weight.intValue());
        An(starEnter.rank_num.intValue());
        Am(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.iWR == 1) {
            this.title = iWP;
        }
        this.obj_id = starEnter.obj_id;
        this.iWQ = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

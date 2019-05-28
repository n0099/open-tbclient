package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final String iWL = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private int hBM;
    private String iWM;
    private int iWN;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int clz() {
        return this.iWN;
    }

    public void Am(int i) {
        this.iWN = i;
    }

    public int clA() {
        return this.hBM;
    }

    public void An(int i) {
        this.hBM = i;
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

    public int clB() {
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

    public String clC() {
        return this.obj_id;
    }

    public String clD() {
        return this.iWM;
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
        if (StringUtils.isNull(this.title) && this.iWN == 1) {
            this.title = iWL;
        }
        this.obj_id = starEnter.obj_id;
        this.iWM = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

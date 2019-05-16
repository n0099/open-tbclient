package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final String iWJ = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private int hBJ;
    private String iWK;
    private int iWL;
    private String icon;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int clx() {
        return this.iWL;
    }

    public void Am(int i) {
        this.iWL = i;
    }

    public int cly() {
        return this.hBJ;
    }

    public void An(int i) {
        this.hBJ = i;
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

    public int clz() {
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

    public String clA() {
        return this.obj_id;
    }

    public String clB() {
        return this.iWK;
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
        if (StringUtils.isNull(this.title) && this.iWL == 1) {
            this.title = iWJ;
        }
        this.obj_id = starEnter.obj_id;
        this.iWK = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

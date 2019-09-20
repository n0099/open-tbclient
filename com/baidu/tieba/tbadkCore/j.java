package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes3.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final String jgJ = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private int dzX;
    private String icon;
    private String jgK;
    private int jgL;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int cpB() {
        return this.jgL;
    }

    public void AX(int i) {
        this.jgL = i;
    }

    public int cpC() {
        return this.dzX;
    }

    public void AY(int i) {
        this.dzX = i;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void AZ(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cpD() {
        return this.type;
    }

    public void Ba(int i) {
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

    public String cpE() {
        return this.obj_id;
    }

    public String cpF() {
        return this.jgK;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        Ba(starEnter.type.intValue());
        setUrl(starEnter.url);
        AZ(starEnter.weight.intValue());
        AY(starEnter.rank_num.intValue());
        AX(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.jgL == 1) {
            this.title = jgJ;
        }
        this.obj_id = starEnter.obj_id;
        this.jgK = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.o {
    public static final String lkb = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private String icon;
    private int jFZ;
    private String lkc;
    private int lkd;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int dcQ() {
        return this.lkd;
    }

    public void DL(int i) {
        this.lkd = i;
    }

    public int dcR() {
        return this.jFZ;
    }

    public void DM(int i) {
        this.jFZ = i;
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

    public int dcS() {
        return this.type;
    }

    public void DN(int i) {
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

    public String dcT() {
        return this.obj_id;
    }

    public String dcU() {
        return this.lkc;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        DN(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        DM(starEnter.rank_num.intValue());
        DL(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.lkd == 1) {
            this.title = lkb;
        }
        this.obj_id = starEnter.obj_id;
        this.lkc = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

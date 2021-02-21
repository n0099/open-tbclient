package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.n {
    public static final String nva = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private String icon;
    private int lLm;
    private String nvb;
    private int nvc;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int dMH() {
        return this.nvc;
    }

    public void Ju(int i) {
        this.nvc = i;
    }

    public int dMI() {
        return this.lLm;
    }

    public void Jv(int i) {
        this.lLm = i;
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

    public int dMJ() {
        return this.type;
    }

    public void Jw(int i) {
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

    public String dMK() {
        return this.obj_id;
    }

    public String dML() {
        return this.nvb;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        Jw(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        Jv(starEnter.rank_num.intValue());
        Ju(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.nvc == 1) {
            this.title = nva;
        }
        this.obj_id = starEnter.obj_id;
        this.nvb = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

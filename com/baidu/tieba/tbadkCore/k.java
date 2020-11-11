package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.q {
    public static final String mVa = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private String icon;
    private int lnR;
    private String mVb;
    private int mVc;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int dJf() {
        return this.mVc;
    }

    public void Ju(int i) {
        this.mVc = i;
    }

    public int dJg() {
        return this.lnR;
    }

    public void Jv(int i) {
        this.lnR = i;
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

    public int dJh() {
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

    public String dJi() {
        return this.obj_id;
    }

    public String dJj() {
        return this.mVb;
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
        if (StringUtils.isNull(this.title) && this.mVc == 1) {
            this.title = mVa;
        }
        this.obj_id = starEnter.obj_id;
        this.mVb = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

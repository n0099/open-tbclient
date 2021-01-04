package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.n {
    public static final String npz = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private String icon;
    private int lGP;
    private String npA;
    private int npB;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int dOf() {
        return this.npB;
    }

    public void KH(int i) {
        this.npB = i;
    }

    public int dOg() {
        return this.lGP;
    }

    public void KI(int i) {
        this.lGP = i;
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

    public int dOh() {
        return this.type;
    }

    public void KJ(int i) {
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

    public String dOi() {
        return this.obj_id;
    }

    public String dOj() {
        return this.npA;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        KJ(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        KI(starEnter.rank_num.intValue());
        KH(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.npB == 1) {
            this.title = npz;
        }
        this.obj_id = starEnter.obj_id;
        this.npA = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

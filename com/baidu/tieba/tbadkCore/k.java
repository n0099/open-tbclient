package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.n {
    public static final String npy = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private String icon;
    private int lGO;
    private int npA;
    private String npz;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int dOg() {
        return this.npA;
    }

    public void KH(int i) {
        this.npA = i;
    }

    public int dOh() {
        return this.lGO;
    }

    public void KI(int i) {
        this.lGO = i;
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

    public int dOi() {
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

    public String dOj() {
        return this.obj_id;
    }

    public String dOk() {
        return this.npz;
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
        if (StringUtils.isNull(this.title) && this.npA == 1) {
            this.title = npy;
        }
        this.obj_id = starEnter.obj_id;
        this.npz = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

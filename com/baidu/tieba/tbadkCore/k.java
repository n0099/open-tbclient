package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.n {
    public static final String nkR = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private String icon;
    private int lCj;
    private String nkS;
    private int nkT;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int dKo() {
        return this.nkT;
    }

    public void Ja(int i) {
        this.nkT = i;
    }

    public int dKp() {
        return this.lCj;
    }

    public void Jb(int i) {
        this.lCj = i;
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

    public int dKq() {
        return this.type;
    }

    public void Jc(int i) {
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

    public String dKr() {
        return this.obj_id;
    }

    public String dKs() {
        return this.nkS;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        Jc(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        Jb(starEnter.rank_num.intValue());
        Ja(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.nkT == 1) {
            this.title = nkR;
        }
        this.obj_id = starEnter.obj_id;
        this.nkS = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

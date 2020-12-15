package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.q {
    public static final String njS = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private String icon;
    private int lBJ;
    private String njT;
    private int njU;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int dOn() {
        return this.njU;
    }

    public void KM(int i) {
        this.njU = i;
    }

    public int dOo() {
        return this.lBJ;
    }

    public void KN(int i) {
        this.lBJ = i;
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

    public int dOp() {
        return this.type;
    }

    public void KO(int i) {
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

    public String dOq() {
        return this.obj_id;
    }

    public String dOr() {
        return this.njT;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        KO(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        KN(starEnter.rank_num.intValue());
        KM(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.njU == 1) {
            this.title = njS;
        }
        this.obj_id = starEnter.obj_id;
        this.njT = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

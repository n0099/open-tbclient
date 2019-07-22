package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes3.dex */
public class h implements com.baidu.adp.widget.ListView.m {
    public static final String jdh = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private int dyf;
    private String icon;
    private String jdi;
    private int jdj;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int cos() {
        return this.jdj;
    }

    public void AS(int i) {
        this.jdj = i;
    }

    public int cot() {
        return this.dyf;
    }

    public void AT(int i) {
        this.dyf = i;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void AU(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int cou() {
        return this.type;
    }

    public void AV(int i) {
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

    public String cov() {
        return this.obj_id;
    }

    public String cow() {
        return this.jdi;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        AV(starEnter.type.intValue());
        setUrl(starEnter.url);
        AU(starEnter.weight.intValue());
        AT(starEnter.rank_num.intValue());
        AS(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.jdj == 1) {
            this.title = jdh;
        }
        this.obj_id = starEnter.obj_id;
        this.jdi = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

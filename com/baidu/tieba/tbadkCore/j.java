package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes3.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final String jgz = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private int hJw;
    private String icon;
    private String jgA;
    private int jgB;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int cns() {
        return this.jgB;
    }

    public void zF(int i) {
        this.jgB = i;
    }

    public int cnt() {
        return this.hJw;
    }

    public void zG(int i) {
        this.hJw = i;
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

    public int cnu() {
        return this.type;
    }

    public void zH(int i) {
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

    public String cnv() {
        return this.obj_id;
    }

    public String cnw() {
        return this.jgA;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        zH(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        zG(starEnter.rank_num.intValue());
        zF(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.jgB == 1) {
            this.title = jgz;
        }
        this.obj_id = starEnter.obj_id;
        this.jgA = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes3.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final String jeo = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private int dym;
    private String icon;
    private String jep;
    private int jeq;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int coO() {
        return this.jeq;
    }

    public void AU(int i) {
        this.jeq = i;
    }

    public int coP() {
        return this.dym;
    }

    public void AV(int i) {
        this.dym = i;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void AW(int i) {
        this.weight = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public int coQ() {
        return this.type;
    }

    public void AX(int i) {
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

    public String coR() {
        return this.obj_id;
    }

    public String coS() {
        return this.jep;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        AX(starEnter.type.intValue());
        setUrl(starEnter.url);
        AW(starEnter.weight.intValue());
        AV(starEnter.rank_num.intValue());
        AU(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.jeq == 1) {
            this.title = jeo;
        }
        this.obj_id = starEnter.obj_id;
        this.jep = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

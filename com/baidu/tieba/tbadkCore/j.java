package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes8.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final String keR = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private int iCE;
    private String icon;
    private String keS;
    private int keT;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int cKj() {
        return this.keT;
    }

    public void Cn(int i) {
        this.keT = i;
    }

    public int cKk() {
        return this.iCE;
    }

    public void Co(int i) {
        this.iCE = i;
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

    public int cKl() {
        return this.type;
    }

    public void Cp(int i) {
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

    public String cKm() {
        return this.obj_id;
    }

    public String cKn() {
        return this.keS;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        Cp(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        Co(starEnter.rank_num.intValue());
        Cn(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.keT == 1) {
            this.title = keR;
        }
        this.obj_id = starEnter.obj_id;
        this.keS = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

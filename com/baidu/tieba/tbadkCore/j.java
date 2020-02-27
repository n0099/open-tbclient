package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes8.dex */
public class j implements com.baidu.adp.widget.ListView.m {
    public static final String keD = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private int iCq;
    private String icon;
    private String keE;
    private int keF;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int cKg() {
        return this.keF;
    }

    public void Cn(int i) {
        this.keF = i;
    }

    public int cKh() {
        return this.iCq;
    }

    public void Co(int i) {
        this.iCq = i;
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

    public int cKi() {
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

    public String cKj() {
        return this.obj_id;
    }

    public String cKk() {
        return this.keE;
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
        if (StringUtils.isNull(this.title) && this.keF == 1) {
            this.title = keD;
        }
        this.obj_id = starEnter.obj_id;
        this.keE = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

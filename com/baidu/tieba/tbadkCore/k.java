package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.o {
    public static final String liS = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private String icon;
    private int jET;
    private String liT;
    private int liU;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int dcB() {
        return this.liU;
    }

    public void DJ(int i) {
        this.liU = i;
    }

    public int dcC() {
        return this.jET;
    }

    public void DK(int i) {
        this.jET = i;
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

    public int dcD() {
        return this.type;
    }

    public void DL(int i) {
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

    public String dcE() {
        return this.obj_id;
    }

    public String dcF() {
        return this.liT;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        DL(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        DK(starEnter.rank_num.intValue());
        DJ(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.liU == 1) {
            this.title = liS;
        }
        this.obj_id = starEnter.obj_id;
        this.liT = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

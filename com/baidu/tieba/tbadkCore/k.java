package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes.dex */
public class k implements com.baidu.adp.widget.ListView.n {
    public static final String nxe = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private String icon;
    private int lNo;
    private String nxf;
    private int nxg;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int dMP() {
        return this.nxg;
    }

    public void Jy(int i) {
        this.nxg = i;
    }

    public int dMQ() {
        return this.lNo;
    }

    public void Jz(int i) {
        this.lNo = i;
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

    public int dMR() {
        return this.type;
    }

    public void JA(int i) {
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

    public String dMS() {
        return this.obj_id;
    }

    public String dMT() {
        return this.nxf;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        JA(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        Jz(starEnter.rank_num.intValue());
        Jy(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.nxg == 1) {
            this.title = nxe;
        }
        this.obj_id = starEnter.obj_id;
        this.nxf = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

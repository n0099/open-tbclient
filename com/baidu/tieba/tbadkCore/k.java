package com.baidu.tieba.tbadkCore;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import tbclient.FrsPage.StarEnter;
/* loaded from: classes2.dex */
public class k implements com.baidu.adp.widget.ListView.q {
    public static final String mcX = TbadkCoreApplication.getInst().getString(R.string.default_bar_manager_select_title);
    private String icon;
    private int kxF;
    private String mcY;
    private int mcZ;
    private String obj_id;
    private int time;
    private String title;
    private int type;
    private String url;
    private int weight;

    public int dvM() {
        return this.mcZ;
    }

    public void HG(int i) {
        this.mcZ = i;
    }

    public int dvN() {
        return this.kxF;
    }

    public void HH(int i) {
        this.kxF = i;
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

    public int dvO() {
        return this.type;
    }

    public void HI(int i) {
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

    public String dvP() {
        return this.obj_id;
    }

    public String dvQ() {
        return this.mcY;
    }

    public void a(StarEnter starEnter) {
        setIcon(starEnter.icon);
        setTime(starEnter.time.intValue());
        setTitle(starEnter.title);
        HI(starEnter.type.intValue());
        setUrl(starEnter.url);
        setWeight(starEnter.weight.intValue());
        HH(starEnter.rank_num.intValue());
        HG(starEnter.bazhu_mark.intValue());
        if (StringUtils.isNull(this.title) && this.mcZ == 1) {
            this.title = mcX;
        }
        this.obj_id = starEnter.obj_id;
        this.mcY = starEnter.text;
    }

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return BdUniqueId.gen();
    }
}

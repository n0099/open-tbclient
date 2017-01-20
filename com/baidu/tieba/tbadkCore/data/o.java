package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class o extends p {
    public String OH;
    public String OI;
    public String bPi;
    public String forumId;
    private AppData fpJ;
    public boolean fpK = false;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.fpJ = new AppData(app);
    }

    public AppData bhE() {
        return this.fpJ;
    }

    public ICardInfo bhF() {
        if (this.fpJ == null) {
            return null;
        }
        return this.fpJ.legoCard;
    }

    public String bhG() {
        return this.fpJ == null ? "" : this.fpJ.id;
    }

    public boolean isApp() {
        if (this.fpJ == null) {
            return false;
        }
        return this.fpJ.pd();
    }

    public int bhH() {
        if (this.fpJ == null || this.fpJ.goods == null) {
            return -1;
        }
        return this.fpJ.goods.goods_style;
    }

    public int getPosition() {
        int g = this.fpJ != null ? com.baidu.adp.lib.g.b.g(this.fpJ.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public com.baidu.tbadk.core.data.c bhI() {
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        if (this.fpJ != null) {
            cVar.OM = this.fpJ;
            cVar.Ou = this.fpJ.id;
            cVar.Ov = this.fpJ.name;
            cVar.Ow = this.fpJ.url_type;
            cVar.Ox = this.fpJ.url;
            cVar.deepUrl = this.fpJ.deepUrl;
            cVar.Oy = this.fpJ.apk_url;
            cVar.Oz = this.fpJ.apk_name;
            cVar.adPosition = this.fpJ.pos_name.trim();
            cVar.OA = this.fpJ.first_name;
            cVar.OB = this.fpJ.second_name;
            cVar.cpid = this.fpJ.cpid;
            cVar.abtest = this.fpJ.abtest;
            cVar.OC = this.fpJ.plan_id;
            cVar.userId = this.fpJ.user_id;
            cVar.OD = this.fpJ.verify;
            cVar.price = this.fpJ.price;
            cVar.extensionInfo = this.fpJ.ext_info;
            cVar.OE = this.fpJ.app_time * 1000;
            cVar.legoCard = this.fpJ.legoCard;
            if (this.fpJ.goods != null) {
                cVar.OF.OS = this.fpJ.goods.pop_window_text;
                cVar.OF.OO = this.fpJ.goods.id;
                cVar.OF.OR = this.fpJ.goods.thread_pic;
                cVar.OF.OT = this.fpJ.goods.goods_style;
                cVar.OF.OP = this.fpJ.goods.thread_title;
                cVar.OF.OQ = this.fpJ.goods.thread_content;
                cVar.OF.userName = this.fpJ.goods.user_name;
                cVar.OF.userPortrait = this.fpJ.goods.user_portrait;
                cVar.OF.buttonText = this.fpJ.goods.button_text;
                cVar.OF.OW = this.fpJ.goods.button_url;
                if (this.fpJ.goods.thread_pic_list != null) {
                    cVar.OF.OX = new ArrayList();
                    cVar.OF.OX.addAll(this.fpJ.goods.thread_pic_list);
                }
                cVar.OF.OY = this.fpJ.goods.video_info;
                cVar.OF.OZ = this.fpJ.goods.tag_name;
                cVar.OF.adSource = this.fpJ.goods.ad_source;
                cVar.OF.Pa = this.fpJ.goods.tag_name_url;
                cVar.OF.tagRatio = this.fpJ.goods.tagRatio;
            }
            cVar.Oa = "PB";
        }
        return cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.data.p, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (bhF() != null) {
            return com.baidu.tbadk.core.data.c.Os;
        }
        if (bhH() == 1001) {
            return com.baidu.tbadk.core.data.c.Ol;
        }
        if (bhH() == 2) {
            return com.baidu.tbadk.core.data.c.Om;
        }
        if (bhH() == 6) {
            return com.baidu.tbadk.core.data.c.On;
        }
        if (bhH() == 7) {
            return com.baidu.tbadk.core.data.c.Oo;
        }
        return null;
    }
}

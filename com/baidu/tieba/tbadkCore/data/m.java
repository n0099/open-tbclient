package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String bwU;
    public String bwV;
    public String forumId;
    public String fpJ;
    private AppData iFJ;
    public boolean iFK = false;
    public boolean iFL = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.iFJ = new AppData(app);
    }

    public void Cx(String str) {
        this.iFJ = new AppData(str);
    }

    public AppData ced() {
        return this.iFJ;
    }

    public AdvertAppInfo.ILegoAdvert cee() {
        if (this.iFJ == null) {
            return null;
        }
        return this.iFJ.legoCard;
    }

    public String getAdId() {
        return this.iFJ == null ? "" : this.iFJ.id;
    }

    public boolean axr() {
        return this.iFJ != null && this.iFJ.WX() == 0;
    }

    public boolean isApp() {
        if (this.iFJ == null) {
            return false;
        }
        return this.iFJ.WY();
    }

    public int cef() {
        if (this.iFJ == null || this.iFJ.goods == null) {
            return -1;
        }
        return this.iFJ.goods.goods_style;
    }

    public int getPosition() {
        if (this.iFJ == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.l(this.iFJ.pos_name, 0);
    }

    public String ceg() {
        return this.iFK ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo pR() {
        List<String> kZ;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.iFJ != null) {
            advertAppInfo.bwY = this.iFJ;
            advertAppInfo.bwH = this.iFJ.id;
            advertAppInfo.bwI = this.iFJ.name;
            advertAppInfo.Uy = this.iFJ.url_type;
            advertAppInfo.bwJ = this.iFJ.url;
            advertAppInfo.deepUrl = this.iFJ.deepUrl;
            advertAppInfo.bwK = this.iFJ.apk_url;
            advertAppInfo.bwL = this.iFJ.apk_name;
            advertAppInfo.adPosition = this.iFJ.pos_name.trim();
            advertAppInfo.anH = this.iFJ.first_name;
            advertAppInfo.bwN = this.iFJ.second_name;
            advertAppInfo.cpid = this.iFJ.cpid;
            advertAppInfo.abtest = this.iFJ.abtest;
            advertAppInfo.bwO = this.iFJ.plan_id;
            advertAppInfo.userId = this.iFJ.user_id;
            advertAppInfo.bwP = this.iFJ.verify;
            advertAppInfo.price = this.iFJ.price;
            advertAppInfo.extensionInfo = this.iFJ.ext_info;
            advertAppInfo.bwQ = this.iFJ.app_time * 1000;
            advertAppInfo.legoCard = this.iFJ.legoCard;
            if (this.iFJ.goods != null) {
                advertAppInfo.bwR.bxd = this.iFJ.goods.pop_window_text;
                advertAppInfo.bwR.bwZ = this.iFJ.goods.id;
                advertAppInfo.bwR.bxc = this.iFJ.goods.thread_pic;
                advertAppInfo.bwR.bxe = this.iFJ.goods.goods_style;
                advertAppInfo.bwR.bxa = this.iFJ.goods.thread_title;
                advertAppInfo.bwR.bxb = this.iFJ.goods.thread_content;
                advertAppInfo.bwR.userName = this.iFJ.goods.user_name;
                advertAppInfo.bwR.userPortrait = this.iFJ.goods.user_portrait;
                advertAppInfo.bwR.buttonText = this.iFJ.goods.button_text;
                advertAppInfo.bwR.bxh = this.iFJ.goods.button_url;
                if (this.iFJ.goods.thread_pic_list != null && advertAppInfo.bwR.bxi != null) {
                    advertAppInfo.bwR.bxi.addAll(this.iFJ.goods.thread_pic_list);
                }
                if (v.T(advertAppInfo.bwR.bxi) && (kZ = AdvertAppInfo.a.kZ(this.iFJ.goods.lego_card)) != null && advertAppInfo.bwR.bxi != null) {
                    advertAppInfo.bwR.bxi.addAll(kZ);
                }
                advertAppInfo.bwR.bxj = this.iFJ.goods.video_info;
                advertAppInfo.bwR.tagName = this.iFJ.goods.tag_name;
                advertAppInfo.bwR.adSource = this.iFJ.goods.ad_source;
                advertAppInfo.bwR.bxk = this.iFJ.goods.tag_name_url;
                advertAppInfo.bwR.tagRatio = this.iFJ.goods.tagRatio;
                advertAppInfo.bwR.lego_card = this.iFJ.goods.lego_card;
                advertAppInfo.bwR.adCloseInfo = this.iFJ.goods.adCloseInfo;
            }
            advertAppInfo.page = ceg();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.Wv().Wz() && this.iFJ != null && this.iFJ.legoCard != null && !this.iFJ.legoCard.isNoPicAd()) {
            return AdvertAppInfo.bwv;
        }
        if (cef() == 1001 || cef() == -1001) {
            return AdvertAppInfo.bwv;
        }
        if (cee() != null) {
            return AdvertAppInfo.bwz;
        }
        return null;
    }
}

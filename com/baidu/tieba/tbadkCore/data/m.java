package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String bwT;
    public String bwU;
    public String forumId;
    public String fpJ;
    private AppData iFI;
    public boolean iFJ = false;
    public boolean iFK = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.iFI = new AppData(app);
    }

    public void Cx(String str) {
        this.iFI = new AppData(str);
    }

    public AppData ced() {
        return this.iFI;
    }

    public AdvertAppInfo.ILegoAdvert cee() {
        if (this.iFI == null) {
            return null;
        }
        return this.iFI.legoCard;
    }

    public String getAdId() {
        return this.iFI == null ? "" : this.iFI.id;
    }

    public boolean axr() {
        return this.iFI != null && this.iFI.WX() == 0;
    }

    public boolean isApp() {
        if (this.iFI == null) {
            return false;
        }
        return this.iFI.WY();
    }

    public int cef() {
        if (this.iFI == null || this.iFI.goods == null) {
            return -1;
        }
        return this.iFI.goods.goods_style;
    }

    public int getPosition() {
        if (this.iFI == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.l(this.iFI.pos_name, 0);
    }

    public String ceg() {
        return this.iFJ ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo pR() {
        List<String> kZ;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.iFI != null) {
            advertAppInfo.bwX = this.iFI;
            advertAppInfo.bwG = this.iFI.id;
            advertAppInfo.bwH = this.iFI.name;
            advertAppInfo.Ux = this.iFI.url_type;
            advertAppInfo.bwI = this.iFI.url;
            advertAppInfo.deepUrl = this.iFI.deepUrl;
            advertAppInfo.bwJ = this.iFI.apk_url;
            advertAppInfo.bwK = this.iFI.apk_name;
            advertAppInfo.adPosition = this.iFI.pos_name.trim();
            advertAppInfo.anG = this.iFI.first_name;
            advertAppInfo.bwM = this.iFI.second_name;
            advertAppInfo.cpid = this.iFI.cpid;
            advertAppInfo.abtest = this.iFI.abtest;
            advertAppInfo.bwN = this.iFI.plan_id;
            advertAppInfo.userId = this.iFI.user_id;
            advertAppInfo.bwO = this.iFI.verify;
            advertAppInfo.price = this.iFI.price;
            advertAppInfo.extensionInfo = this.iFI.ext_info;
            advertAppInfo.bwP = this.iFI.app_time * 1000;
            advertAppInfo.legoCard = this.iFI.legoCard;
            if (this.iFI.goods != null) {
                advertAppInfo.bwQ.bxc = this.iFI.goods.pop_window_text;
                advertAppInfo.bwQ.bwY = this.iFI.goods.id;
                advertAppInfo.bwQ.bxb = this.iFI.goods.thread_pic;
                advertAppInfo.bwQ.bxd = this.iFI.goods.goods_style;
                advertAppInfo.bwQ.bwZ = this.iFI.goods.thread_title;
                advertAppInfo.bwQ.bxa = this.iFI.goods.thread_content;
                advertAppInfo.bwQ.userName = this.iFI.goods.user_name;
                advertAppInfo.bwQ.userPortrait = this.iFI.goods.user_portrait;
                advertAppInfo.bwQ.buttonText = this.iFI.goods.button_text;
                advertAppInfo.bwQ.bxg = this.iFI.goods.button_url;
                if (this.iFI.goods.thread_pic_list != null && advertAppInfo.bwQ.bxh != null) {
                    advertAppInfo.bwQ.bxh.addAll(this.iFI.goods.thread_pic_list);
                }
                if (v.T(advertAppInfo.bwQ.bxh) && (kZ = AdvertAppInfo.a.kZ(this.iFI.goods.lego_card)) != null && advertAppInfo.bwQ.bxh != null) {
                    advertAppInfo.bwQ.bxh.addAll(kZ);
                }
                advertAppInfo.bwQ.bxi = this.iFI.goods.video_info;
                advertAppInfo.bwQ.tagName = this.iFI.goods.tag_name;
                advertAppInfo.bwQ.adSource = this.iFI.goods.ad_source;
                advertAppInfo.bwQ.bxj = this.iFI.goods.tag_name_url;
                advertAppInfo.bwQ.tagRatio = this.iFI.goods.tagRatio;
                advertAppInfo.bwQ.lego_card = this.iFI.goods.lego_card;
                advertAppInfo.bwQ.adCloseInfo = this.iFI.goods.adCloseInfo;
            }
            advertAppInfo.page = ceg();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.Wv().Wz() && this.iFI != null && this.iFI.legoCard != null && !this.iFI.legoCard.isNoPicAd()) {
            return AdvertAppInfo.bwu;
        }
        if (cef() == 1001 || cef() == -1001) {
            return AdvertAppInfo.bwu;
        }
        if (cee() != null) {
            return AdvertAppInfo.bwy;
        }
        return null;
    }
}

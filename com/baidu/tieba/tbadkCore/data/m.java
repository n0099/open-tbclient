package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String bwO;
    public String bwP;
    public String forumId;
    public String fpY;
    private AppData iGf;
    public boolean iGg = false;
    public boolean iGh = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.iGf = new AppData(app);
    }

    public void Cz(String str) {
        this.iGf = new AppData(str);
    }

    public AppData cee() {
        return this.iGf;
    }

    public AdvertAppInfo.ILegoAdvert cef() {
        if (this.iGf == null) {
            return null;
        }
        return this.iGf.legoCard;
    }

    public String getAdId() {
        return this.iGf == null ? "" : this.iGf.id;
    }

    public boolean axu() {
        return this.iGf != null && this.iGf.Xa() == 0;
    }

    public boolean isApp() {
        if (this.iGf == null) {
            return false;
        }
        return this.iGf.Xb();
    }

    public int ceg() {
        if (this.iGf == null || this.iGf.goods == null) {
            return -1;
        }
        return this.iGf.goods.goods_style;
    }

    public int getPosition() {
        if (this.iGf == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.l(this.iGf.pos_name, 0);
    }

    public String ceh() {
        return this.iGg ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo pR() {
        List<String> kY;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.iGf != null) {
            advertAppInfo.bwS = this.iGf;
            advertAppInfo.bwB = this.iGf.id;
            advertAppInfo.bwC = this.iGf.name;
            advertAppInfo.Uw = this.iGf.url_type;
            advertAppInfo.bwD = this.iGf.url;
            advertAppInfo.deepUrl = this.iGf.deepUrl;
            advertAppInfo.bwE = this.iGf.apk_url;
            advertAppInfo.bwF = this.iGf.apk_name;
            advertAppInfo.adPosition = this.iGf.pos_name.trim();
            advertAppInfo.anB = this.iGf.first_name;
            advertAppInfo.bwH = this.iGf.second_name;
            advertAppInfo.cpid = this.iGf.cpid;
            advertAppInfo.abtest = this.iGf.abtest;
            advertAppInfo.bwI = this.iGf.plan_id;
            advertAppInfo.userId = this.iGf.user_id;
            advertAppInfo.bwJ = this.iGf.verify;
            advertAppInfo.price = this.iGf.price;
            advertAppInfo.extensionInfo = this.iGf.ext_info;
            advertAppInfo.bwK = this.iGf.app_time * 1000;
            advertAppInfo.legoCard = this.iGf.legoCard;
            if (this.iGf.goods != null) {
                advertAppInfo.bwL.bwX = this.iGf.goods.pop_window_text;
                advertAppInfo.bwL.bwT = this.iGf.goods.id;
                advertAppInfo.bwL.bwW = this.iGf.goods.thread_pic;
                advertAppInfo.bwL.bwY = this.iGf.goods.goods_style;
                advertAppInfo.bwL.bwU = this.iGf.goods.thread_title;
                advertAppInfo.bwL.bwV = this.iGf.goods.thread_content;
                advertAppInfo.bwL.userName = this.iGf.goods.user_name;
                advertAppInfo.bwL.userPortrait = this.iGf.goods.user_portrait;
                advertAppInfo.bwL.buttonText = this.iGf.goods.button_text;
                advertAppInfo.bwL.bxb = this.iGf.goods.button_url;
                if (this.iGf.goods.thread_pic_list != null && advertAppInfo.bwL.bxc != null) {
                    advertAppInfo.bwL.bxc.addAll(this.iGf.goods.thread_pic_list);
                }
                if (v.T(advertAppInfo.bwL.bxc) && (kY = AdvertAppInfo.a.kY(this.iGf.goods.lego_card)) != null && advertAppInfo.bwL.bxc != null) {
                    advertAppInfo.bwL.bxc.addAll(kY);
                }
                advertAppInfo.bwL.bxd = this.iGf.goods.video_info;
                advertAppInfo.bwL.tagName = this.iGf.goods.tag_name;
                advertAppInfo.bwL.adSource = this.iGf.goods.ad_source;
                advertAppInfo.bwL.bxe = this.iGf.goods.tag_name_url;
                advertAppInfo.bwL.tagRatio = this.iGf.goods.tagRatio;
                advertAppInfo.bwL.lego_card = this.iGf.goods.lego_card;
                advertAppInfo.bwL.adCloseInfo = this.iGf.goods.adCloseInfo;
            }
            advertAppInfo.page = ceh();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.Wy().WC() && this.iGf != null && this.iGf.legoCard != null && !this.iGf.legoCard.isNoPicAd()) {
            return AdvertAppInfo.bwp;
        }
        if (ceg() == 1001 || ceg() == -1001) {
            return AdvertAppInfo.bwp;
        }
        if (cef() != null) {
            return AdvertAppInfo.bwt;
        }
        return null;
    }
}

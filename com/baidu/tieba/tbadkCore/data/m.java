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
    private AppData iGg;
    public boolean iGh = false;
    public boolean iGi = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.iGg = new AppData(app);
    }

    public void CA(String str) {
        this.iGg = new AppData(str);
    }

    public AppData cef() {
        return this.iGg;
    }

    public AdvertAppInfo.ILegoAdvert ceg() {
        if (this.iGg == null) {
            return null;
        }
        return this.iGg.legoCard;
    }

    public String getAdId() {
        return this.iGg == null ? "" : this.iGg.id;
    }

    public boolean axv() {
        return this.iGg != null && this.iGg.Xa() == 0;
    }

    public boolean isApp() {
        if (this.iGg == null) {
            return false;
        }
        return this.iGg.Xb();
    }

    public int ceh() {
        if (this.iGg == null || this.iGg.goods == null) {
            return -1;
        }
        return this.iGg.goods.goods_style;
    }

    public int getPosition() {
        if (this.iGg == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.l(this.iGg.pos_name, 0);
    }

    public String cei() {
        return this.iGh ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo pR() {
        List<String> kY;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.iGg != null) {
            advertAppInfo.bwS = this.iGg;
            advertAppInfo.bwB = this.iGg.id;
            advertAppInfo.bwC = this.iGg.name;
            advertAppInfo.Uw = this.iGg.url_type;
            advertAppInfo.bwD = this.iGg.url;
            advertAppInfo.deepUrl = this.iGg.deepUrl;
            advertAppInfo.bwE = this.iGg.apk_url;
            advertAppInfo.bwF = this.iGg.apk_name;
            advertAppInfo.adPosition = this.iGg.pos_name.trim();
            advertAppInfo.anB = this.iGg.first_name;
            advertAppInfo.bwH = this.iGg.second_name;
            advertAppInfo.cpid = this.iGg.cpid;
            advertAppInfo.abtest = this.iGg.abtest;
            advertAppInfo.bwI = this.iGg.plan_id;
            advertAppInfo.userId = this.iGg.user_id;
            advertAppInfo.bwJ = this.iGg.verify;
            advertAppInfo.price = this.iGg.price;
            advertAppInfo.extensionInfo = this.iGg.ext_info;
            advertAppInfo.bwK = this.iGg.app_time * 1000;
            advertAppInfo.legoCard = this.iGg.legoCard;
            if (this.iGg.goods != null) {
                advertAppInfo.bwL.bwX = this.iGg.goods.pop_window_text;
                advertAppInfo.bwL.bwT = this.iGg.goods.id;
                advertAppInfo.bwL.bwW = this.iGg.goods.thread_pic;
                advertAppInfo.bwL.bwY = this.iGg.goods.goods_style;
                advertAppInfo.bwL.bwU = this.iGg.goods.thread_title;
                advertAppInfo.bwL.bwV = this.iGg.goods.thread_content;
                advertAppInfo.bwL.userName = this.iGg.goods.user_name;
                advertAppInfo.bwL.userPortrait = this.iGg.goods.user_portrait;
                advertAppInfo.bwL.buttonText = this.iGg.goods.button_text;
                advertAppInfo.bwL.bxb = this.iGg.goods.button_url;
                if (this.iGg.goods.thread_pic_list != null && advertAppInfo.bwL.bxc != null) {
                    advertAppInfo.bwL.bxc.addAll(this.iGg.goods.thread_pic_list);
                }
                if (v.T(advertAppInfo.bwL.bxc) && (kY = AdvertAppInfo.a.kY(this.iGg.goods.lego_card)) != null && advertAppInfo.bwL.bxc != null) {
                    advertAppInfo.bwL.bxc.addAll(kY);
                }
                advertAppInfo.bwL.bxd = this.iGg.goods.video_info;
                advertAppInfo.bwL.tagName = this.iGg.goods.tag_name;
                advertAppInfo.bwL.adSource = this.iGg.goods.ad_source;
                advertAppInfo.bwL.bxe = this.iGg.goods.tag_name_url;
                advertAppInfo.bwL.tagRatio = this.iGg.goods.tagRatio;
                advertAppInfo.bwL.lego_card = this.iGg.goods.lego_card;
                advertAppInfo.bwL.adCloseInfo = this.iGg.goods.adCloseInfo;
            }
            advertAppInfo.page = cei();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.Wy().WC() && this.iGg != null && this.iGg.legoCard != null && !this.iGg.legoCard.isNoPicAd()) {
            return AdvertAppInfo.bwp;
        }
        if (ceh() == 1001 || ceh() == -1001) {
            return AdvertAppInfo.bwp;
        }
        if (ceg() != null) {
            return AdvertAppInfo.bwt;
        }
        return null;
    }
}

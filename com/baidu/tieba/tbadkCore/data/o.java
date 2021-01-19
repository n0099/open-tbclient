package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.x;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class o extends PostData {
    public String eJu;
    public String eJv;
    public String forumId;
    public String jyf;
    public boolean lRl;
    private AppData nmK;
    public boolean nmL = false;
    public boolean nmM = false;
    public int pageNumber;
    public long threadId;

    public void e(App app) {
        this.nmK = new AppData(app);
    }

    public void Sg(String str) {
        this.nmK = new AppData(str);
    }

    public AppData dLa() {
        return this.nmK;
    }

    public AdvertAppInfo.ILegoAdvert dLb() {
        if (this.nmK == null) {
            return null;
        }
        return this.nmK.legoCard;
    }

    public String getAdId() {
        return this.nmK == null ? "" : this.nmK.id;
    }

    public boolean bLV() {
        return this.nmK != null && this.nmK.bll() == 0;
    }

    public boolean isApp() {
        if (this.nmK == null) {
            return false;
        }
        return this.nmK.blm();
    }

    public int dLc() {
        if (this.nmK == null || this.nmK.goods == null) {
            return -1;
        }
        return this.nmK.goods.goods_style;
    }

    public int getPosition() {
        if (this.nmK == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.nmK.pos_name, 0);
    }

    public String dLd() {
        if (this.nmL) {
            return "PB_BANNER";
        }
        if (this.lRl) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo qU() {
        List<String> zB;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.nmK != null) {
            advertAppInfo.eJy = this.nmK;
            advertAppInfo.eJi = this.nmK.id;
            advertAppInfo.eJj = this.nmK.name;
            advertAppInfo.abE = this.nmK.url_type;
            advertAppInfo.eJk = this.nmK.url;
            advertAppInfo.deepUrl = this.nmK.deepUrl;
            advertAppInfo.apkUrl = this.nmK.apk_url;
            advertAppInfo.eJl = this.nmK.apk_name;
            advertAppInfo.adPosition = this.nmK.pos_name.trim();
            advertAppInfo.cMC = this.nmK.first_name;
            advertAppInfo.eJn = this.nmK.second_name;
            advertAppInfo.cpid = this.nmK.cpid;
            advertAppInfo.abtest = this.nmK.abtest;
            advertAppInfo.eJo = this.nmK.plan_id;
            advertAppInfo.userId = this.nmK.user_id;
            advertAppInfo.eJp = this.nmK.verify;
            advertAppInfo.price = this.nmK.price;
            advertAppInfo.extensionInfo = this.nmK.ext_info;
            advertAppInfo.eJq = this.nmK.app_time * 1000;
            advertAppInfo.legoCard = this.nmK.legoCard;
            if (this.nmK.goods != null) {
                advertAppInfo.eJr.eJE = this.nmK.goods.pop_window_text;
                advertAppInfo.eJr.eJA = this.nmK.goods.id;
                advertAppInfo.eJr.eJD = this.nmK.goods.thread_pic;
                advertAppInfo.eJr.eJF = this.nmK.goods.goods_style;
                advertAppInfo.eJr.eJB = this.nmK.goods.thread_title;
                advertAppInfo.eJr.eJC = this.nmK.goods.thread_content;
                advertAppInfo.eJr.userName = this.nmK.goods.user_name;
                advertAppInfo.eJr.userPortrait = this.nmK.goods.user_portrait;
                advertAppInfo.eJr.buttonText = this.nmK.goods.button_text;
                advertAppInfo.eJr.eJI = this.nmK.goods.button_url;
                if (this.nmK.goods.thread_pic_list != null && advertAppInfo.eJr.eJJ != null) {
                    advertAppInfo.eJr.eJJ.addAll(this.nmK.goods.thread_pic_list);
                }
                if (x.isEmpty(advertAppInfo.eJr.eJJ) && (zB = AdvertAppInfo.a.zB(this.nmK.goods.lego_card)) != null && advertAppInfo.eJr.eJJ != null) {
                    advertAppInfo.eJr.eJJ.addAll(zB);
                }
                advertAppInfo.eJr.eJK = this.nmK.goods.video_info;
                advertAppInfo.eJr.tagName = this.nmK.goods.tag_name;
                advertAppInfo.eJr.adSource = this.nmK.goods.ad_source;
                advertAppInfo.eJr.eJL = this.nmK.goods.tag_name_url;
                advertAppInfo.eJr.tagRatio = this.nmK.goods.tagRatio;
                advertAppInfo.eJr.lego_card = this.nmK.goods.lego_card;
                advertAppInfo.eJr.adCloseInfo = this.nmK.goods.adCloseInfo;
            }
            advertAppInfo.page = dLd();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.bkB().isShowImages() && this.nmK != null && this.nmK.legoCard != null && !this.nmK.legoCard.isNoPicAd()) {
            return AdvertAppInfo.eIT;
        }
        if (com.baidu.tbadk.a.d.biI()) {
            return AdvertAppInfo.eIT;
        }
        if (dLc() == 1001 || dLc() == -1001) {
            return AdvertAppInfo.eIT;
        }
        if (dLb() != null) {
            return AdvertAppInfo.eIX;
        }
        return null;
    }
}

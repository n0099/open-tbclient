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
    private AppData nmJ;
    public boolean nmK = false;
    public boolean nmL = false;
    public int pageNumber;
    public long threadId;

    public void e(App app) {
        this.nmJ = new AppData(app);
    }

    public void Sf(String str) {
        this.nmJ = new AppData(str);
    }

    public AppData dLa() {
        return this.nmJ;
    }

    public AdvertAppInfo.ILegoAdvert dLb() {
        if (this.nmJ == null) {
            return null;
        }
        return this.nmJ.legoCard;
    }

    public String getAdId() {
        return this.nmJ == null ? "" : this.nmJ.id;
    }

    public boolean bLV() {
        return this.nmJ != null && this.nmJ.bll() == 0;
    }

    public boolean isApp() {
        if (this.nmJ == null) {
            return false;
        }
        return this.nmJ.blm();
    }

    public int dLc() {
        if (this.nmJ == null || this.nmJ.goods == null) {
            return -1;
        }
        return this.nmJ.goods.goods_style;
    }

    public int getPosition() {
        if (this.nmJ == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.nmJ.pos_name, 0);
    }

    public String dLd() {
        if (this.nmK) {
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
        if (this.nmJ != null) {
            advertAppInfo.eJy = this.nmJ;
            advertAppInfo.eJi = this.nmJ.id;
            advertAppInfo.eJj = this.nmJ.name;
            advertAppInfo.abE = this.nmJ.url_type;
            advertAppInfo.eJk = this.nmJ.url;
            advertAppInfo.deepUrl = this.nmJ.deepUrl;
            advertAppInfo.apkUrl = this.nmJ.apk_url;
            advertAppInfo.eJl = this.nmJ.apk_name;
            advertAppInfo.adPosition = this.nmJ.pos_name.trim();
            advertAppInfo.cMC = this.nmJ.first_name;
            advertAppInfo.eJn = this.nmJ.second_name;
            advertAppInfo.cpid = this.nmJ.cpid;
            advertAppInfo.abtest = this.nmJ.abtest;
            advertAppInfo.eJo = this.nmJ.plan_id;
            advertAppInfo.userId = this.nmJ.user_id;
            advertAppInfo.eJp = this.nmJ.verify;
            advertAppInfo.price = this.nmJ.price;
            advertAppInfo.extensionInfo = this.nmJ.ext_info;
            advertAppInfo.eJq = this.nmJ.app_time * 1000;
            advertAppInfo.legoCard = this.nmJ.legoCard;
            if (this.nmJ.goods != null) {
                advertAppInfo.eJr.eJE = this.nmJ.goods.pop_window_text;
                advertAppInfo.eJr.eJA = this.nmJ.goods.id;
                advertAppInfo.eJr.eJD = this.nmJ.goods.thread_pic;
                advertAppInfo.eJr.eJF = this.nmJ.goods.goods_style;
                advertAppInfo.eJr.eJB = this.nmJ.goods.thread_title;
                advertAppInfo.eJr.eJC = this.nmJ.goods.thread_content;
                advertAppInfo.eJr.userName = this.nmJ.goods.user_name;
                advertAppInfo.eJr.userPortrait = this.nmJ.goods.user_portrait;
                advertAppInfo.eJr.buttonText = this.nmJ.goods.button_text;
                advertAppInfo.eJr.eJI = this.nmJ.goods.button_url;
                if (this.nmJ.goods.thread_pic_list != null && advertAppInfo.eJr.eJJ != null) {
                    advertAppInfo.eJr.eJJ.addAll(this.nmJ.goods.thread_pic_list);
                }
                if (x.isEmpty(advertAppInfo.eJr.eJJ) && (zB = AdvertAppInfo.a.zB(this.nmJ.goods.lego_card)) != null && advertAppInfo.eJr.eJJ != null) {
                    advertAppInfo.eJr.eJJ.addAll(zB);
                }
                advertAppInfo.eJr.eJK = this.nmJ.goods.video_info;
                advertAppInfo.eJr.tagName = this.nmJ.goods.tag_name;
                advertAppInfo.eJr.adSource = this.nmJ.goods.ad_source;
                advertAppInfo.eJr.eJL = this.nmJ.goods.tag_name_url;
                advertAppInfo.eJr.tagRatio = this.nmJ.goods.tagRatio;
                advertAppInfo.eJr.lego_card = this.nmJ.goods.lego_card;
                advertAppInfo.eJr.adCloseInfo = this.nmJ.goods.adCloseInfo;
            }
            advertAppInfo.page = dLd();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.bkB().isShowImages() && this.nmJ != null && this.nmJ.legoCard != null && !this.nmJ.legoCard.isNoPicAd()) {
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

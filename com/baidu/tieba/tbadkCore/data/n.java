package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.x;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class n extends PostData {
    public String dNi;
    public String dNj;
    public String forumId;
    public String hZe;
    public boolean kwv;
    private AppData lMX;
    public boolean lMY = false;
    public boolean lMZ = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.lMX = new AppData(app);
    }

    public void NM(String str) {
        this.lMX = new AppData(str);
    }

    public AppData dkV() {
        return this.lMX;
    }

    public AdvertAppInfo.ILegoAdvert dkW() {
        if (this.lMX == null) {
            return null;
        }
        return this.lMX.legoCard;
    }

    public String getAdId() {
        return this.lMX == null ? "" : this.lMX.id;
    }

    public boolean isValidate() {
        return this.lMX != null && this.lMX.aUe() == 0;
    }

    public boolean isApp() {
        if (this.lMX == null) {
            return false;
        }
        return this.lMX.aUf();
    }

    public int dkX() {
        if (this.lMX == null || this.lMX.goods == null) {
            return -1;
        }
        return this.lMX.goods.goods_style;
    }

    public int getPosition() {
        if (this.lMX == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.lMX.pos_name, 0);
    }

    public String dkY() {
        if (this.lMY) {
            return "PB_BANNER";
        }
        if (this.kwv) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo pM() {
        List<String> wK;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.lMX != null) {
            advertAppInfo.dNm = this.lMX;
            advertAppInfo.dMW = this.lMX.id;
            advertAppInfo.dMX = this.lMX.name;
            advertAppInfo.YD = this.lMX.url_type;
            advertAppInfo.dMY = this.lMX.url;
            advertAppInfo.deepUrl = this.lMX.deepUrl;
            advertAppInfo.apkUrl = this.lMX.apk_url;
            advertAppInfo.dMZ = this.lMX.apk_name;
            advertAppInfo.adPosition = this.lMX.pos_name.trim();
            advertAppInfo.bYK = this.lMX.first_name;
            advertAppInfo.dNb = this.lMX.second_name;
            advertAppInfo.cpid = this.lMX.cpid;
            advertAppInfo.abtest = this.lMX.abtest;
            advertAppInfo.dNc = this.lMX.plan_id;
            advertAppInfo.userId = this.lMX.user_id;
            advertAppInfo.dNd = this.lMX.verify;
            advertAppInfo.price = this.lMX.price;
            advertAppInfo.extensionInfo = this.lMX.ext_info;
            advertAppInfo.dNe = this.lMX.app_time * 1000;
            advertAppInfo.legoCard = this.lMX.legoCard;
            if (this.lMX.goods != null) {
                advertAppInfo.dNf.dNr = this.lMX.goods.pop_window_text;
                advertAppInfo.dNf.dNn = this.lMX.goods.id;
                advertAppInfo.dNf.dNq = this.lMX.goods.thread_pic;
                advertAppInfo.dNf.dNs = this.lMX.goods.goods_style;
                advertAppInfo.dNf.dNo = this.lMX.goods.thread_title;
                advertAppInfo.dNf.dNp = this.lMX.goods.thread_content;
                advertAppInfo.dNf.userName = this.lMX.goods.user_name;
                advertAppInfo.dNf.userPortrait = this.lMX.goods.user_portrait;
                advertAppInfo.dNf.buttonText = this.lMX.goods.button_text;
                advertAppInfo.dNf.dNv = this.lMX.goods.button_url;
                if (this.lMX.goods.thread_pic_list != null && advertAppInfo.dNf.dNw != null) {
                    advertAppInfo.dNf.dNw.addAll(this.lMX.goods.thread_pic_list);
                }
                if (x.isEmpty(advertAppInfo.dNf.dNw) && (wK = AdvertAppInfo.a.wK(this.lMX.goods.lego_card)) != null && advertAppInfo.dNf.dNw != null) {
                    advertAppInfo.dNf.dNw.addAll(wK);
                }
                advertAppInfo.dNf.dNx = this.lMX.goods.video_info;
                advertAppInfo.dNf.tagName = this.lMX.goods.tag_name;
                advertAppInfo.dNf.adSource = this.lMX.goods.ad_source;
                advertAppInfo.dNf.dNy = this.lMX.goods.tag_name_url;
                advertAppInfo.dNf.tagRatio = this.lMX.goods.tagRatio;
                advertAppInfo.dNf.lego_card = this.lMX.goods.lego_card;
                advertAppInfo.dNf.adCloseInfo = this.lMX.goods.adCloseInfo;
            }
            advertAppInfo.page = dkY();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.aTv().isShowImages() && this.lMX != null && this.lMX.legoCard != null && !this.lMX.legoCard.isNoPicAd()) {
            return AdvertAppInfo.dMK;
        }
        if (dkX() == 1001 || dkX() == -1001) {
            return AdvertAppInfo.dMK;
        }
        if (dkW() != null) {
            return AdvertAppInfo.dMO;
        }
        return null;
    }
}

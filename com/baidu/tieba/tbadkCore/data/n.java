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
    public String hZg;
    public boolean kwx;
    private AppData lMZ;
    public boolean lNa = false;
    public boolean lNb = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.lMZ = new AppData(app);
    }

    public void NM(String str) {
        this.lMZ = new AppData(str);
    }

    public AppData dkW() {
        return this.lMZ;
    }

    public AdvertAppInfo.ILegoAdvert dkX() {
        if (this.lMZ == null) {
            return null;
        }
        return this.lMZ.legoCard;
    }

    public String getAdId() {
        return this.lMZ == null ? "" : this.lMZ.id;
    }

    public boolean isValidate() {
        return this.lMZ != null && this.lMZ.aUe() == 0;
    }

    public boolean isApp() {
        if (this.lMZ == null) {
            return false;
        }
        return this.lMZ.aUf();
    }

    public int dkY() {
        if (this.lMZ == null || this.lMZ.goods == null) {
            return -1;
        }
        return this.lMZ.goods.goods_style;
    }

    public int getPosition() {
        if (this.lMZ == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.lMZ.pos_name, 0);
    }

    public String dkZ() {
        if (this.lNa) {
            return "PB_BANNER";
        }
        if (this.kwx) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo pM() {
        List<String> wK;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.lMZ != null) {
            advertAppInfo.dNm = this.lMZ;
            advertAppInfo.dMW = this.lMZ.id;
            advertAppInfo.dMX = this.lMZ.name;
            advertAppInfo.YD = this.lMZ.url_type;
            advertAppInfo.dMY = this.lMZ.url;
            advertAppInfo.deepUrl = this.lMZ.deepUrl;
            advertAppInfo.apkUrl = this.lMZ.apk_url;
            advertAppInfo.dMZ = this.lMZ.apk_name;
            advertAppInfo.adPosition = this.lMZ.pos_name.trim();
            advertAppInfo.bYK = this.lMZ.first_name;
            advertAppInfo.dNb = this.lMZ.second_name;
            advertAppInfo.cpid = this.lMZ.cpid;
            advertAppInfo.abtest = this.lMZ.abtest;
            advertAppInfo.dNc = this.lMZ.plan_id;
            advertAppInfo.userId = this.lMZ.user_id;
            advertAppInfo.dNd = this.lMZ.verify;
            advertAppInfo.price = this.lMZ.price;
            advertAppInfo.extensionInfo = this.lMZ.ext_info;
            advertAppInfo.dNe = this.lMZ.app_time * 1000;
            advertAppInfo.legoCard = this.lMZ.legoCard;
            if (this.lMZ.goods != null) {
                advertAppInfo.dNf.dNr = this.lMZ.goods.pop_window_text;
                advertAppInfo.dNf.dNn = this.lMZ.goods.id;
                advertAppInfo.dNf.dNq = this.lMZ.goods.thread_pic;
                advertAppInfo.dNf.dNs = this.lMZ.goods.goods_style;
                advertAppInfo.dNf.dNo = this.lMZ.goods.thread_title;
                advertAppInfo.dNf.dNp = this.lMZ.goods.thread_content;
                advertAppInfo.dNf.userName = this.lMZ.goods.user_name;
                advertAppInfo.dNf.userPortrait = this.lMZ.goods.user_portrait;
                advertAppInfo.dNf.buttonText = this.lMZ.goods.button_text;
                advertAppInfo.dNf.dNv = this.lMZ.goods.button_url;
                if (this.lMZ.goods.thread_pic_list != null && advertAppInfo.dNf.dNw != null) {
                    advertAppInfo.dNf.dNw.addAll(this.lMZ.goods.thread_pic_list);
                }
                if (x.isEmpty(advertAppInfo.dNf.dNw) && (wK = AdvertAppInfo.a.wK(this.lMZ.goods.lego_card)) != null && advertAppInfo.dNf.dNw != null) {
                    advertAppInfo.dNf.dNw.addAll(wK);
                }
                advertAppInfo.dNf.dNx = this.lMZ.goods.video_info;
                advertAppInfo.dNf.tagName = this.lMZ.goods.tag_name;
                advertAppInfo.dNf.adSource = this.lMZ.goods.ad_source;
                advertAppInfo.dNf.dNy = this.lMZ.goods.tag_name_url;
                advertAppInfo.dNf.tagRatio = this.lMZ.goods.tagRatio;
                advertAppInfo.dNf.lego_card = this.lMZ.goods.lego_card;
                advertAppInfo.dNf.adCloseInfo = this.lMZ.goods.adCloseInfo;
            }
            advertAppInfo.page = dkZ();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.aTv().isShowImages() && this.lMZ != null && this.lMZ.legoCard != null && !this.lMZ.legoCard.isNoPicAd()) {
            return AdvertAppInfo.dMK;
        }
        if (dkY() == 1001 || dkY() == -1001) {
            return AdvertAppInfo.dMK;
        }
        if (dkX() != null) {
            return AdvertAppInfo.dMO;
        }
        return null;
    }
}

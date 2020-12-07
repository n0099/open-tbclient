package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class n extends PostData {
    public String eEp;
    public String eEq;
    public String forumId;
    public String jqn;
    public boolean lQB;
    private AppData nlD;
    public boolean nlE = false;
    public boolean nlF = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.nlD = new AppData(app);
    }

    public void TF(String str) {
        this.nlD = new AppData(str);
    }

    public AppData dOU() {
        return this.nlD;
    }

    public AdvertAppInfo.ILegoAdvert dOV() {
        if (this.nlD == null) {
            return null;
        }
        return this.nlD.legoCard;
    }

    public String getAdId() {
        return this.nlD == null ? "" : this.nlD.id;
    }

    public boolean isValidate() {
        return this.nlD != null && this.nlD.bmD() == 0;
    }

    public boolean isApp() {
        if (this.nlD == null) {
            return false;
        }
        return this.nlD.bmE();
    }

    public int dOW() {
        if (this.nlD == null || this.nlD.goods == null) {
            return -1;
        }
        return this.nlD.goods.goods_style;
    }

    public int getPosition() {
        if (this.nlD == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.nlD.pos_name, 0);
    }

    public String dOX() {
        if (this.nlE) {
            return "PB_BANNER";
        }
        if (this.lQB) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo rs() {
        List<String> AP;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.nlD != null) {
            advertAppInfo.eEt = this.nlD;
            advertAppInfo.eEd = this.nlD.id;
            advertAppInfo.eEe = this.nlD.name;
            advertAppInfo.aaV = this.nlD.url_type;
            advertAppInfo.eEf = this.nlD.url;
            advertAppInfo.deepUrl = this.nlD.deepUrl;
            advertAppInfo.apkUrl = this.nlD.apk_url;
            advertAppInfo.eEg = this.nlD.apk_name;
            advertAppInfo.adPosition = this.nlD.pos_name.trim();
            advertAppInfo.cMt = this.nlD.first_name;
            advertAppInfo.eEi = this.nlD.second_name;
            advertAppInfo.cpid = this.nlD.cpid;
            advertAppInfo.abtest = this.nlD.abtest;
            advertAppInfo.eEj = this.nlD.plan_id;
            advertAppInfo.userId = this.nlD.user_id;
            advertAppInfo.eEk = this.nlD.verify;
            advertAppInfo.price = this.nlD.price;
            advertAppInfo.extensionInfo = this.nlD.ext_info;
            advertAppInfo.eEl = this.nlD.app_time * 1000;
            advertAppInfo.legoCard = this.nlD.legoCard;
            if (this.nlD.goods != null) {
                advertAppInfo.eEm.eEz = this.nlD.goods.pop_window_text;
                advertAppInfo.eEm.eEv = this.nlD.goods.id;
                advertAppInfo.eEm.eEy = this.nlD.goods.thread_pic;
                advertAppInfo.eEm.eEA = this.nlD.goods.goods_style;
                advertAppInfo.eEm.eEw = this.nlD.goods.thread_title;
                advertAppInfo.eEm.eEx = this.nlD.goods.thread_content;
                advertAppInfo.eEm.userName = this.nlD.goods.user_name;
                advertAppInfo.eEm.userPortrait = this.nlD.goods.user_portrait;
                advertAppInfo.eEm.buttonText = this.nlD.goods.button_text;
                advertAppInfo.eEm.eED = this.nlD.goods.button_url;
                if (this.nlD.goods.thread_pic_list != null && advertAppInfo.eEm.eEE != null) {
                    advertAppInfo.eEm.eEE.addAll(this.nlD.goods.thread_pic_list);
                }
                if (y.isEmpty(advertAppInfo.eEm.eEE) && (AP = AdvertAppInfo.a.AP(this.nlD.goods.lego_card)) != null && advertAppInfo.eEm.eEE != null) {
                    advertAppInfo.eEm.eEE.addAll(AP);
                }
                advertAppInfo.eEm.eEF = this.nlD.goods.video_info;
                advertAppInfo.eEm.tagName = this.nlD.goods.tag_name;
                advertAppInfo.eEm.adSource = this.nlD.goods.ad_source;
                advertAppInfo.eEm.eEG = this.nlD.goods.tag_name_url;
                advertAppInfo.eEm.tagRatio = this.nlD.goods.tagRatio;
                advertAppInfo.eEm.lego_card = this.nlD.goods.lego_card;
                advertAppInfo.eEm.adCloseInfo = this.nlD.goods.adCloseInfo;
            }
            advertAppInfo.page = dOX();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.blV().isShowImages() && this.nlD != null && this.nlD.legoCard != null && !this.nlD.legoCard.isNoPicAd()) {
            return AdvertAppInfo.eDR;
        }
        if (dOW() == 1001 || dOW() == -1001) {
            return AdvertAppInfo.eDR;
        }
        if (dOV() != null) {
            return AdvertAppInfo.eDV;
        }
        return null;
    }
}

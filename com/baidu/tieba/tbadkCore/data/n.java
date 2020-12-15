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
    public String jqp;
    public boolean lQD;
    private AppData nlF;
    public boolean nlG = false;
    public boolean nlH = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.nlF = new AppData(app);
    }

    public void TF(String str) {
        this.nlF = new AppData(str);
    }

    public AppData dOV() {
        return this.nlF;
    }

    public AdvertAppInfo.ILegoAdvert dOW() {
        if (this.nlF == null) {
            return null;
        }
        return this.nlF.legoCard;
    }

    public String getAdId() {
        return this.nlF == null ? "" : this.nlF.id;
    }

    public boolean isValidate() {
        return this.nlF != null && this.nlF.bmD() == 0;
    }

    public boolean isApp() {
        if (this.nlF == null) {
            return false;
        }
        return this.nlF.bmE();
    }

    public int dOX() {
        if (this.nlF == null || this.nlF.goods == null) {
            return -1;
        }
        return this.nlF.goods.goods_style;
    }

    public int getPosition() {
        if (this.nlF == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.nlF.pos_name, 0);
    }

    public String dOY() {
        if (this.nlG) {
            return "PB_BANNER";
        }
        if (this.lQD) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo rs() {
        List<String> AP;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.nlF != null) {
            advertAppInfo.eEt = this.nlF;
            advertAppInfo.eEd = this.nlF.id;
            advertAppInfo.eEe = this.nlF.name;
            advertAppInfo.aaV = this.nlF.url_type;
            advertAppInfo.eEf = this.nlF.url;
            advertAppInfo.deepUrl = this.nlF.deepUrl;
            advertAppInfo.apkUrl = this.nlF.apk_url;
            advertAppInfo.eEg = this.nlF.apk_name;
            advertAppInfo.adPosition = this.nlF.pos_name.trim();
            advertAppInfo.cMt = this.nlF.first_name;
            advertAppInfo.eEi = this.nlF.second_name;
            advertAppInfo.cpid = this.nlF.cpid;
            advertAppInfo.abtest = this.nlF.abtest;
            advertAppInfo.eEj = this.nlF.plan_id;
            advertAppInfo.userId = this.nlF.user_id;
            advertAppInfo.eEk = this.nlF.verify;
            advertAppInfo.price = this.nlF.price;
            advertAppInfo.extensionInfo = this.nlF.ext_info;
            advertAppInfo.eEl = this.nlF.app_time * 1000;
            advertAppInfo.legoCard = this.nlF.legoCard;
            if (this.nlF.goods != null) {
                advertAppInfo.eEm.eEz = this.nlF.goods.pop_window_text;
                advertAppInfo.eEm.eEv = this.nlF.goods.id;
                advertAppInfo.eEm.eEy = this.nlF.goods.thread_pic;
                advertAppInfo.eEm.eEA = this.nlF.goods.goods_style;
                advertAppInfo.eEm.eEw = this.nlF.goods.thread_title;
                advertAppInfo.eEm.eEx = this.nlF.goods.thread_content;
                advertAppInfo.eEm.userName = this.nlF.goods.user_name;
                advertAppInfo.eEm.userPortrait = this.nlF.goods.user_portrait;
                advertAppInfo.eEm.buttonText = this.nlF.goods.button_text;
                advertAppInfo.eEm.eED = this.nlF.goods.button_url;
                if (this.nlF.goods.thread_pic_list != null && advertAppInfo.eEm.eEE != null) {
                    advertAppInfo.eEm.eEE.addAll(this.nlF.goods.thread_pic_list);
                }
                if (y.isEmpty(advertAppInfo.eEm.eEE) && (AP = AdvertAppInfo.a.AP(this.nlF.goods.lego_card)) != null && advertAppInfo.eEm.eEE != null) {
                    advertAppInfo.eEm.eEE.addAll(AP);
                }
                advertAppInfo.eEm.eEF = this.nlF.goods.video_info;
                advertAppInfo.eEm.tagName = this.nlF.goods.tag_name;
                advertAppInfo.eEm.adSource = this.nlF.goods.ad_source;
                advertAppInfo.eEm.eEG = this.nlF.goods.tag_name_url;
                advertAppInfo.eEm.tagRatio = this.nlF.goods.tagRatio;
                advertAppInfo.eEm.lego_card = this.nlF.goods.lego_card;
                advertAppInfo.eEm.adCloseInfo = this.nlF.goods.adCloseInfo;
            }
            advertAppInfo.page = dOY();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.blV().isShowImages() && this.nlF != null && this.nlF.legoCard != null && !this.nlF.legoCard.isNoPicAd()) {
            return AdvertAppInfo.eDR;
        }
        if (dOX() == 1001 || dOX() == -1001) {
            return AdvertAppInfo.eDR;
        }
        if (dOW() != null) {
            return AdvertAppInfo.eDV;
        }
        return null;
    }
}

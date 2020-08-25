package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.App;
/* loaded from: classes2.dex */
public class n extends PostData {
    public String dWr;
    public String dWs;
    public String forumId;
    public String ino;
    public boolean kMc;
    private AppData meJ;
    public boolean meK = false;
    public boolean meL = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.meJ = new AppData(app);
    }

    public void QM(String str) {
        this.meJ = new AppData(str);
    }

    public AppData dwt() {
        return this.meJ;
    }

    public AdvertAppInfo.ILegoAdvert dwu() {
        if (this.meJ == null) {
            return null;
        }
        return this.meJ.legoCard;
    }

    public String getAdId() {
        return this.meJ == null ? "" : this.meJ.id;
    }

    public boolean isValidate() {
        return this.meJ != null && this.meJ.bcv() == 0;
    }

    public boolean isApp() {
        if (this.meJ == null) {
            return false;
        }
        return this.meJ.bcw();
    }

    public int dwv() {
        if (this.meJ == null || this.meJ.goods == null) {
            return -1;
        }
        return this.meJ.goods.goods_style;
    }

    public int getPosition() {
        if (this.meJ == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.meJ.pos_name, 0);
    }

    public String dww() {
        if (this.meK) {
            return "PB_BANNER";
        }
        if (this.kMc) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo rl() {
        List<String> yY;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.meJ != null) {
            advertAppInfo.dWv = this.meJ;
            advertAppInfo.dWf = this.meJ.id;
            advertAppInfo.dWg = this.meJ.name;
            advertAppInfo.Zj = this.meJ.url_type;
            advertAppInfo.dWh = this.meJ.url;
            advertAppInfo.deepUrl = this.meJ.deepUrl;
            advertAppInfo.apkUrl = this.meJ.apk_url;
            advertAppInfo.dWi = this.meJ.apk_name;
            advertAppInfo.adPosition = this.meJ.pos_name.trim();
            advertAppInfo.ceu = this.meJ.first_name;
            advertAppInfo.dWk = this.meJ.second_name;
            advertAppInfo.cpid = this.meJ.cpid;
            advertAppInfo.abtest = this.meJ.abtest;
            advertAppInfo.dWl = this.meJ.plan_id;
            advertAppInfo.userId = this.meJ.user_id;
            advertAppInfo.dWm = this.meJ.verify;
            advertAppInfo.price = this.meJ.price;
            advertAppInfo.extensionInfo = this.meJ.ext_info;
            advertAppInfo.dWn = this.meJ.app_time * 1000;
            advertAppInfo.legoCard = this.meJ.legoCard;
            if (this.meJ.goods != null) {
                advertAppInfo.dWo.dWA = this.meJ.goods.pop_window_text;
                advertAppInfo.dWo.dWw = this.meJ.goods.id;
                advertAppInfo.dWo.dWz = this.meJ.goods.thread_pic;
                advertAppInfo.dWo.dWB = this.meJ.goods.goods_style;
                advertAppInfo.dWo.dWx = this.meJ.goods.thread_title;
                advertAppInfo.dWo.dWy = this.meJ.goods.thread_content;
                advertAppInfo.dWo.userName = this.meJ.goods.user_name;
                advertAppInfo.dWo.userPortrait = this.meJ.goods.user_portrait;
                advertAppInfo.dWo.buttonText = this.meJ.goods.button_text;
                advertAppInfo.dWo.dWE = this.meJ.goods.button_url;
                if (this.meJ.goods.thread_pic_list != null && advertAppInfo.dWo.dWF != null) {
                    advertAppInfo.dWo.dWF.addAll(this.meJ.goods.thread_pic_list);
                }
                if (y.isEmpty(advertAppInfo.dWo.dWF) && (yY = AdvertAppInfo.a.yY(this.meJ.goods.lego_card)) != null && advertAppInfo.dWo.dWF != null) {
                    advertAppInfo.dWo.dWF.addAll(yY);
                }
                advertAppInfo.dWo.dWG = this.meJ.goods.video_info;
                advertAppInfo.dWo.tagName = this.meJ.goods.tag_name;
                advertAppInfo.dWo.adSource = this.meJ.goods.ad_source;
                advertAppInfo.dWo.dWH = this.meJ.goods.tag_name_url;
                advertAppInfo.dWo.tagRatio = this.meJ.goods.tagRatio;
                advertAppInfo.dWo.lego_card = this.meJ.goods.lego_card;
                advertAppInfo.dWo.adCloseInfo = this.meJ.goods.adCloseInfo;
            }
            advertAppInfo.page = dww();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.bbM().isShowImages() && this.meJ != null && this.meJ.legoCard != null && !this.meJ.legoCard.isNoPicAd()) {
            return AdvertAppInfo.dVT;
        }
        if (dwv() == 1001 || dwv() == -1001) {
            return AdvertAppInfo.dVT;
        }
        if (dwu() != null) {
            return AdvertAppInfo.dVX;
        }
        return null;
    }
}

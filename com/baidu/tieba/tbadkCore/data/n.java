package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class n extends PostData {
    public String eth;
    public String eti;
    public String forumId;
    public String iWa;
    public boolean lwz;
    private AppData mQJ;
    public boolean mQK = false;
    public boolean mQL = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.mQJ = new AppData(app);
    }

    public void Sz(String str) {
        this.mQJ = new AppData(str);
    }

    public AppData dHl() {
        return this.mQJ;
    }

    public AdvertAppInfo.ILegoAdvert dHm() {
        if (this.mQJ == null) {
            return null;
        }
        return this.mQJ.legoCard;
    }

    public String getAdId() {
        return this.mQJ == null ? "" : this.mQJ.id;
    }

    public boolean isValidate() {
        return this.mQJ != null && this.mQJ.bhR() == 0;
    }

    public boolean isApp() {
        if (this.mQJ == null) {
            return false;
        }
        return this.mQJ.bhS();
    }

    public int dHn() {
        if (this.mQJ == null || this.mQJ.goods == null) {
            return -1;
        }
        return this.mQJ.goods.goods_style;
    }

    public int getPosition() {
        if (this.mQJ == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.mQJ.pos_name, 0);
    }

    public String dHo() {
        if (this.mQK) {
            return "PB_BANNER";
        }
        if (this.lwz) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo rq() {
        List<String> Az;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.mQJ != null) {
            advertAppInfo.etl = this.mQJ;
            advertAppInfo.esU = this.mQJ.id;
            advertAppInfo.esV = this.mQJ.name;
            advertAppInfo.ZU = this.mQJ.url_type;
            advertAppInfo.esW = this.mQJ.url;
            advertAppInfo.deepUrl = this.mQJ.deepUrl;
            advertAppInfo.apkUrl = this.mQJ.apk_url;
            advertAppInfo.esX = this.mQJ.apk_name;
            advertAppInfo.adPosition = this.mQJ.pos_name.trim();
            advertAppInfo.cBq = this.mQJ.first_name;
            advertAppInfo.esZ = this.mQJ.second_name;
            advertAppInfo.cpid = this.mQJ.cpid;
            advertAppInfo.abtest = this.mQJ.abtest;
            advertAppInfo.eta = this.mQJ.plan_id;
            advertAppInfo.userId = this.mQJ.user_id;
            advertAppInfo.etb = this.mQJ.verify;
            advertAppInfo.price = this.mQJ.price;
            advertAppInfo.extensionInfo = this.mQJ.ext_info;
            advertAppInfo.etd = this.mQJ.app_time * 1000;
            advertAppInfo.legoCard = this.mQJ.legoCard;
            if (this.mQJ.goods != null) {
                advertAppInfo.ete.etq = this.mQJ.goods.pop_window_text;
                advertAppInfo.ete.etm = this.mQJ.goods.id;
                advertAppInfo.ete.etp = this.mQJ.goods.thread_pic;
                advertAppInfo.ete.etr = this.mQJ.goods.goods_style;
                advertAppInfo.ete.etn = this.mQJ.goods.thread_title;
                advertAppInfo.ete.eto = this.mQJ.goods.thread_content;
                advertAppInfo.ete.userName = this.mQJ.goods.user_name;
                advertAppInfo.ete.userPortrait = this.mQJ.goods.user_portrait;
                advertAppInfo.ete.buttonText = this.mQJ.goods.button_text;
                advertAppInfo.ete.etu = this.mQJ.goods.button_url;
                if (this.mQJ.goods.thread_pic_list != null && advertAppInfo.ete.etv != null) {
                    advertAppInfo.ete.etv.addAll(this.mQJ.goods.thread_pic_list);
                }
                if (y.isEmpty(advertAppInfo.ete.etv) && (Az = AdvertAppInfo.a.Az(this.mQJ.goods.lego_card)) != null && advertAppInfo.ete.etv != null) {
                    advertAppInfo.ete.etv.addAll(Az);
                }
                advertAppInfo.ete.etw = this.mQJ.goods.video_info;
                advertAppInfo.ete.tagName = this.mQJ.goods.tag_name;
                advertAppInfo.ete.adSource = this.mQJ.goods.ad_source;
                advertAppInfo.ete.etx = this.mQJ.goods.tag_name_url;
                advertAppInfo.ete.tagRatio = this.mQJ.goods.tagRatio;
                advertAppInfo.ete.lego_card = this.mQJ.goods.lego_card;
                advertAppInfo.ete.adCloseInfo = this.mQJ.goods.adCloseInfo;
            }
            advertAppInfo.page = dHo();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.bhh().isShowImages() && this.mQJ != null && this.mQJ.legoCard != null && !this.mQJ.legoCard.isNoPicAd()) {
            return AdvertAppInfo.esI;
        }
        if (dHn() == 1001 || dHn() == -1001) {
            return AdvertAppInfo.esI;
        }
        if (dHm() != null) {
            return AdvertAppInfo.esM;
        }
        return null;
    }
}

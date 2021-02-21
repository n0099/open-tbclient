package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class o extends PostData {
    public String eLF;
    public String eLG;
    public String forumId;
    public String jDY;
    public boolean maz;
    private AppData nwU;
    public int pageNumber;
    public int position;
    public long threadId;
    public boolean nwV = false;
    public boolean nwW = false;
    public boolean eLL = false;

    public void g(App app) {
        this.nwU = new AppData(app);
    }

    public void Tp(String str) {
        this.nwU = new AppData(str);
    }

    public AppData dNt() {
        return this.nwU;
    }

    public AdvertAppInfo.ILegoAdvert dNu() {
        if (this.nwU == null) {
            return null;
        }
        return this.nwU.legoCard;
    }

    public String getAdId() {
        return this.nwU == null ? "" : this.nwU.id;
    }

    public boolean bMC() {
        return this.nwU != null && this.nwU.blD() == 0;
    }

    public boolean isApp() {
        if (this.nwU == null) {
            return false;
        }
        return this.nwU.blE();
    }

    public int dNv() {
        if (this.nwU == null || this.nwU.goods == null) {
            return -1;
        }
        return this.nwU.goods.goods_style;
    }

    public int getPosition() {
        if (this.nwU == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.nwU.pos_name, 0);
    }

    public String dNw() {
        if (this.nwV) {
            return "PB_BANNER";
        }
        if (this.maz) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo qS() {
        List<String> zS;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.nwU != null) {
            advertAppInfo.eLJ = this.nwU;
            advertAppInfo.eLt = this.nwU.id;
            advertAppInfo.eLu = this.nwU.name;
            advertAppInfo.abz = this.nwU.url_type;
            advertAppInfo.eLv = this.nwU.url;
            advertAppInfo.deepUrl = this.nwU.deepUrl;
            advertAppInfo.apkUrl = this.nwU.apk_url;
            advertAppInfo.eLw = this.nwU.apk_name;
            advertAppInfo.adPosition = this.nwU.pos_name.trim();
            advertAppInfo.cOQ = this.nwU.first_name;
            advertAppInfo.eLy = this.nwU.second_name;
            advertAppInfo.cpid = this.nwU.cpid;
            advertAppInfo.abtest = this.nwU.abtest;
            advertAppInfo.eLz = this.nwU.plan_id;
            advertAppInfo.userId = this.nwU.user_id;
            advertAppInfo.eLA = this.nwU.verify;
            advertAppInfo.price = this.nwU.price;
            advertAppInfo.extensionInfo = this.nwU.ext_info;
            advertAppInfo.eLB = this.nwU.app_time * 1000;
            advertAppInfo.legoCard = this.nwU.legoCard;
            advertAppInfo.eLI = this.nwU.rawApp;
            if (this.nwU.goods != null) {
                advertAppInfo.eLC.eLQ = this.nwU.goods.pop_window_text;
                advertAppInfo.eLC.eLM = this.nwU.goods.id;
                advertAppInfo.eLC.eLP = this.nwU.goods.thread_pic;
                advertAppInfo.eLC.eLR = this.nwU.goods.goods_style;
                advertAppInfo.eLC.eLN = this.nwU.goods.thread_title;
                advertAppInfo.eLC.eLO = this.nwU.goods.thread_content;
                advertAppInfo.eLC.userName = this.nwU.goods.user_name;
                advertAppInfo.eLC.userPortrait = this.nwU.goods.user_portrait;
                advertAppInfo.eLC.buttonText = this.nwU.goods.button_text;
                advertAppInfo.eLC.eLU = this.nwU.goods.button_url;
                if (this.nwU.goods.thread_pic_list != null && advertAppInfo.eLC.eLV != null) {
                    advertAppInfo.eLC.eLV.addAll(this.nwU.goods.thread_pic_list);
                }
                if (y.isEmpty(advertAppInfo.eLC.eLV) && (zS = AdvertAppInfo.a.zS(this.nwU.goods.lego_card)) != null && advertAppInfo.eLC.eLV != null) {
                    advertAppInfo.eLC.eLV.addAll(zS);
                }
                advertAppInfo.eLC.eLW = this.nwU.goods.video_info;
                advertAppInfo.eLC.tagName = this.nwU.goods.tag_name;
                advertAppInfo.eLC.adSource = this.nwU.goods.ad_source;
                advertAppInfo.eLC.eLX = this.nwU.goods.tag_name_url;
                advertAppInfo.eLC.tagRatio = this.nwU.goods.tagRatio;
                advertAppInfo.eLC.lego_card = this.nwU.goods.lego_card;
                advertAppInfo.eLC.adCloseInfo = this.nwU.goods.adCloseInfo;
            }
            advertAppInfo.page = dNw();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.bkT().isShowImages() && this.nwU != null && this.nwU.legoCard != null && !this.nwU.legoCard.isNoPicAd()) {
            return AdvertAppInfo.eLf;
        }
        if (com.baidu.tbadk.a.d.biU()) {
            return AdvertAppInfo.eLf;
        }
        if (dNv() == 1001 || dNv() == -1001) {
            return AdvertAppInfo.eLf;
        }
        if (dNu() != null) {
            return AdvertAppInfo.eLj;
        }
        return null;
    }
}

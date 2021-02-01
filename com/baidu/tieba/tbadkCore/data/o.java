package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class o extends PostData {
    public String eLG;
    public String eLH;
    public String forumId;
    public String jDK;
    public boolean mai;
    private AppData nwu;
    public boolean nwv = false;
    public boolean nww = false;
    public int pageNumber;
    public int position;
    public long threadId;

    public void e(App app) {
        this.nwu = new AppData(app);
    }

    public void Td(String str) {
        this.nwu = new AppData(str);
    }

    public AppData dNl() {
        return this.nwu;
    }

    public AdvertAppInfo.ILegoAdvert dNm() {
        if (this.nwu == null) {
            return null;
        }
        return this.nwu.legoCard;
    }

    public String getAdId() {
        return this.nwu == null ? "" : this.nwu.id;
    }

    public boolean bMv() {
        return this.nwu != null && this.nwu.blD() == 0;
    }

    public boolean isApp() {
        if (this.nwu == null) {
            return false;
        }
        return this.nwu.blE();
    }

    public int dNn() {
        if (this.nwu == null || this.nwu.goods == null) {
            return -1;
        }
        return this.nwu.goods.goods_style;
    }

    public int getPosition() {
        if (this.nwu == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.nwu.pos_name, 0);
    }

    public String dNo() {
        if (this.nwv) {
            return "PB_BANNER";
        }
        if (this.mai) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo qS() {
        List<String> zS;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.nwu != null) {
            advertAppInfo.eLK = this.nwu;
            advertAppInfo.eLu = this.nwu.id;
            advertAppInfo.eLv = this.nwu.name;
            advertAppInfo.abz = this.nwu.url_type;
            advertAppInfo.eLw = this.nwu.url;
            advertAppInfo.deepUrl = this.nwu.deepUrl;
            advertAppInfo.apkUrl = this.nwu.apk_url;
            advertAppInfo.eLx = this.nwu.apk_name;
            advertAppInfo.adPosition = this.nwu.pos_name.trim();
            advertAppInfo.cOQ = this.nwu.first_name;
            advertAppInfo.eLz = this.nwu.second_name;
            advertAppInfo.cpid = this.nwu.cpid;
            advertAppInfo.abtest = this.nwu.abtest;
            advertAppInfo.eLA = this.nwu.plan_id;
            advertAppInfo.userId = this.nwu.user_id;
            advertAppInfo.eLB = this.nwu.verify;
            advertAppInfo.price = this.nwu.price;
            advertAppInfo.extensionInfo = this.nwu.ext_info;
            advertAppInfo.eLC = this.nwu.app_time * 1000;
            advertAppInfo.legoCard = this.nwu.legoCard;
            if (this.nwu.goods != null) {
                advertAppInfo.eLD.eLQ = this.nwu.goods.pop_window_text;
                advertAppInfo.eLD.eLM = this.nwu.goods.id;
                advertAppInfo.eLD.eLP = this.nwu.goods.thread_pic;
                advertAppInfo.eLD.eLR = this.nwu.goods.goods_style;
                advertAppInfo.eLD.eLN = this.nwu.goods.thread_title;
                advertAppInfo.eLD.eLO = this.nwu.goods.thread_content;
                advertAppInfo.eLD.userName = this.nwu.goods.user_name;
                advertAppInfo.eLD.userPortrait = this.nwu.goods.user_portrait;
                advertAppInfo.eLD.buttonText = this.nwu.goods.button_text;
                advertAppInfo.eLD.eLU = this.nwu.goods.button_url;
                if (this.nwu.goods.thread_pic_list != null && advertAppInfo.eLD.eLV != null) {
                    advertAppInfo.eLD.eLV.addAll(this.nwu.goods.thread_pic_list);
                }
                if (y.isEmpty(advertAppInfo.eLD.eLV) && (zS = AdvertAppInfo.a.zS(this.nwu.goods.lego_card)) != null && advertAppInfo.eLD.eLV != null) {
                    advertAppInfo.eLD.eLV.addAll(zS);
                }
                advertAppInfo.eLD.eLW = this.nwu.goods.video_info;
                advertAppInfo.eLD.tagName = this.nwu.goods.tag_name;
                advertAppInfo.eLD.adSource = this.nwu.goods.ad_source;
                advertAppInfo.eLD.eLX = this.nwu.goods.tag_name_url;
                advertAppInfo.eLD.tagRatio = this.nwu.goods.tagRatio;
                advertAppInfo.eLD.lego_card = this.nwu.goods.lego_card;
                advertAppInfo.eLD.adCloseInfo = this.nwu.goods.adCloseInfo;
            }
            advertAppInfo.page = dNo();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.bkT().isShowImages() && this.nwu != null && this.nwu.legoCard != null && !this.nwu.legoCard.isNoPicAd()) {
            return AdvertAppInfo.eLf;
        }
        if (com.baidu.tbadk.a.d.biU()) {
            return AdvertAppInfo.eLf;
        }
        if (dNn() == 1001 || dNn() == -1001) {
            return AdvertAppInfo.eLf;
        }
        if (dNm() != null) {
            return AdvertAppInfo.eLj;
        }
        return null;
    }
}

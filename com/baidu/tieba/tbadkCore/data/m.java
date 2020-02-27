package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String cNh;
    public String cNi;
    public String forumId;
    public String gFG;
    public boolean iPe;
    private AppData kgn;
    public boolean kgo = false;
    public boolean kgp = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.kgn = new AppData(app);
    }

    public void Ja(String str) {
        this.kgn = new AppData(str);
    }

    public AppData cKM() {
        return this.kgn;
    }

    public AdvertAppInfo.ILegoAdvert cKN() {
        if (this.kgn == null) {
            return null;
        }
        return this.kgn.legoCard;
    }

    public String getAdId() {
        return this.kgn == null ? "" : this.kgn.id;
    }

    public boolean isValidate() {
        return this.kgn != null && this.kgn.aAn() == 0;
    }

    public boolean isApp() {
        if (this.kgn == null) {
            return false;
        }
        return this.kgn.aAo();
    }

    public int cKO() {
        if (this.kgn == null || this.kgn.goods == null) {
            return -1;
        }
        return this.kgn.goods.goods_style;
    }

    public int getPosition() {
        if (this.kgn == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.kgn.pos_name, 0);
    }

    public String cKP() {
        if (this.kgo) {
            return "PB_BANNER";
        }
        if (this.iPe) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo kK() {
        List<String> sv;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.kgn != null) {
            advertAppInfo.cNl = this.kgn;
            advertAppInfo.cMV = this.kgn.id;
            advertAppInfo.cMW = this.kgn.name;
            advertAppInfo.Ez = this.kgn.url_type;
            advertAppInfo.cMX = this.kgn.url;
            advertAppInfo.deepUrl = this.kgn.deepUrl;
            advertAppInfo.apkUrl = this.kgn.apk_url;
            advertAppInfo.cMY = this.kgn.apk_name;
            advertAppInfo.adPosition = this.kgn.pos_name.trim();
            advertAppInfo.blE = this.kgn.first_name;
            advertAppInfo.cNa = this.kgn.second_name;
            advertAppInfo.cpid = this.kgn.cpid;
            advertAppInfo.abtest = this.kgn.abtest;
            advertAppInfo.cNb = this.kgn.plan_id;
            advertAppInfo.userId = this.kgn.user_id;
            advertAppInfo.cNc = this.kgn.verify;
            advertAppInfo.price = this.kgn.price;
            advertAppInfo.extensionInfo = this.kgn.ext_info;
            advertAppInfo.cNd = this.kgn.app_time * 1000;
            advertAppInfo.legoCard = this.kgn.legoCard;
            if (this.kgn.goods != null) {
                advertAppInfo.cNe.cNq = this.kgn.goods.pop_window_text;
                advertAppInfo.cNe.cNm = this.kgn.goods.id;
                advertAppInfo.cNe.cNp = this.kgn.goods.thread_pic;
                advertAppInfo.cNe.cNr = this.kgn.goods.goods_style;
                advertAppInfo.cNe.cNn = this.kgn.goods.thread_title;
                advertAppInfo.cNe.cNo = this.kgn.goods.thread_content;
                advertAppInfo.cNe.userName = this.kgn.goods.user_name;
                advertAppInfo.cNe.userPortrait = this.kgn.goods.user_portrait;
                advertAppInfo.cNe.buttonText = this.kgn.goods.button_text;
                advertAppInfo.cNe.cNu = this.kgn.goods.button_url;
                if (this.kgn.goods.thread_pic_list != null && advertAppInfo.cNe.cNv != null) {
                    advertAppInfo.cNe.cNv.addAll(this.kgn.goods.thread_pic_list);
                }
                if (v.isEmpty(advertAppInfo.cNe.cNv) && (sv = AdvertAppInfo.a.sv(this.kgn.goods.lego_card)) != null && advertAppInfo.cNe.cNv != null) {
                    advertAppInfo.cNe.cNv.addAll(sv);
                }
                advertAppInfo.cNe.cNw = this.kgn.goods.video_info;
                advertAppInfo.cNe.tagName = this.kgn.goods.tag_name;
                advertAppInfo.cNe.adSource = this.kgn.goods.ad_source;
                advertAppInfo.cNe.cNx = this.kgn.goods.tag_name_url;
                advertAppInfo.cNe.tagRatio = this.kgn.goods.tagRatio;
                advertAppInfo.cNe.lego_card = this.kgn.goods.lego_card;
                advertAppInfo.cNe.adCloseInfo = this.kgn.goods.adCloseInfo;
            }
            advertAppInfo.page = cKP();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.azM().isShowImages() && this.kgn != null && this.kgn.legoCard != null && !this.kgn.legoCard.isNoPicAd()) {
            return AdvertAppInfo.cMJ;
        }
        if (cKO() == 1001 || cKO() == -1001) {
            return AdvertAppInfo.cMJ;
        }
        if (cKN() != null) {
            return AdvertAppInfo.cMN;
        }
        return null;
    }
}

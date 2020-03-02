package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String cNi;
    public String cNj;
    public String forumId;
    public String gFI;
    public boolean iPg;
    private AppData kgp;
    public boolean kgq = false;
    public boolean kgr = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.kgp = new AppData(app);
    }

    public void Ja(String str) {
        this.kgp = new AppData(str);
    }

    public AppData cKO() {
        return this.kgp;
    }

    public AdvertAppInfo.ILegoAdvert cKP() {
        if (this.kgp == null) {
            return null;
        }
        return this.kgp.legoCard;
    }

    public String getAdId() {
        return this.kgp == null ? "" : this.kgp.id;
    }

    public boolean isValidate() {
        return this.kgp != null && this.kgp.aAp() == 0;
    }

    public boolean isApp() {
        if (this.kgp == null) {
            return false;
        }
        return this.kgp.aAq();
    }

    public int cKQ() {
        if (this.kgp == null || this.kgp.goods == null) {
            return -1;
        }
        return this.kgp.goods.goods_style;
    }

    public int getPosition() {
        if (this.kgp == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.kgp.pos_name, 0);
    }

    public String cKR() {
        if (this.kgq) {
            return "PB_BANNER";
        }
        if (this.iPg) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo kK() {
        List<String> sv;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.kgp != null) {
            advertAppInfo.cNm = this.kgp;
            advertAppInfo.cMW = this.kgp.id;
            advertAppInfo.cMX = this.kgp.name;
            advertAppInfo.Ez = this.kgp.url_type;
            advertAppInfo.cMY = this.kgp.url;
            advertAppInfo.deepUrl = this.kgp.deepUrl;
            advertAppInfo.apkUrl = this.kgp.apk_url;
            advertAppInfo.cMZ = this.kgp.apk_name;
            advertAppInfo.adPosition = this.kgp.pos_name.trim();
            advertAppInfo.blF = this.kgp.first_name;
            advertAppInfo.cNb = this.kgp.second_name;
            advertAppInfo.cpid = this.kgp.cpid;
            advertAppInfo.abtest = this.kgp.abtest;
            advertAppInfo.cNc = this.kgp.plan_id;
            advertAppInfo.userId = this.kgp.user_id;
            advertAppInfo.cNd = this.kgp.verify;
            advertAppInfo.price = this.kgp.price;
            advertAppInfo.extensionInfo = this.kgp.ext_info;
            advertAppInfo.cNe = this.kgp.app_time * 1000;
            advertAppInfo.legoCard = this.kgp.legoCard;
            if (this.kgp.goods != null) {
                advertAppInfo.cNf.cNr = this.kgp.goods.pop_window_text;
                advertAppInfo.cNf.cNn = this.kgp.goods.id;
                advertAppInfo.cNf.cNq = this.kgp.goods.thread_pic;
                advertAppInfo.cNf.cNs = this.kgp.goods.goods_style;
                advertAppInfo.cNf.cNo = this.kgp.goods.thread_title;
                advertAppInfo.cNf.cNp = this.kgp.goods.thread_content;
                advertAppInfo.cNf.userName = this.kgp.goods.user_name;
                advertAppInfo.cNf.userPortrait = this.kgp.goods.user_portrait;
                advertAppInfo.cNf.buttonText = this.kgp.goods.button_text;
                advertAppInfo.cNf.cNv = this.kgp.goods.button_url;
                if (this.kgp.goods.thread_pic_list != null && advertAppInfo.cNf.cNw != null) {
                    advertAppInfo.cNf.cNw.addAll(this.kgp.goods.thread_pic_list);
                }
                if (v.isEmpty(advertAppInfo.cNf.cNw) && (sv = AdvertAppInfo.a.sv(this.kgp.goods.lego_card)) != null && advertAppInfo.cNf.cNw != null) {
                    advertAppInfo.cNf.cNw.addAll(sv);
                }
                advertAppInfo.cNf.cNx = this.kgp.goods.video_info;
                advertAppInfo.cNf.tagName = this.kgp.goods.tag_name;
                advertAppInfo.cNf.adSource = this.kgp.goods.ad_source;
                advertAppInfo.cNf.cNy = this.kgp.goods.tag_name_url;
                advertAppInfo.cNf.tagRatio = this.kgp.goods.tagRatio;
                advertAppInfo.cNf.lego_card = this.kgp.goods.lego_card;
                advertAppInfo.cNf.adCloseInfo = this.kgp.goods.adCloseInfo;
            }
            advertAppInfo.page = cKR();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.azO().isShowImages() && this.kgp != null && this.kgp.legoCard != null && !this.kgp.legoCard.isNoPicAd()) {
            return AdvertAppInfo.cMK;
        }
        if (cKQ() == 1001 || cKQ() == -1001) {
            return AdvertAppInfo.cMK;
        }
        if (cKP() != null) {
            return AdvertAppInfo.cMO;
        }
        return null;
    }
}

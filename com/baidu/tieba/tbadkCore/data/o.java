package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class o extends PostData {
    public String eNg;
    public String eNh;
    public String forumId;
    public String jFH;
    public boolean mcB;
    private AppData nyZ;
    public int pageNumber;
    public int position;
    public long threadId;
    public boolean nza = false;
    public boolean nzb = false;
    public boolean eNm = false;

    public void h(App app) {
        this.nyZ = new AppData(app);
    }

    public void Tw(String str) {
        this.nyZ = new AppData(str);
    }

    public AppData dNC() {
        return this.nyZ;
    }

    public AdvertAppInfo.ILegoAdvert dND() {
        if (this.nyZ == null) {
            return null;
        }
        return this.nyZ.legoCard;
    }

    public String getAdId() {
        return this.nyZ == null ? "" : this.nyZ.id;
    }

    public boolean bMF() {
        return this.nyZ != null && this.nyZ.blF() == 0;
    }

    public boolean isApp() {
        return this.nyZ != null && this.nyZ.blG();
    }

    public int dNE() {
        if (this.nyZ == null || this.nyZ.goods == null) {
            return -1;
        }
        return this.nyZ.goods.goods_style;
    }

    public int getPosition() {
        if (this.nyZ == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.nyZ.pos_name, 0);
    }

    public String dNF() {
        if (this.nza) {
            return "PB_BANNER";
        }
        if (this.mcB) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo qS() {
        List<String> zZ;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.nyZ != null) {
            advertAppInfo.eNk = this.nyZ;
            advertAppInfo.eMU = this.nyZ.id;
            advertAppInfo.eMV = this.nyZ.name;
            advertAppInfo.acV = this.nyZ.url_type;
            advertAppInfo.eMW = this.nyZ.url;
            advertAppInfo.deepUrl = this.nyZ.deepUrl;
            advertAppInfo.apkUrl = this.nyZ.apk_url;
            advertAppInfo.eMX = this.nyZ.apk_name;
            advertAppInfo.adPosition = this.nyZ.pos_name.trim();
            advertAppInfo.cQq = this.nyZ.first_name;
            advertAppInfo.eMZ = this.nyZ.second_name;
            advertAppInfo.cpid = this.nyZ.cpid;
            advertAppInfo.abtest = this.nyZ.abtest;
            advertAppInfo.eNa = this.nyZ.plan_id;
            advertAppInfo.userId = this.nyZ.user_id;
            advertAppInfo.eNb = this.nyZ.verify;
            advertAppInfo.price = this.nyZ.price;
            advertAppInfo.extensionInfo = this.nyZ.ext_info;
            advertAppInfo.eNc = this.nyZ.app_time * 1000;
            advertAppInfo.legoCard = this.nyZ.legoCard;
            advertAppInfo.eNj = this.nyZ.rawApp;
            if (this.nyZ.goods != null) {
                advertAppInfo.eNd.eNr = this.nyZ.goods.pop_window_text;
                advertAppInfo.eNd.eNn = this.nyZ.goods.id;
                advertAppInfo.eNd.eNq = this.nyZ.goods.thread_pic;
                advertAppInfo.eNd.eNs = this.nyZ.goods.goods_style;
                advertAppInfo.eNd.eNo = this.nyZ.goods.thread_title;
                advertAppInfo.eNd.eNp = this.nyZ.goods.thread_content;
                advertAppInfo.eNd.userName = this.nyZ.goods.user_name;
                advertAppInfo.eNd.userPortrait = this.nyZ.goods.user_portrait;
                advertAppInfo.eNd.buttonText = this.nyZ.goods.button_text;
                advertAppInfo.eNd.eNv = this.nyZ.goods.button_url;
                if (this.nyZ.goods.thread_pic_list != null && advertAppInfo.eNd.eNw != null) {
                    advertAppInfo.eNd.eNw.addAll(this.nyZ.goods.thread_pic_list);
                }
                if (y.isEmpty(advertAppInfo.eNd.eNw) && (zZ = AdvertAppInfo.a.zZ(this.nyZ.goods.lego_card)) != null && advertAppInfo.eNd.eNw != null) {
                    advertAppInfo.eNd.eNw.addAll(zZ);
                }
                advertAppInfo.eNd.eNx = this.nyZ.goods.video_info;
                advertAppInfo.eNd.tagName = this.nyZ.goods.tag_name;
                advertAppInfo.eNd.adSource = this.nyZ.goods.ad_source;
                advertAppInfo.eNd.eNy = this.nyZ.goods.tag_name_url;
                advertAppInfo.eNd.tagRatio = this.nyZ.goods.tagRatio;
                advertAppInfo.eNd.lego_card = this.nyZ.goods.lego_card;
                advertAppInfo.eNd.adCloseInfo = this.nyZ.goods.adCloseInfo;
            }
            advertAppInfo.page = dNF();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.bkV().isShowImages() && this.nyZ != null && this.nyZ.legoCard != null && !this.nyZ.legoCard.isNoPicAd()) {
            return AdvertAppInfo.eMG;
        }
        if (com.baidu.tbadk.a.d.biW() && this.nza) {
            return AdvertAppInfo.eMG;
        }
        if (dNE() == 1001 || dNE() == -1001) {
            return AdvertAppInfo.eMG;
        }
        if (dND() != null) {
            return AdvertAppInfo.eMK;
        }
        return null;
    }
}

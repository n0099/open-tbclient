package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class n extends PostData {
    public String eza;
    public String ezb;
    public String forumId;
    public String jbX;
    public boolean lCw;
    private AppData mWN;
    public boolean mWO = false;
    public boolean mWP = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.mWN = new AppData(app);
    }

    public void SQ(String str) {
        this.mWN = new AppData(str);
    }

    public AppData dJN() {
        return this.mWN;
    }

    public AdvertAppInfo.ILegoAdvert dJO() {
        if (this.mWN == null) {
            return null;
        }
        return this.mWN.legoCard;
    }

    public String getAdId() {
        return this.mWN == null ? "" : this.mWN.id;
    }

    public boolean isValidate() {
        return this.mWN != null && this.mWN.bkr() == 0;
    }

    public boolean isApp() {
        if (this.mWN == null) {
            return false;
        }
        return this.mWN.bks();
    }

    public int dJP() {
        if (this.mWN == null || this.mWN.goods == null) {
            return -1;
        }
        return this.mWN.goods.goods_style;
    }

    public int getPosition() {
        if (this.mWN == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.mWN.pos_name, 0);
    }

    public String dJQ() {
        if (this.mWO) {
            return "PB_BANNER";
        }
        if (this.lCw) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo rq() {
        List<String> AN;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.mWN != null) {
            advertAppInfo.eze = this.mWN;
            advertAppInfo.eyO = this.mWN.id;
            advertAppInfo.eyP = this.mWN.name;
            advertAppInfo.ZU = this.mWN.url_type;
            advertAppInfo.eyQ = this.mWN.url;
            advertAppInfo.deepUrl = this.mWN.deepUrl;
            advertAppInfo.apkUrl = this.mWN.apk_url;
            advertAppInfo.eyR = this.mWN.apk_name;
            advertAppInfo.adPosition = this.mWN.pos_name.trim();
            advertAppInfo.cHj = this.mWN.first_name;
            advertAppInfo.eyT = this.mWN.second_name;
            advertAppInfo.cpid = this.mWN.cpid;
            advertAppInfo.abtest = this.mWN.abtest;
            advertAppInfo.eyU = this.mWN.plan_id;
            advertAppInfo.userId = this.mWN.user_id;
            advertAppInfo.eyV = this.mWN.verify;
            advertAppInfo.price = this.mWN.price;
            advertAppInfo.extensionInfo = this.mWN.ext_info;
            advertAppInfo.eyW = this.mWN.app_time * 1000;
            advertAppInfo.legoCard = this.mWN.legoCard;
            if (this.mWN.goods != null) {
                advertAppInfo.eyX.ezj = this.mWN.goods.pop_window_text;
                advertAppInfo.eyX.ezf = this.mWN.goods.id;
                advertAppInfo.eyX.ezi = this.mWN.goods.thread_pic;
                advertAppInfo.eyX.ezk = this.mWN.goods.goods_style;
                advertAppInfo.eyX.ezg = this.mWN.goods.thread_title;
                advertAppInfo.eyX.ezh = this.mWN.goods.thread_content;
                advertAppInfo.eyX.userName = this.mWN.goods.user_name;
                advertAppInfo.eyX.userPortrait = this.mWN.goods.user_portrait;
                advertAppInfo.eyX.buttonText = this.mWN.goods.button_text;
                advertAppInfo.eyX.ezn = this.mWN.goods.button_url;
                if (this.mWN.goods.thread_pic_list != null && advertAppInfo.eyX.ezo != null) {
                    advertAppInfo.eyX.ezo.addAll(this.mWN.goods.thread_pic_list);
                }
                if (y.isEmpty(advertAppInfo.eyX.ezo) && (AN = AdvertAppInfo.a.AN(this.mWN.goods.lego_card)) != null && advertAppInfo.eyX.ezo != null) {
                    advertAppInfo.eyX.ezo.addAll(AN);
                }
                advertAppInfo.eyX.ezp = this.mWN.goods.video_info;
                advertAppInfo.eyX.tagName = this.mWN.goods.tag_name;
                advertAppInfo.eyX.adSource = this.mWN.goods.ad_source;
                advertAppInfo.eyX.ezq = this.mWN.goods.tag_name_url;
                advertAppInfo.eyX.tagRatio = this.mWN.goods.tagRatio;
                advertAppInfo.eyX.lego_card = this.mWN.goods.lego_card;
                advertAppInfo.eyX.adCloseInfo = this.mWN.goods.adCloseInfo;
            }
            advertAppInfo.page = dJQ();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.bjH().isShowImages() && this.mWN != null && this.mWN.legoCard != null && !this.mWN.legoCard.isNoPicAd()) {
            return AdvertAppInfo.eyC;
        }
        if (dJP() == 1001 || dJP() == -1001) {
            return AdvertAppInfo.eyC;
        }
        if (dJO() != null) {
            return AdvertAppInfo.eyG;
        }
        return null;
    }
}

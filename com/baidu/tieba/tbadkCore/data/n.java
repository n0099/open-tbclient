package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class n extends PostData {
    public String exo;
    public String exp;
    public String forumId;
    public String jcK;
    public boolean lCO;
    private AppData mXF;
    public boolean mXG = false;
    public boolean mXH = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.mXF = new AppData(app);
    }

    public void Sr(String str) {
        this.mXF = new AppData(str);
    }

    public AppData dJE() {
        return this.mXF;
    }

    public AdvertAppInfo.ILegoAdvert dJF() {
        if (this.mXF == null) {
            return null;
        }
        return this.mXF.legoCard;
    }

    public String getAdId() {
        return this.mXF == null ? "" : this.mXF.id;
    }

    public boolean isValidate() {
        return this.mXF != null && this.mXF.bjt() == 0;
    }

    public boolean isApp() {
        if (this.mXF == null) {
            return false;
        }
        return this.mXF.bju();
    }

    public int dJG() {
        if (this.mXF == null || this.mXF.goods == null) {
            return -1;
        }
        return this.mXF.goods.goods_style;
    }

    public int getPosition() {
        if (this.mXF == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.mXF.pos_name, 0);
    }

    public String dJH() {
        if (this.mXG) {
            return "PB_BANNER";
        }
        if (this.lCO) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo rq() {
        List<String> Ai;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.mXF != null) {
            advertAppInfo.exs = this.mXF;
            advertAppInfo.exc = this.mXF.id;
            advertAppInfo.exd = this.mXF.name;
            advertAppInfo.ZZ = this.mXF.url_type;
            advertAppInfo.exe = this.mXF.url;
            advertAppInfo.deepUrl = this.mXF.deepUrl;
            advertAppInfo.apkUrl = this.mXF.apk_url;
            advertAppInfo.exf = this.mXF.apk_name;
            advertAppInfo.adPosition = this.mXF.pos_name.trim();
            advertAppInfo.cFz = this.mXF.first_name;
            advertAppInfo.exh = this.mXF.second_name;
            advertAppInfo.cpid = this.mXF.cpid;
            advertAppInfo.abtest = this.mXF.abtest;
            advertAppInfo.exi = this.mXF.plan_id;
            advertAppInfo.userId = this.mXF.user_id;
            advertAppInfo.exj = this.mXF.verify;
            advertAppInfo.price = this.mXF.price;
            advertAppInfo.extensionInfo = this.mXF.ext_info;
            advertAppInfo.exk = this.mXF.app_time * 1000;
            advertAppInfo.legoCard = this.mXF.legoCard;
            if (this.mXF.goods != null) {
                advertAppInfo.exl.exy = this.mXF.goods.pop_window_text;
                advertAppInfo.exl.exu = this.mXF.goods.id;
                advertAppInfo.exl.exx = this.mXF.goods.thread_pic;
                advertAppInfo.exl.exz = this.mXF.goods.goods_style;
                advertAppInfo.exl.exv = this.mXF.goods.thread_title;
                advertAppInfo.exl.exw = this.mXF.goods.thread_content;
                advertAppInfo.exl.userName = this.mXF.goods.user_name;
                advertAppInfo.exl.userPortrait = this.mXF.goods.user_portrait;
                advertAppInfo.exl.buttonText = this.mXF.goods.button_text;
                advertAppInfo.exl.exC = this.mXF.goods.button_url;
                if (this.mXF.goods.thread_pic_list != null && advertAppInfo.exl.exD != null) {
                    advertAppInfo.exl.exD.addAll(this.mXF.goods.thread_pic_list);
                }
                if (y.isEmpty(advertAppInfo.exl.exD) && (Ai = AdvertAppInfo.a.Ai(this.mXF.goods.lego_card)) != null && advertAppInfo.exl.exD != null) {
                    advertAppInfo.exl.exD.addAll(Ai);
                }
                advertAppInfo.exl.exE = this.mXF.goods.video_info;
                advertAppInfo.exl.tagName = this.mXF.goods.tag_name;
                advertAppInfo.exl.adSource = this.mXF.goods.ad_source;
                advertAppInfo.exl.exF = this.mXF.goods.tag_name_url;
                advertAppInfo.exl.tagRatio = this.mXF.goods.tagRatio;
                advertAppInfo.exl.lego_card = this.mXF.goods.lego_card;
                advertAppInfo.exl.adCloseInfo = this.mXF.goods.adCloseInfo;
            }
            advertAppInfo.page = dJH();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.biL().isShowImages() && this.mXF != null && this.mXF.legoCard != null && !this.mXF.legoCard.isNoPicAd()) {
            return AdvertAppInfo.ewQ;
        }
        if (dJG() == 1001 || dJG() == -1001) {
            return AdvertAppInfo.ewQ;
        }
        if (dJF() != null) {
            return AdvertAppInfo.ewU;
        }
        return null;
    }
}

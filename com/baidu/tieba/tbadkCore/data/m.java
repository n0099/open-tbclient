package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String cIT;
    public String cIU;
    public String forumId;
    public String gAx;
    private AppData kbF;
    public boolean kbG = false;
    public boolean kbH = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.kbF = new AppData(app);
    }

    public void IC(String str) {
        this.kbF = new AppData(str);
    }

    public AppData cIh() {
        return this.kbF;
    }

    public AdvertAppInfo.ILegoAdvert cIi() {
        if (this.kbF == null) {
            return null;
        }
        return this.kbF.legoCard;
    }

    public String getAdId() {
        return this.kbF == null ? "" : this.kbF.id;
    }

    public boolean isValidate() {
        return this.kbF != null && this.kbF.axG() == 0;
    }

    public boolean isApp() {
        if (this.kbF == null) {
            return false;
        }
        return this.kbF.axH();
    }

    public int cIj() {
        if (this.kbF == null || this.kbF.goods == null) {
            return -1;
        }
        return this.kbF.goods.goods_style;
    }

    public int getPosition() {
        if (this.kbF == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.kbF.pos_name, 0);
    }

    public String cIk() {
        return this.kbG ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo ku() {
        List<String> sb;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.kbF != null) {
            advertAppInfo.cIX = this.kbF;
            advertAppInfo.cIG = this.kbF.id;
            advertAppInfo.cIH = this.kbF.name;
            advertAppInfo.Eb = this.kbF.url_type;
            advertAppInfo.cII = this.kbF.url;
            advertAppInfo.deepUrl = this.kbF.deepUrl;
            advertAppInfo.cIJ = this.kbF.apk_url;
            advertAppInfo.cIK = this.kbF.apk_name;
            advertAppInfo.adPosition = this.kbF.pos_name.trim();
            advertAppInfo.bgD = this.kbF.first_name;
            advertAppInfo.cIM = this.kbF.second_name;
            advertAppInfo.cpid = this.kbF.cpid;
            advertAppInfo.abtest = this.kbF.abtest;
            advertAppInfo.cIN = this.kbF.plan_id;
            advertAppInfo.userId = this.kbF.user_id;
            advertAppInfo.cIO = this.kbF.verify;
            advertAppInfo.price = this.kbF.price;
            advertAppInfo.extensionInfo = this.kbF.ext_info;
            advertAppInfo.cIP = this.kbF.app_time * 1000;
            advertAppInfo.legoCard = this.kbF.legoCard;
            if (this.kbF.goods != null) {
                advertAppInfo.cIQ.cJc = this.kbF.goods.pop_window_text;
                advertAppInfo.cIQ.cIY = this.kbF.goods.id;
                advertAppInfo.cIQ.cJb = this.kbF.goods.thread_pic;
                advertAppInfo.cIQ.cJd = this.kbF.goods.goods_style;
                advertAppInfo.cIQ.cIZ = this.kbF.goods.thread_title;
                advertAppInfo.cIQ.cJa = this.kbF.goods.thread_content;
                advertAppInfo.cIQ.userName = this.kbF.goods.user_name;
                advertAppInfo.cIQ.userPortrait = this.kbF.goods.user_portrait;
                advertAppInfo.cIQ.buttonText = this.kbF.goods.button_text;
                advertAppInfo.cIQ.cJg = this.kbF.goods.button_url;
                if (this.kbF.goods.thread_pic_list != null && advertAppInfo.cIQ.cJh != null) {
                    advertAppInfo.cIQ.cJh.addAll(this.kbF.goods.thread_pic_list);
                }
                if (v.isEmpty(advertAppInfo.cIQ.cJh) && (sb = AdvertAppInfo.a.sb(this.kbF.goods.lego_card)) != null && advertAppInfo.cIQ.cJh != null) {
                    advertAppInfo.cIQ.cJh.addAll(sb);
                }
                advertAppInfo.cIQ.cJi = this.kbF.goods.video_info;
                advertAppInfo.cIQ.tagName = this.kbF.goods.tag_name;
                advertAppInfo.cIQ.adSource = this.kbF.goods.ad_source;
                advertAppInfo.cIQ.cJj = this.kbF.goods.tag_name_url;
                advertAppInfo.cIQ.tagRatio = this.kbF.goods.tagRatio;
                advertAppInfo.cIQ.lego_card = this.kbF.goods.lego_card;
                advertAppInfo.cIQ.adCloseInfo = this.kbF.goods.adCloseInfo;
            }
            advertAppInfo.page = cIk();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.axf().isShowImages() && this.kbF != null && this.kbF.legoCard != null && !this.kbF.legoCard.isNoPicAd()) {
            return AdvertAppInfo.cIu;
        }
        if (cIj() == 1001 || cIj() == -1001) {
            return AdvertAppInfo.cIu;
        }
        if (cIi() != null) {
            return AdvertAppInfo.cIy;
        }
        return null;
    }
}

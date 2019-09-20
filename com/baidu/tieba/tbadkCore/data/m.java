package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String bFF;
    public String bFG;
    public String fNI;
    public String forumId;
    private AppData jiw;
    public boolean jix = false;
    public boolean jiy = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.jiw = new AppData(app);
    }

    public void Fj(String str) {
        this.jiw = new AppData(str);
    }

    public AppData cqn() {
        return this.jiw;
    }

    public AdvertAppInfo.ILegoAdvert cqo() {
        if (this.jiw == null) {
            return null;
        }
        return this.jiw.legoCard;
    }

    public String getAdId() {
        return this.jiw == null ? "" : this.jiw.id;
    }

    public boolean aEw() {
        return this.jiw != null && this.jiw.acL() == 0;
    }

    public boolean isApp() {
        if (this.jiw == null) {
            return false;
        }
        return this.jiw.acM();
    }

    public int cqp() {
        if (this.jiw == null || this.jiw.goods == null) {
            return -1;
        }
        return this.jiw.goods.goods_style;
    }

    public int getPosition() {
        if (this.jiw == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.f(this.jiw.pos_name, 0);
    }

    public String cqq() {
        return this.jix ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo pi() {
        List<String> mq;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.jiw != null) {
            advertAppInfo.bFJ = this.jiw;
            advertAppInfo.bFs = this.jiw.id;
            advertAppInfo.bFt = this.jiw.name;
            advertAppInfo.SA = this.jiw.url_type;
            advertAppInfo.bFu = this.jiw.url;
            advertAppInfo.deepUrl = this.jiw.deepUrl;
            advertAppInfo.bFv = this.jiw.apk_url;
            advertAppInfo.bFw = this.jiw.apk_name;
            advertAppInfo.adPosition = this.jiw.pos_name.trim();
            advertAppInfo.aoU = this.jiw.first_name;
            advertAppInfo.bFy = this.jiw.second_name;
            advertAppInfo.cpid = this.jiw.cpid;
            advertAppInfo.abtest = this.jiw.abtest;
            advertAppInfo.bFz = this.jiw.plan_id;
            advertAppInfo.userId = this.jiw.user_id;
            advertAppInfo.bFA = this.jiw.verify;
            advertAppInfo.price = this.jiw.price;
            advertAppInfo.extensionInfo = this.jiw.ext_info;
            advertAppInfo.bFB = this.jiw.app_time * 1000;
            advertAppInfo.legoCard = this.jiw.legoCard;
            if (this.jiw.goods != null) {
                advertAppInfo.bFC.bFO = this.jiw.goods.pop_window_text;
                advertAppInfo.bFC.bFK = this.jiw.goods.id;
                advertAppInfo.bFC.bFN = this.jiw.goods.thread_pic;
                advertAppInfo.bFC.bFP = this.jiw.goods.goods_style;
                advertAppInfo.bFC.bFL = this.jiw.goods.thread_title;
                advertAppInfo.bFC.bFM = this.jiw.goods.thread_content;
                advertAppInfo.bFC.userName = this.jiw.goods.user_name;
                advertAppInfo.bFC.userPortrait = this.jiw.goods.user_portrait;
                advertAppInfo.bFC.buttonText = this.jiw.goods.button_text;
                advertAppInfo.bFC.bFS = this.jiw.goods.button_url;
                if (this.jiw.goods.thread_pic_list != null && advertAppInfo.bFC.bFT != null) {
                    advertAppInfo.bFC.bFT.addAll(this.jiw.goods.thread_pic_list);
                }
                if (v.aa(advertAppInfo.bFC.bFT) && (mq = AdvertAppInfo.a.mq(this.jiw.goods.lego_card)) != null && advertAppInfo.bFC.bFT != null) {
                    advertAppInfo.bFC.bFT.addAll(mq);
                }
                advertAppInfo.bFC.bFU = this.jiw.goods.video_info;
                advertAppInfo.bFC.tagName = this.jiw.goods.tag_name;
                advertAppInfo.bFC.adSource = this.jiw.goods.ad_source;
                advertAppInfo.bFC.bFV = this.jiw.goods.tag_name_url;
                advertAppInfo.bFC.tagRatio = this.jiw.goods.tagRatio;
                advertAppInfo.bFC.lego_card = this.jiw.goods.lego_card;
                advertAppInfo.bFC.adCloseInfo = this.jiw.goods.adCloseInfo;
            }
            advertAppInfo.page = cqq();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.ace().aci() && this.jiw != null && this.jiw.legoCard != null && !this.jiw.legoCard.isNoPicAd()) {
            return AdvertAppInfo.bFg;
        }
        if (cqp() == 1001 || cqp() == -1001) {
            return AdvertAppInfo.bFg;
        }
        if (cqo() != null) {
            return AdvertAppInfo.bFk;
        }
        return null;
    }
}

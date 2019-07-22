package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class m extends PostData {
    public String bFg;
    public String bFh;
    public String fLf;
    public String forumId;
    private AppData jeT;
    public boolean jeU = false;
    public boolean jeV = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.jeT = new AppData(app);
    }

    public void EI(String str) {
        this.jeT = new AppData(str);
    }

    public AppData cpd() {
        return this.jeT;
    }

    public AdvertAppInfo.ILegoAdvert cpe() {
        if (this.jeT == null) {
            return null;
        }
        return this.jeT.legoCard;
    }

    public String getAdId() {
        return this.jeT == null ? "" : this.jeT.id;
    }

    public boolean aDQ() {
        return this.jeT != null && this.jeT.acG() == 0;
    }

    public boolean isApp() {
        if (this.jeT == null) {
            return false;
        }
        return this.jeT.acH();
    }

    public int cpf() {
        if (this.jeT == null || this.jeT.goods == null) {
            return -1;
        }
        return this.jeT.goods.goods_style;
    }

    public int getPosition() {
        if (this.jeT == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.f(this.jeT.pos_name, 0);
    }

    public String cpg() {
        return this.jeU ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo ph() {
        List<String> mo;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.jeT != null) {
            advertAppInfo.bFk = this.jeT;
            advertAppInfo.bET = this.jeT.id;
            advertAppInfo.bEU = this.jeT.name;
            advertAppInfo.SB = this.jeT.url_type;
            advertAppInfo.bEV = this.jeT.url;
            advertAppInfo.deepUrl = this.jeT.deepUrl;
            advertAppInfo.bEW = this.jeT.apk_url;
            advertAppInfo.bEX = this.jeT.apk_name;
            advertAppInfo.adPosition = this.jeT.pos_name.trim();
            advertAppInfo.aow = this.jeT.first_name;
            advertAppInfo.bEZ = this.jeT.second_name;
            advertAppInfo.cpid = this.jeT.cpid;
            advertAppInfo.abtest = this.jeT.abtest;
            advertAppInfo.bFa = this.jeT.plan_id;
            advertAppInfo.userId = this.jeT.user_id;
            advertAppInfo.bFb = this.jeT.verify;
            advertAppInfo.price = this.jeT.price;
            advertAppInfo.extensionInfo = this.jeT.ext_info;
            advertAppInfo.bFc = this.jeT.app_time * 1000;
            advertAppInfo.legoCard = this.jeT.legoCard;
            if (this.jeT.goods != null) {
                advertAppInfo.bFd.bFp = this.jeT.goods.pop_window_text;
                advertAppInfo.bFd.bFl = this.jeT.goods.id;
                advertAppInfo.bFd.bFo = this.jeT.goods.thread_pic;
                advertAppInfo.bFd.bFq = this.jeT.goods.goods_style;
                advertAppInfo.bFd.bFm = this.jeT.goods.thread_title;
                advertAppInfo.bFd.bFn = this.jeT.goods.thread_content;
                advertAppInfo.bFd.userName = this.jeT.goods.user_name;
                advertAppInfo.bFd.userPortrait = this.jeT.goods.user_portrait;
                advertAppInfo.bFd.buttonText = this.jeT.goods.button_text;
                advertAppInfo.bFd.bFt = this.jeT.goods.button_url;
                if (this.jeT.goods.thread_pic_list != null && advertAppInfo.bFd.bFu != null) {
                    advertAppInfo.bFd.bFu.addAll(this.jeT.goods.thread_pic_list);
                }
                if (v.aa(advertAppInfo.bFd.bFu) && (mo = AdvertAppInfo.a.mo(this.jeT.goods.lego_card)) != null && advertAppInfo.bFd.bFu != null) {
                    advertAppInfo.bFd.bFu.addAll(mo);
                }
                advertAppInfo.bFd.bFv = this.jeT.goods.video_info;
                advertAppInfo.bFd.tagName = this.jeT.goods.tag_name;
                advertAppInfo.bFd.adSource = this.jeT.goods.ad_source;
                advertAppInfo.bFd.bFw = this.jeT.goods.tag_name_url;
                advertAppInfo.bFd.tagRatio = this.jeT.goods.tagRatio;
                advertAppInfo.bFd.lego_card = this.jeT.goods.lego_card;
                advertAppInfo.bFd.adCloseInfo = this.jeT.goods.adCloseInfo;
            }
            advertAppInfo.page = cpg();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.aca().ace() && this.jeT != null && this.jeT.legoCard != null && !this.jeT.legoCard.isNoPicAd()) {
            return AdvertAppInfo.bEH;
        }
        if (cpf() == 1001 || cpf() == -1001) {
            return AdvertAppInfo.bEH;
        }
        if (cpe() != null) {
            return AdvertAppInfo.bEL;
        }
        return null;
    }
}

package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.v;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String apE;
    public String apF;
    public String ebK;
    public String forumId;
    private AppData hou;
    public boolean hov = false;
    public boolean how = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.hou = new AppData(app);
    }

    public void vF(String str) {
        this.hou = new AppData(str);
    }

    public AppData bDX() {
        return this.hou;
    }

    public AdvertAppInfo.ILegoAdvert bDY() {
        if (this.hou == null) {
            return null;
        }
        return this.hou.legoCard;
    }

    public String getAdId() {
        return this.hou == null ? "" : this.hou.id;
    }

    public boolean isApp() {
        if (this.hou == null) {
            return false;
        }
        return this.hou.yd();
    }

    public int bDZ() {
        if (this.hou == null || this.hou.goods == null) {
            return -1;
        }
        return this.hou.goods.goods_style;
    }

    public int getPosition() {
        if (this.hou == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.l(this.hou.pos_name, 0);
    }

    public String bEa() {
        return this.hov ? "PB_BANNER" : "PB";
    }

    public AdvertAppInfo pu() {
        List<String> ef;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.hou != null) {
            advertAppInfo.apI = this.hou;
            advertAppInfo.apq = this.hou.id;
            advertAppInfo.apr = this.hou.name;
            advertAppInfo.aps = this.hou.url_type;
            advertAppInfo.apt = this.hou.url;
            advertAppInfo.deepUrl = this.hou.deepUrl;
            advertAppInfo.apu = this.hou.apk_url;
            advertAppInfo.apv = this.hou.apk_name;
            advertAppInfo.adPosition = this.hou.pos_name.trim();
            advertAppInfo.firstName = this.hou.first_name;
            advertAppInfo.apx = this.hou.second_name;
            advertAppInfo.cpid = this.hou.cpid;
            advertAppInfo.abtest = this.hou.abtest;
            advertAppInfo.apy = this.hou.plan_id;
            advertAppInfo.userId = this.hou.user_id;
            advertAppInfo.apz = this.hou.verify;
            advertAppInfo.price = this.hou.price;
            advertAppInfo.extensionInfo = this.hou.ext_info;
            advertAppInfo.apA = this.hou.app_time * 1000;
            advertAppInfo.legoCard = this.hou.legoCard;
            if (this.hou.goods != null) {
                advertAppInfo.apB.apN = this.hou.goods.pop_window_text;
                advertAppInfo.apB.apJ = this.hou.goods.id;
                advertAppInfo.apB.apM = this.hou.goods.thread_pic;
                advertAppInfo.apB.apO = this.hou.goods.goods_style;
                advertAppInfo.apB.apK = this.hou.goods.thread_title;
                advertAppInfo.apB.apL = this.hou.goods.thread_content;
                advertAppInfo.apB.userName = this.hou.goods.user_name;
                advertAppInfo.apB.userPortrait = this.hou.goods.user_portrait;
                advertAppInfo.apB.buttonText = this.hou.goods.button_text;
                advertAppInfo.apB.apR = this.hou.goods.button_url;
                if (this.hou.goods.thread_pic_list != null && advertAppInfo.apB.apS != null) {
                    advertAppInfo.apB.apS.addAll(this.hou.goods.thread_pic_list);
                }
                if (v.I(advertAppInfo.apB.apS) && (ef = advertAppInfo.apB.ef(this.hou.goods.lego_card)) != null && advertAppInfo.apB.apS != null) {
                    advertAppInfo.apB.apS.addAll(ef);
                }
                advertAppInfo.apB.apT = this.hou.goods.video_info;
                advertAppInfo.apB.tagName = this.hou.goods.tag_name;
                advertAppInfo.apB.adSource = this.hou.goods.ad_source;
                advertAppInfo.apB.apU = this.hou.goods.tag_name_url;
                advertAppInfo.apB.tagRatio = this.hou.goods.tagRatio;
                advertAppInfo.apB.lego_card = this.hou.goods.lego_card;
                advertAppInfo.apB.adCloseInfo = this.hou.goods.adCloseInfo;
            }
            advertAppInfo.page = bEa();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.i.xE().xI() && this.hou != null && this.hou.legoCard != null && !this.hou.legoCard.isNoPicAd()) {
            return AdvertAppInfo.apd;
        }
        if (bDZ() == 1001 || bDZ() == -1001) {
            return AdvertAppInfo.apd;
        }
        if (bDY() != null) {
            return AdvertAppInfo.aph;
        }
        return null;
    }
}

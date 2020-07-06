package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.w;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class n extends PostData {
    public String dGX;
    public String dGY;
    public String forumId;
    public String hTf;
    public boolean kny;
    private AppData lFI;
    public boolean lFJ = false;
    public boolean lFK = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.lFI = new AppData(app);
    }

    public void Ne(String str) {
        this.lFI = new AppData(str);
    }

    public AppData dhN() {
        return this.lFI;
    }

    public AdvertAppInfo.ILegoAdvert dhO() {
        if (this.lFI == null) {
            return null;
        }
        return this.lFI.legoCard;
    }

    public String getAdId() {
        return this.lFI == null ? "" : this.lFI.id;
    }

    public boolean isValidate() {
        return this.lFI != null && this.lFI.aQi() == 0;
    }

    public boolean isApp() {
        if (this.lFI == null) {
            return false;
        }
        return this.lFI.aQj();
    }

    public int dhP() {
        if (this.lFI == null || this.lFI.goods == null) {
            return -1;
        }
        return this.lFI.goods.goods_style;
    }

    public int getPosition() {
        if (this.lFI == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.lFI.pos_name, 0);
    }

    public String dhQ() {
        if (this.lFJ) {
            return "PB_BANNER";
        }
        if (this.kny) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo pL() {
        List<String> vD;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.lFI != null) {
            advertAppInfo.dHb = this.lFI;
            advertAppInfo.dGL = this.lFI.id;
            advertAppInfo.dGM = this.lFI.name;
            advertAppInfo.YN = this.lFI.url_type;
            advertAppInfo.dGN = this.lFI.url;
            advertAppInfo.deepUrl = this.lFI.deepUrl;
            advertAppInfo.apkUrl = this.lFI.apk_url;
            advertAppInfo.dGO = this.lFI.apk_name;
            advertAppInfo.adPosition = this.lFI.pos_name.trim();
            advertAppInfo.bXR = this.lFI.first_name;
            advertAppInfo.dGQ = this.lFI.second_name;
            advertAppInfo.cpid = this.lFI.cpid;
            advertAppInfo.abtest = this.lFI.abtest;
            advertAppInfo.dGR = this.lFI.plan_id;
            advertAppInfo.userId = this.lFI.user_id;
            advertAppInfo.dGS = this.lFI.verify;
            advertAppInfo.price = this.lFI.price;
            advertAppInfo.extensionInfo = this.lFI.ext_info;
            advertAppInfo.dGT = this.lFI.app_time * 1000;
            advertAppInfo.legoCard = this.lFI.legoCard;
            if (this.lFI.goods != null) {
                advertAppInfo.dGU.dHg = this.lFI.goods.pop_window_text;
                advertAppInfo.dGU.dHc = this.lFI.goods.id;
                advertAppInfo.dGU.dHf = this.lFI.goods.thread_pic;
                advertAppInfo.dGU.dHh = this.lFI.goods.goods_style;
                advertAppInfo.dGU.dHd = this.lFI.goods.thread_title;
                advertAppInfo.dGU.dHe = this.lFI.goods.thread_content;
                advertAppInfo.dGU.userName = this.lFI.goods.user_name;
                advertAppInfo.dGU.userPortrait = this.lFI.goods.user_portrait;
                advertAppInfo.dGU.buttonText = this.lFI.goods.button_text;
                advertAppInfo.dGU.dHk = this.lFI.goods.button_url;
                if (this.lFI.goods.thread_pic_list != null && advertAppInfo.dGU.dHl != null) {
                    advertAppInfo.dGU.dHl.addAll(this.lFI.goods.thread_pic_list);
                }
                if (w.isEmpty(advertAppInfo.dGU.dHl) && (vD = AdvertAppInfo.a.vD(this.lFI.goods.lego_card)) != null && advertAppInfo.dGU.dHl != null) {
                    advertAppInfo.dGU.dHl.addAll(vD);
                }
                advertAppInfo.dGU.dHm = this.lFI.goods.video_info;
                advertAppInfo.dGU.tagName = this.lFI.goods.tag_name;
                advertAppInfo.dGU.adSource = this.lFI.goods.ad_source;
                advertAppInfo.dGU.dHn = this.lFI.goods.tag_name_url;
                advertAppInfo.dGU.tagRatio = this.lFI.goods.tagRatio;
                advertAppInfo.dGU.lego_card = this.lFI.goods.lego_card;
                advertAppInfo.dGU.adCloseInfo = this.lFI.goods.adCloseInfo;
            }
            advertAppInfo.page = dhQ();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.aPA().isShowImages() && this.lFI != null && this.lFI.legoCard != null && !this.lFI.legoCard.isNoPicAd()) {
            return AdvertAppInfo.dGz;
        }
        if (dhP() == 1001 || dhP() == -1001) {
            return AdvertAppInfo.dGz;
        }
        if (dhO() != null) {
            return AdvertAppInfo.dGD;
        }
        return null;
    }
}

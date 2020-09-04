package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.App;
/* loaded from: classes.dex */
public class n extends PostData {
    public String dWv;
    public String dWw;
    public String forumId;
    public String inv;
    public boolean kMj;
    private AppData meY;
    public boolean meZ = false;
    public boolean mfa = false;
    public int pageNumber;
    public long threadId;

    public void d(App app) {
        this.meY = new AppData(app);
    }

    public void QM(String str) {
        this.meY = new AppData(str);
    }

    public AppData dwy() {
        return this.meY;
    }

    public AdvertAppInfo.ILegoAdvert dwz() {
        if (this.meY == null) {
            return null;
        }
        return this.meY.legoCard;
    }

    public String getAdId() {
        return this.meY == null ? "" : this.meY.id;
    }

    public boolean isValidate() {
        return this.meY != null && this.meY.bcv() == 0;
    }

    public boolean isApp() {
        if (this.meY == null) {
            return false;
        }
        return this.meY.bcw();
    }

    public int dwA() {
        if (this.meY == null || this.meY.goods == null) {
            return -1;
        }
        return this.meY.goods.goods_style;
    }

    public int getPosition() {
        if (this.meY == null) {
            return 0;
        }
        return com.baidu.adp.lib.f.b.toInt(this.meY.pos_name, 0);
    }

    public String dwB() {
        if (this.meZ) {
            return "PB_BANNER";
        }
        if (this.kMj) {
            return "VIDEO_PB";
        }
        return "PB";
    }

    public AdvertAppInfo rl() {
        List<String> yZ;
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.meY != null) {
            advertAppInfo.dWz = this.meY;
            advertAppInfo.dWj = this.meY.id;
            advertAppInfo.dWk = this.meY.name;
            advertAppInfo.Zl = this.meY.url_type;
            advertAppInfo.dWl = this.meY.url;
            advertAppInfo.deepUrl = this.meY.deepUrl;
            advertAppInfo.apkUrl = this.meY.apk_url;
            advertAppInfo.dWm = this.meY.apk_name;
            advertAppInfo.adPosition = this.meY.pos_name.trim();
            advertAppInfo.cey = this.meY.first_name;
            advertAppInfo.dWo = this.meY.second_name;
            advertAppInfo.cpid = this.meY.cpid;
            advertAppInfo.abtest = this.meY.abtest;
            advertAppInfo.dWp = this.meY.plan_id;
            advertAppInfo.userId = this.meY.user_id;
            advertAppInfo.dWq = this.meY.verify;
            advertAppInfo.price = this.meY.price;
            advertAppInfo.extensionInfo = this.meY.ext_info;
            advertAppInfo.dWr = this.meY.app_time * 1000;
            advertAppInfo.legoCard = this.meY.legoCard;
            if (this.meY.goods != null) {
                advertAppInfo.dWs.dWE = this.meY.goods.pop_window_text;
                advertAppInfo.dWs.dWA = this.meY.goods.id;
                advertAppInfo.dWs.dWD = this.meY.goods.thread_pic;
                advertAppInfo.dWs.dWF = this.meY.goods.goods_style;
                advertAppInfo.dWs.dWB = this.meY.goods.thread_title;
                advertAppInfo.dWs.dWC = this.meY.goods.thread_content;
                advertAppInfo.dWs.userName = this.meY.goods.user_name;
                advertAppInfo.dWs.userPortrait = this.meY.goods.user_portrait;
                advertAppInfo.dWs.buttonText = this.meY.goods.button_text;
                advertAppInfo.dWs.dWI = this.meY.goods.button_url;
                if (this.meY.goods.thread_pic_list != null && advertAppInfo.dWs.dWJ != null) {
                    advertAppInfo.dWs.dWJ.addAll(this.meY.goods.thread_pic_list);
                }
                if (y.isEmpty(advertAppInfo.dWs.dWJ) && (yZ = AdvertAppInfo.a.yZ(this.meY.goods.lego_card)) != null && advertAppInfo.dWs.dWJ != null) {
                    advertAppInfo.dWs.dWJ.addAll(yZ);
                }
                advertAppInfo.dWs.dWK = this.meY.goods.video_info;
                advertAppInfo.dWs.tagName = this.meY.goods.tag_name;
                advertAppInfo.dWs.adSource = this.meY.goods.ad_source;
                advertAppInfo.dWs.dWL = this.meY.goods.tag_name_url;
                advertAppInfo.dWs.tagRatio = this.meY.goods.tagRatio;
                advertAppInfo.dWs.lego_card = this.meY.goods.lego_card;
                advertAppInfo.dWs.adCloseInfo = this.meY.goods.adCloseInfo;
            }
            advertAppInfo.page = dwB();
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.k.bbM().isShowImages() && this.meY != null && this.meY.legoCard != null && !this.meY.legoCard.isNoPicAd()) {
            return AdvertAppInfo.dVX;
        }
        if (dwA() == 1001 || dwA() == -1001) {
            return AdvertAppInfo.dVX;
        }
        if (dwz() != null) {
            return AdvertAppInfo.dWb;
        }
        return null;
    }
}

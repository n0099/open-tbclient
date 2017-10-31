package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String Uu;
    public String Uv;
    public String cIq;
    public String forumId;
    private AppData gph;
    public boolean gpi = false;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.gph = new AppData(app);
    }

    public AppData buj() {
        return this.gph;
    }

    public AdvertAppInfo.ILegoAdvert buk() {
        if (this.gph == null) {
            return null;
        }
        return this.gph.legoCard;
    }

    public String getAdId() {
        return this.gph == null ? "" : this.gph.id;
    }

    public boolean isApp() {
        if (this.gph == null) {
            return false;
        }
        return this.gph.ps();
    }

    public int bul() {
        if (this.gph == null || this.gph.goods == null) {
            return -1;
        }
        return this.gph.goods.goods_style;
    }

    public int getPosition() {
        if (this.gph == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.gph.pos_name, 0);
    }

    public AdvertAppInfo bum() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gph != null) {
            advertAppInfo.Uy = this.gph;
            advertAppInfo.Ug = this.gph.id;
            advertAppInfo.Uh = this.gph.name;
            advertAppInfo.Ui = this.gph.url_type;
            advertAppInfo.Uj = this.gph.url;
            advertAppInfo.deepUrl = this.gph.deepUrl;
            advertAppInfo.Uk = this.gph.apk_url;
            advertAppInfo.Ul = this.gph.apk_name;
            advertAppInfo.adPosition = this.gph.pos_name.trim();
            advertAppInfo.Un = this.gph.first_name;
            advertAppInfo.Uo = this.gph.second_name;
            advertAppInfo.cpid = this.gph.cpid;
            advertAppInfo.abtest = this.gph.abtest;
            advertAppInfo.Up = this.gph.plan_id;
            advertAppInfo.userId = this.gph.user_id;
            advertAppInfo.Uq = this.gph.verify;
            advertAppInfo.price = this.gph.price;
            advertAppInfo.extensionInfo = this.gph.ext_info;
            advertAppInfo.Ur = this.gph.app_time * 1000;
            advertAppInfo.legoCard = this.gph.legoCard;
            if (this.gph.goods != null) {
                advertAppInfo.Us.UE = this.gph.goods.pop_window_text;
                advertAppInfo.Us.Uz = this.gph.goods.id;
                advertAppInfo.Us.UD = this.gph.goods.thread_pic;
                advertAppInfo.Us.UF = this.gph.goods.goods_style;
                advertAppInfo.Us.UB = this.gph.goods.thread_title;
                advertAppInfo.Us.UC = this.gph.goods.thread_content;
                advertAppInfo.Us.userName = this.gph.goods.user_name;
                advertAppInfo.Us.userPortrait = this.gph.goods.user_portrait;
                advertAppInfo.Us.buttonText = this.gph.goods.button_text;
                advertAppInfo.Us.UI = this.gph.goods.button_url;
                if (this.gph.goods.thread_pic_list != null) {
                    advertAppInfo.Us.UJ = new ArrayList();
                    advertAppInfo.Us.UJ.addAll(this.gph.goods.thread_pic_list);
                }
                advertAppInfo.Us.UK = this.gph.goods.video_info;
                advertAppInfo.Us.tagName = this.gph.goods.tag_name;
                advertAppInfo.Us.adSource = this.gph.goods.ad_source;
                advertAppInfo.Us.UL = this.gph.goods.tag_name_url;
                advertAppInfo.Us.tagRatio = this.gph.goods.tagRatio;
                advertAppInfo.Us.lego_card = this.gph.goods.lego_card;
            }
            advertAppInfo.TL = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.h.oT().oZ() && this.gph != null && this.gph.legoCard != null && !this.gph.legoCard.isNoPicAd()) {
            return AdvertAppInfo.TX;
        }
        if (bul() == 1001 || bul() == -1001) {
            return AdvertAppInfo.TX;
        }
        if (buk() != null) {
            return AdvertAppInfo.Ue;
        }
        return null;
    }
}

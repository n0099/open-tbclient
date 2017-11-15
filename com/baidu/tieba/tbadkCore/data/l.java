package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String Uu;
    public String Uv;
    public String cIJ;
    public String forumId;
    private AppData gqk;
    public boolean gql = false;
    public int pageNumber;
    public long threadId;

    public void c(App app) {
        this.gqk = new AppData(app);
    }

    public AppData buv() {
        return this.gqk;
    }

    public AdvertAppInfo.ILegoAdvert buw() {
        if (this.gqk == null) {
            return null;
        }
        return this.gqk.legoCard;
    }

    public String getAdId() {
        return this.gqk == null ? "" : this.gqk.id;
    }

    public boolean isApp() {
        if (this.gqk == null) {
            return false;
        }
        return this.gqk.ps();
    }

    public int bux() {
        if (this.gqk == null || this.gqk.goods == null) {
            return -1;
        }
        return this.gqk.goods.goods_style;
    }

    public int getPosition() {
        if (this.gqk == null) {
            return 0;
        }
        return com.baidu.adp.lib.g.b.g(this.gqk.pos_name, 0);
    }

    public AdvertAppInfo buy() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gqk != null) {
            advertAppInfo.Uy = this.gqk;
            advertAppInfo.Ug = this.gqk.id;
            advertAppInfo.Uh = this.gqk.name;
            advertAppInfo.Ui = this.gqk.url_type;
            advertAppInfo.Uj = this.gqk.url;
            advertAppInfo.deepUrl = this.gqk.deepUrl;
            advertAppInfo.Uk = this.gqk.apk_url;
            advertAppInfo.Ul = this.gqk.apk_name;
            advertAppInfo.adPosition = this.gqk.pos_name.trim();
            advertAppInfo.Un = this.gqk.first_name;
            advertAppInfo.Uo = this.gqk.second_name;
            advertAppInfo.cpid = this.gqk.cpid;
            advertAppInfo.abtest = this.gqk.abtest;
            advertAppInfo.Up = this.gqk.plan_id;
            advertAppInfo.userId = this.gqk.user_id;
            advertAppInfo.Uq = this.gqk.verify;
            advertAppInfo.price = this.gqk.price;
            advertAppInfo.extensionInfo = this.gqk.ext_info;
            advertAppInfo.Ur = this.gqk.app_time * 1000;
            advertAppInfo.legoCard = this.gqk.legoCard;
            if (this.gqk.goods != null) {
                advertAppInfo.Us.UE = this.gqk.goods.pop_window_text;
                advertAppInfo.Us.Uz = this.gqk.goods.id;
                advertAppInfo.Us.UD = this.gqk.goods.thread_pic;
                advertAppInfo.Us.UF = this.gqk.goods.goods_style;
                advertAppInfo.Us.UB = this.gqk.goods.thread_title;
                advertAppInfo.Us.UC = this.gqk.goods.thread_content;
                advertAppInfo.Us.userName = this.gqk.goods.user_name;
                advertAppInfo.Us.userPortrait = this.gqk.goods.user_portrait;
                advertAppInfo.Us.buttonText = this.gqk.goods.button_text;
                advertAppInfo.Us.UI = this.gqk.goods.button_url;
                if (this.gqk.goods.thread_pic_list != null) {
                    advertAppInfo.Us.UJ = new ArrayList();
                    advertAppInfo.Us.UJ.addAll(this.gqk.goods.thread_pic_list);
                }
                advertAppInfo.Us.UK = this.gqk.goods.video_info;
                advertAppInfo.Us.tagName = this.gqk.goods.tag_name;
                advertAppInfo.Us.adSource = this.gqk.goods.ad_source;
                advertAppInfo.Us.UL = this.gqk.goods.tag_name_url;
                advertAppInfo.Us.tagRatio = this.gqk.goods.tagRatio;
                advertAppInfo.Us.lego_card = this.gqk.goods.lego_card;
            }
            advertAppInfo.TL = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (!com.baidu.tbadk.core.h.oT().oZ() && this.gqk != null && this.gqk.legoCard != null && !this.gqk.legoCard.isNoPicAd()) {
            return AdvertAppInfo.TX;
        }
        if (bux() == 1001 || bux() == -1001) {
            return AdvertAppInfo.TX;
        }
        if (buw() != null) {
            return AdvertAppInfo.Ue;
        }
        return null;
    }
}

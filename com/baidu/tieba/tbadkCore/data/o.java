package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class o extends PostData {
    public String Tg;
    public String Th;
    public String ckG;
    private AppData fMd;
    public boolean fMe = false;
    public String forumId;
    public int pageNumber;
    public long threadId;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        this.fMd = new AppData(jSONObject);
    }

    public void c(App app) {
        this.fMd = new AppData(app);
    }

    public AppData bmj() {
        return this.fMd;
    }

    public AdvertAppInfo.ILegoAdvert bmk() {
        if (this.fMd == null) {
            return null;
        }
        return this.fMd.legoCard;
    }

    public String bml() {
        return this.fMd == null ? "" : this.fMd.id;
    }

    public boolean isApp() {
        if (this.fMd == null) {
            return false;
        }
        return this.fMd.pl();
    }

    public int bmm() {
        if (this.fMd == null || this.fMd.goods == null) {
            return -1;
        }
        return this.fMd.goods.goods_style;
    }

    public int getPosition() {
        int g = this.fMd != null ? com.baidu.adp.lib.g.b.g(this.fMd.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public AdvertAppInfo bmn() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.fMd != null) {
            advertAppInfo.Tk = this.fMd;
            advertAppInfo.ST = this.fMd.id;
            advertAppInfo.SU = this.fMd.name;
            advertAppInfo.SV = this.fMd.url_type;
            advertAppInfo.SW = this.fMd.url;
            advertAppInfo.deepUrl = this.fMd.deepUrl;
            advertAppInfo.SX = this.fMd.apk_url;
            advertAppInfo.SY = this.fMd.apk_name;
            advertAppInfo.adPosition = this.fMd.pos_name.trim();
            advertAppInfo.SZ = this.fMd.first_name;
            advertAppInfo.Ta = this.fMd.second_name;
            advertAppInfo.cpid = this.fMd.cpid;
            advertAppInfo.abtest = this.fMd.abtest;
            advertAppInfo.Tb = this.fMd.plan_id;
            advertAppInfo.userId = this.fMd.user_id;
            advertAppInfo.Tc = this.fMd.verify;
            advertAppInfo.price = this.fMd.price;
            advertAppInfo.extensionInfo = this.fMd.ext_info;
            advertAppInfo.Td = this.fMd.app_time * 1000;
            advertAppInfo.legoCard = this.fMd.legoCard;
            if (this.fMd.goods != null) {
                advertAppInfo.Te.Tp = this.fMd.goods.pop_window_text;
                advertAppInfo.Te.Tl = this.fMd.goods.id;
                advertAppInfo.Te.To = this.fMd.goods.thread_pic;
                advertAppInfo.Te.Tq = this.fMd.goods.goods_style;
                advertAppInfo.Te.Tm = this.fMd.goods.thread_title;
                advertAppInfo.Te.Tn = this.fMd.goods.thread_content;
                advertAppInfo.Te.userName = this.fMd.goods.user_name;
                advertAppInfo.Te.userPortrait = this.fMd.goods.user_portrait;
                advertAppInfo.Te.buttonText = this.fMd.goods.button_text;
                advertAppInfo.Te.Tt = this.fMd.goods.button_url;
                if (this.fMd.goods.thread_pic_list != null) {
                    advertAppInfo.Te.Tu = new ArrayList();
                    advertAppInfo.Te.Tu.addAll(this.fMd.goods.thread_pic_list);
                }
                advertAppInfo.Te.Tv = this.fMd.goods.video_info;
                advertAppInfo.Te.Tw = this.fMd.goods.tag_name;
                advertAppInfo.Te.adSource = this.fMd.goods.ad_source;
                advertAppInfo.Te.Tx = this.fMd.goods.tag_name_url;
                advertAppInfo.Te.tagRatio = this.fMd.goods.tagRatio;
                advertAppInfo.Te.lego_card = this.fMd.goods.lego_card;
            }
            advertAppInfo.Sz = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        if (bmm() == 1001) {
            return AdvertAppInfo.SK;
        }
        if (bmk() != null) {
            return AdvertAppInfo.SR;
        }
        return null;
    }
}

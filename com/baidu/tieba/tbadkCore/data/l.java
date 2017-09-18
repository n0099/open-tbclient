package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String Ua;
    public String Ub;
    public String czU;
    public String forumId;
    private AppData gja;
    public boolean gjb = false;
    public int pageNumber;
    public long threadId;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        this.gja = new AppData(jSONObject);
    }

    public void c(App app) {
        this.gja = new AppData(app);
    }

    public AppData bso() {
        return this.gja;
    }

    public AdvertAppInfo.ILegoAdvert bsp() {
        if (this.gja == null) {
            return null;
        }
        return this.gja.legoCard;
    }

    public String bsq() {
        return this.gja == null ? "" : this.gja.id;
    }

    public boolean isApp() {
        if (this.gja == null) {
            return false;
        }
        return this.gja.pt();
    }

    public int bsr() {
        if (this.gja == null || this.gja.goods == null) {
            return -1;
        }
        return this.gja.goods.goods_style;
    }

    public int getPosition() {
        int g = this.gja != null ? com.baidu.adp.lib.g.b.g(this.gja.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public AdvertAppInfo bss() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gja != null) {
            advertAppInfo.Ue = this.gja;
            advertAppInfo.TL = this.gja.id;
            advertAppInfo.TM = this.gja.name;
            advertAppInfo.TO = this.gja.url_type;
            advertAppInfo.TP = this.gja.url;
            advertAppInfo.deepUrl = this.gja.deepUrl;
            advertAppInfo.TQ = this.gja.apk_url;
            advertAppInfo.TR = this.gja.apk_name;
            advertAppInfo.adPosition = this.gja.pos_name.trim();
            advertAppInfo.TT = this.gja.first_name;
            advertAppInfo.TU = this.gja.second_name;
            advertAppInfo.cpid = this.gja.cpid;
            advertAppInfo.abtest = this.gja.abtest;
            advertAppInfo.TV = this.gja.plan_id;
            advertAppInfo.userId = this.gja.user_id;
            advertAppInfo.TW = this.gja.verify;
            advertAppInfo.price = this.gja.price;
            advertAppInfo.extensionInfo = this.gja.ext_info;
            advertAppInfo.TX = this.gja.app_time * 1000;
            advertAppInfo.legoCard = this.gja.legoCard;
            if (this.gja.goods != null) {
                advertAppInfo.TY.Uj = this.gja.goods.pop_window_text;
                advertAppInfo.TY.Uf = this.gja.goods.id;
                advertAppInfo.TY.Ui = this.gja.goods.thread_pic;
                advertAppInfo.TY.Uk = this.gja.goods.goods_style;
                advertAppInfo.TY.Ug = this.gja.goods.thread_title;
                advertAppInfo.TY.Uh = this.gja.goods.thread_content;
                advertAppInfo.TY.userName = this.gja.goods.user_name;
                advertAppInfo.TY.userPortrait = this.gja.goods.user_portrait;
                advertAppInfo.TY.buttonText = this.gja.goods.button_text;
                advertAppInfo.TY.Un = this.gja.goods.button_url;
                if (this.gja.goods.thread_pic_list != null) {
                    advertAppInfo.TY.Uo = new ArrayList();
                    advertAppInfo.TY.Uo.addAll(this.gja.goods.thread_pic_list);
                }
                advertAppInfo.TY.Up = this.gja.goods.video_info;
                advertAppInfo.TY.tagName = this.gja.goods.tag_name;
                advertAppInfo.TY.adSource = this.gja.goods.ad_source;
                advertAppInfo.TY.Uq = this.gja.goods.tag_name_url;
                advertAppInfo.TY.tagRatio = this.gja.goods.tagRatio;
                advertAppInfo.TY.lego_card = this.gja.goods.lego_card;
            }
            advertAppInfo.Tr = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (bsr() == 1001 || bsr() == -1001) {
            return AdvertAppInfo.TC;
        }
        if (bsp() != null) {
            return AdvertAppInfo.TJ;
        }
        return null;
    }
}

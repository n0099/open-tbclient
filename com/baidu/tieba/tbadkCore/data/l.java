package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String UY;
    public String UZ;
    public String csz;
    public String forumId;
    private AppData gjE;
    public boolean gjF = false;
    public int pageNumber;
    public long threadId;

    @Override // com.baidu.tieba.tbadkCore.data.PostData
    public void parserJson(JSONObject jSONObject) {
        this.gjE = new AppData(jSONObject);
    }

    public void c(App app) {
        this.gjE = new AppData(app);
    }

    public AppData bsO() {
        return this.gjE;
    }

    public AdvertAppInfo.ILegoAdvert bsP() {
        if (this.gjE == null) {
            return null;
        }
        return this.gjE.legoCard;
    }

    public String bsQ() {
        return this.gjE == null ? "" : this.gjE.id;
    }

    public boolean isApp() {
        if (this.gjE == null) {
            return false;
        }
        return this.gjE.pz();
    }

    public int bsR() {
        if (this.gjE == null || this.gjE.goods == null) {
            return -1;
        }
        return this.gjE.goods.goods_style;
    }

    public int getPosition() {
        int g = this.gjE != null ? com.baidu.adp.lib.g.b.g(this.gjE.pos_name, 0) : 0;
        if (g < 2 || g > 30) {
            return 7;
        }
        return g;
    }

    public AdvertAppInfo bsS() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gjE != null) {
            advertAppInfo.Vc = this.gjE;
            advertAppInfo.UK = this.gjE.id;
            advertAppInfo.UL = this.gjE.name;
            advertAppInfo.UM = this.gjE.url_type;
            advertAppInfo.UN = this.gjE.url;
            advertAppInfo.deepUrl = this.gjE.deepUrl;
            advertAppInfo.UO = this.gjE.apk_url;
            advertAppInfo.UQ = this.gjE.apk_name;
            advertAppInfo.adPosition = this.gjE.pos_name.trim();
            advertAppInfo.UR = this.gjE.first_name;
            advertAppInfo.US = this.gjE.second_name;
            advertAppInfo.cpid = this.gjE.cpid;
            advertAppInfo.abtest = this.gjE.abtest;
            advertAppInfo.UT = this.gjE.plan_id;
            advertAppInfo.userId = this.gjE.user_id;
            advertAppInfo.UU = this.gjE.verify;
            advertAppInfo.price = this.gjE.price;
            advertAppInfo.extensionInfo = this.gjE.ext_info;
            advertAppInfo.UV = this.gjE.app_time * 1000;
            advertAppInfo.legoCard = this.gjE.legoCard;
            if (this.gjE.goods != null) {
                advertAppInfo.UW.Vh = this.gjE.goods.pop_window_text;
                advertAppInfo.UW.Vd = this.gjE.goods.id;
                advertAppInfo.UW.Vg = this.gjE.goods.thread_pic;
                advertAppInfo.UW.Vi = this.gjE.goods.goods_style;
                advertAppInfo.UW.Ve = this.gjE.goods.thread_title;
                advertAppInfo.UW.Vf = this.gjE.goods.thread_content;
                advertAppInfo.UW.userName = this.gjE.goods.user_name;
                advertAppInfo.UW.userPortrait = this.gjE.goods.user_portrait;
                advertAppInfo.UW.buttonText = this.gjE.goods.button_text;
                advertAppInfo.UW.Vl = this.gjE.goods.button_url;
                if (this.gjE.goods.thread_pic_list != null) {
                    advertAppInfo.UW.Vm = new ArrayList();
                    advertAppInfo.UW.Vm.addAll(this.gjE.goods.thread_pic_list);
                }
                advertAppInfo.UW.Vn = this.gjE.goods.video_info;
                advertAppInfo.UW.Vo = this.gjE.goods.tag_name;
                advertAppInfo.UW.adSource = this.gjE.goods.ad_source;
                advertAppInfo.UW.Vp = this.gjE.goods.tag_name_url;
                advertAppInfo.UW.tagRatio = this.gjE.goods.tagRatio;
                advertAppInfo.UW.lego_card = this.gjE.goods.lego_card;
            }
            advertAppInfo.Up = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (bsR() == 1001 || bsR() == -1001) {
            return AdvertAppInfo.UB;
        }
        if (bsP() != null) {
            return AdvertAppInfo.UI;
        }
        return null;
    }
}

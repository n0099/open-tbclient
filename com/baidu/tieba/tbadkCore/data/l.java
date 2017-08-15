package com.baidu.tieba.tbadkCore.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes.dex */
public class l extends PostData {
    public String UX;
    public String UY;
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

    public AppData bsV() {
        return this.gjE;
    }

    public AdvertAppInfo.ILegoAdvert bsW() {
        if (this.gjE == null) {
            return null;
        }
        return this.gjE.legoCard;
    }

    public String bsX() {
        return this.gjE == null ? "" : this.gjE.id;
    }

    public boolean isApp() {
        if (this.gjE == null) {
            return false;
        }
        return this.gjE.py();
    }

    public int bsY() {
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

    public AdvertAppInfo bsZ() {
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        if (this.gjE != null) {
            advertAppInfo.Vb = this.gjE;
            advertAppInfo.UJ = this.gjE.id;
            advertAppInfo.UK = this.gjE.name;
            advertAppInfo.UL = this.gjE.url_type;
            advertAppInfo.UM = this.gjE.url;
            advertAppInfo.deepUrl = this.gjE.deepUrl;
            advertAppInfo.UN = this.gjE.apk_url;
            advertAppInfo.UO = this.gjE.apk_name;
            advertAppInfo.adPosition = this.gjE.pos_name.trim();
            advertAppInfo.UQ = this.gjE.first_name;
            advertAppInfo.UR = this.gjE.second_name;
            advertAppInfo.cpid = this.gjE.cpid;
            advertAppInfo.abtest = this.gjE.abtest;
            advertAppInfo.US = this.gjE.plan_id;
            advertAppInfo.userId = this.gjE.user_id;
            advertAppInfo.UT = this.gjE.verify;
            advertAppInfo.price = this.gjE.price;
            advertAppInfo.extensionInfo = this.gjE.ext_info;
            advertAppInfo.UU = this.gjE.app_time * 1000;
            advertAppInfo.legoCard = this.gjE.legoCard;
            if (this.gjE.goods != null) {
                advertAppInfo.UV.Vg = this.gjE.goods.pop_window_text;
                advertAppInfo.UV.Vc = this.gjE.goods.id;
                advertAppInfo.UV.Vf = this.gjE.goods.thread_pic;
                advertAppInfo.UV.Vh = this.gjE.goods.goods_style;
                advertAppInfo.UV.Vd = this.gjE.goods.thread_title;
                advertAppInfo.UV.Ve = this.gjE.goods.thread_content;
                advertAppInfo.UV.userName = this.gjE.goods.user_name;
                advertAppInfo.UV.userPortrait = this.gjE.goods.user_portrait;
                advertAppInfo.UV.buttonText = this.gjE.goods.button_text;
                advertAppInfo.UV.Vk = this.gjE.goods.button_url;
                if (this.gjE.goods.thread_pic_list != null) {
                    advertAppInfo.UV.Vl = new ArrayList();
                    advertAppInfo.UV.Vl.addAll(this.gjE.goods.thread_pic_list);
                }
                advertAppInfo.UV.Vm = this.gjE.goods.video_info;
                advertAppInfo.UV.Vn = this.gjE.goods.tag_name;
                advertAppInfo.UV.adSource = this.gjE.goods.ad_source;
                advertAppInfo.UV.Vo = this.gjE.goods.tag_name_url;
                advertAppInfo.UV.tagRatio = this.gjE.goods.tagRatio;
                advertAppInfo.UV.lego_card = this.gjE.goods.lego_card;
            }
            advertAppInfo.Uo = "PB";
        }
        return advertAppInfo;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        if (bsY() == 1001 || bsY() == -1001) {
            return AdvertAppInfo.Uz;
        }
        if (bsW() != null) {
            return AdvertAppInfo.UH;
        }
        return null;
    }
}

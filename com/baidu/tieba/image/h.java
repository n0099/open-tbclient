package com.baidu.tieba.image;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes3.dex */
public class h {
    private LinkedList<f> gYm;
    private String fid = null;
    private int gYl = 0;
    private AdvertAppInfo gYn = null;

    public h() {
        this.gYm = null;
        this.gYm = new LinkedList<>();
    }

    public void ap(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public LinkedList<f> bIN() {
        return this.gYm;
    }

    public int getImageNum() {
        return this.gYl;
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.fid = optJSONObject.optString("id");
                }
                this.gYl = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            f fVar = new f();
                            fVar.paserJson(optJSONArray.optJSONObject(i));
                            int index = fVar.getIndex();
                            if (index >= 1 && index <= this.gYl) {
                                this.gYm.addLast(fVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            f fVar2 = new f();
                            fVar2.paserJson(optJSONArray.getJSONObject(length));
                            int index2 = fVar2.getIndex();
                            if (index2 >= 1 && index2 <= this.gYl) {
                                this.gYm.addFirst(fVar2);
                            }
                        }
                    }
                }
                bA(jSONObject);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void bA(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("app");
        if (optJSONArray != null && (optJSONObject = optJSONArray.optJSONObject(0)) != null) {
            App.Builder builder = new App.Builder();
            builder.id = optJSONObject.optString("id");
            builder.type = Integer.valueOf(optJSONObject.optInt("type", 0));
            builder.pos = Integer.valueOf(optJSONObject.optInt("pos", 0));
            builder.icon_url = optJSONObject.optString("icon_url");
            builder.icon_link = optJSONObject.optString("icon_link");
            builder.app_name = optJSONObject.optString("app_name");
            builder.app_desc = optJSONObject.optString("app_desc");
            builder.p_name = optJSONObject.optString("p_name");
            builder.p_url = optJSONObject.optString("p_url");
            builder.img_url = optJSONObject.optString(BigdayActivityConfig.IMG_URL);
            builder.app_time = Integer.valueOf(optJSONObject.optInt("app_time", 0));
            builder.web_url = optJSONObject.optString("web_url");
            builder.ad_id = optJSONObject.optString("ad_id");
            builder.id = optJSONObject.optString("id");
            builder.name = optJSONObject.optString("name");
            builder.url_type = Integer.valueOf(optJSONObject.optInt("url_type", 0));
            builder.url = optJSONObject.optString("url");
            builder.ios_url = optJSONObject.optString("ios_url");
            builder.apk_url = optJSONObject.optString("apk_url");
            builder.apk_name = optJSONObject.optString("apk_name");
            builder.pos_name = optJSONObject.optString("pos_name");
            builder.first_name = optJSONObject.optString("first_name");
            builder.second_name = optJSONObject.optString("second_name");
            builder.cpid = Integer.valueOf(optJSONObject.optInt("cpid", 0));
            builder.abtest = optJSONObject.optString(ImageViewerConfig.ABTEST);
            builder.plan_id = Integer.valueOf(optJSONObject.optInt("plan_id", 0));
            builder.user_id = optJSONObject.optString("user_id");
            builder.price = optJSONObject.optString("price");
            builder.verify = optJSONObject.optString(SmsLoginView.StatEvent.BEGIN_LOGIN);
            builder.ext_info = optJSONObject.optString("ext_info");
            builder.pos_name = optJSONObject.optString("pos_name");
            GoodsInfo bB = bB(optJSONObject);
            if (bB != null) {
                builder.goods_info = new ArrayList();
                builder.goods_info.add(bB);
            }
            builder.loc_code = optJSONObject.optString("loc_code");
            App build = builder.build(true);
            this.gYn = new AdvertAppInfo();
            this.gYn.a(build);
            this.gYn.adPosition = "c0111";
            this.gYn.bFi = this.fid;
        }
    }

    private GoodsInfo bB(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("goods_info");
        if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        GoodsInfo.Builder builder = new GoodsInfo.Builder();
        builder.id = Integer.valueOf(optJSONObject.optInt("id", 0));
        builder.user_name = optJSONObject.optString("user_name");
        builder.user_portrait = optJSONObject.optString("user_portrait");
        builder.thread_title = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
        builder.thread_pic = optJSONObject.optString("thread_pic");
        builder.pop_window_text = optJSONObject.optString("pop_window_text");
        builder.goods_style = Integer.valueOf(optJSONObject.optInt("goods_style", 0));
        builder.label_visible = Integer.valueOf(optJSONObject.optInt("label_visible", 0));
        builder.label_text = optJSONObject.optString("label_text");
        builder.rank_level = Integer.valueOf(optJSONObject.optInt("rank_level", 0));
        builder.thread_type = optJSONObject.optString("thread_type");
        builder.button_text = optJSONObject.optString("button_text");
        builder.card_desc = optJSONObject.optString("card_desc");
        builder.card_tag = optJSONObject.optString("card_tag");
        builder.tag_name = optJSONObject.optString("tag_name");
        builder.ad_source = optJSONObject.optString("ad_source");
        builder.tag_name_url = optJSONObject.optString("tag_name_url");
        builder.tag_name_wh = optJSONObject.optString("tag_name_wh");
        builder.lego_card = optJSONObject.optString("lego_card");
        return builder.build(true);
    }

    public AdvertAppInfo bIO() {
        return this.gYn;
    }
}

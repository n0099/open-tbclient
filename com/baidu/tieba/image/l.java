package com.baidu.tieba.image;

import android.content.Context;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.core.data.AntiData;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes.dex */
public class l {
    private AntiData coB;
    private LinkedList<k> coC;
    private String coz = null;
    private String fid = null;
    private int coA = 0;
    private Context mContext = null;
    private String coD = null;
    private String coE = null;
    private String tid = null;
    private com.baidu.tbadk.core.data.c coF = null;
    private int coG = 0;

    public l() {
        this.coB = null;
        this.coC = null;
        this.coC = new LinkedList<>();
        this.coB = new AntiData();
    }

    public void z(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public LinkedList<k> aiw() {
        return this.coC;
    }

    public int getImageNum() {
        return this.coA;
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                jW(jSONObject.optInt("is_new_url", 0));
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.coz = optJSONObject.optString("name");
                    this.fid = optJSONObject.optString("id");
                }
                this.coA = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            k kVar = new k(this.mContext);
                            kVar.paserJson(optJSONArray.optJSONObject(i));
                            int index = kVar.getIndex();
                            if (index >= 1 && index <= this.coA) {
                                this.coC.addLast(kVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            k kVar2 = new k(this.mContext);
                            kVar2.paserJson(optJSONArray.getJSONObject(length));
                            int index2 = kVar2.getIndex();
                            if (index2 >= 1 && index2 <= this.coA) {
                                this.coC.addFirst(kVar2);
                            }
                        }
                    }
                }
                l(jSONObject);
                JSONObject optJSONObject2 = jSONObject.optJSONArray("album_list").optJSONObject(0);
                if (optJSONObject2 != null) {
                    this.coD = optJSONObject2.optString("tid");
                    this.coE = optJSONObject2.optString("title");
                }
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void l(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray(SapiUtils.QR_LOGIN_LP_APP);
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
            builder.img_url = optJSONObject.optString("img_url");
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
            builder.abtest = optJSONObject.optString("abtest");
            builder.plan_id = Integer.valueOf(optJSONObject.optInt("plan_id", 0));
            builder.user_id = optJSONObject.optString("user_id");
            builder.price = optJSONObject.optString("price");
            builder.verify = optJSONObject.optString("verify");
            builder.ext_info = optJSONObject.optString("ext_info");
            builder.pos_name = optJSONObject.optString("pos_name");
            GoodsInfo m = m(optJSONObject);
            if (m != null) {
                builder.goods_info = new ArrayList();
                builder.goods_info.add(m);
            }
            builder.loc_code = optJSONObject.optString("loc_code");
            App build = builder.build(true);
            this.coF = new com.baidu.tbadk.core.data.c();
            this.coF.a(build);
            this.coF.Uz = "c0111";
        }
    }

    private GoodsInfo m(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("goods_info");
        if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        GoodsInfo.Builder builder = new GoodsInfo.Builder();
        builder.id = Integer.valueOf(optJSONObject.optInt("id", 0));
        builder.user_name = optJSONObject.optString("user_name");
        builder.user_portrait = optJSONObject.optString("user_portrait");
        builder.thread_title = optJSONObject.optString("thread_title");
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
        return builder.build(true);
    }

    public void jW(int i) {
        this.coG = i;
    }

    public com.baidu.tbadk.core.data.c aix() {
        return this.coF;
    }
}

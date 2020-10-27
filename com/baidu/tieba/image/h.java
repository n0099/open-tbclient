package com.baidu.tieba.image;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes21.dex */
public class h {
    public String fjU;
    private ForumData jjm;
    public MetaData krQ;
    public String krR;
    private LinkedList<f> ksb;
    private String ksd;
    private String kse;
    public int ksg;
    private int replyPrivateFlag;
    private String fid = null;
    private int ksa = 0;
    private AdvertAppInfo ksc = null;
    private LinkedList<AlaInfoData> ksf = new LinkedList<>();

    public h() {
        this.ksb = null;
        this.ksb = new LinkedList<>();
    }

    public void aS(String str, boolean z) {
        try {
            a(new JSONObject(str), Boolean.valueOf(z));
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public LinkedList<f> cUW() {
        return this.ksb;
    }

    public LinkedList<AlaInfoData> cUX() {
        return this.ksf;
    }

    public int getImageNum() {
        return this.ksa;
    }

    public String blI() {
        return this.ksd;
    }

    public String blJ() {
        return this.kse;
    }

    public int cUY() {
        return this.replyPrivateFlag;
    }

    public ForumData bya() {
        return this.jjm;
    }

    public void a(JSONObject jSONObject, Boolean bool) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("forum");
                if (optJSONObject != null) {
                    this.jjm = new ForumData();
                    this.jjm.parserJson(optJSONObject);
                    this.fid = optJSONObject.optString("id");
                    this.ksd = optJSONObject.optString("frist_class");
                    this.kse = optJSONObject.optString("second_class");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("thread");
                if (optJSONObject2 != null) {
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("author");
                    if (optJSONObject3 != null) {
                        this.krQ = new MetaData();
                        this.krQ.setUserId(optJSONObject3.optString("user_id"));
                        this.krQ.setUserName(optJSONObject3.optString("user_name"));
                        this.krQ.setName_show(optJSONObject3.optString("nickname"));
                    }
                    this.krR = optJSONObject2.optString("first_post_id");
                    this.ksg = optJSONObject2.optInt("is_multiforum_thread");
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI);
                if (optJSONObject4 != null) {
                    this.replyPrivateFlag = optJSONObject4.optInt("reply_private_flag");
                    this.fjU = optJSONObject4.optString("voice_message");
                }
                this.ksa = jSONObject.optInt("pic_amount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
                if (optJSONArray != null) {
                    if (bool.booleanValue()) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            f fVar = new f();
                            fVar.paserJson(optJSONArray.optJSONObject(i));
                            int index = fVar.getIndex();
                            if (index >= 1 && index <= this.ksa) {
                                this.ksb.addLast(fVar);
                            }
                        }
                    } else {
                        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                            f fVar2 = new f();
                            fVar2.paserJson(optJSONArray.getJSONObject(length));
                            int index2 = fVar2.getIndex();
                            if (index2 >= 1 && index2 <= this.ksa) {
                                this.ksb.addFirst(fVar2);
                            }
                        }
                    }
                }
                f(jSONObject, bool.booleanValue());
                ec(jSONObject);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    private void f(JSONObject jSONObject, boolean z) {
        JSONArray optJSONArray;
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("recom_ala_info")) != null) {
            if (z) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    AlaInfoData alaInfoData = new AlaInfoData();
                    alaInfoData.parserJson(optJSONArray.optJSONObject(i));
                    this.ksf.addLast(alaInfoData);
                }
                return;
            }
            for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                AlaInfoData alaInfoData2 = new AlaInfoData();
                alaInfoData2.parserJson(optJSONArray.optJSONObject(length));
                this.ksf.addFirst(alaInfoData2);
            }
        }
    }

    private void ec(JSONObject jSONObject) {
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
            builder.ad_id = optJSONObject.optString(LegoListActivityConfig.AD_ID);
            builder.id = optJSONObject.optString("id");
            builder.name = optJSONObject.optString("name");
            builder.url_type = Integer.valueOf(optJSONObject.optInt(ConstantData.Logo.LOGO_JUMP_URL_TPYE, 0));
            builder.url = optJSONObject.optString("url");
            builder.ios_url = optJSONObject.optString("ios_url");
            builder.apk_url = optJSONObject.optString(ConstantData.Logo.LOGO_AD_APK_URL);
            builder.apk_name = optJSONObject.optString(ConstantData.Logo.LOGO_AD_APK_PACKAGE_NAME);
            builder.pos_name = optJSONObject.optString("pos_name");
            builder.first_name = optJSONObject.optString("first_name");
            builder.second_name = optJSONObject.optString("second_name");
            builder.cpid = Integer.valueOf(optJSONObject.optInt("cpid", 0));
            builder.abtest = optJSONObject.optString("abtest");
            builder.plan_id = Integer.valueOf(optJSONObject.optInt("plan_id", 0));
            builder.user_id = optJSONObject.optString("user_id");
            builder.price = optJSONObject.optString("price");
            builder.verify = optJSONObject.optString(SmsLoginView.f.j);
            builder.ext_info = optJSONObject.optString(UgcConstant.EXT_INFO);
            builder.pos_name = optJSONObject.optString("pos_name");
            GoodsInfo ed = ed(optJSONObject);
            if (ed != null) {
                builder.goods_info = new ArrayList();
                builder.goods_info.add(ed);
            }
            builder.loc_code = optJSONObject.optString("loc_code");
            App build = builder.build(true);
            this.ksc = new AdvertAppInfo();
            this.ksc.a(build);
            this.ksc.adPosition = "c0111";
            this.ksc.etj = this.fid;
        }
    }

    private GoodsInfo ed(JSONObject jSONObject) {
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

    public AdvertAppInfo cUZ() {
        return this.ksc;
    }
}

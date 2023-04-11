package com.baidu.tieba;

import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes5.dex */
public class q28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;
    public int b;
    public LinkedList<o28> c;
    public AdvertAppInfo d;
    public String e;
    public String f;
    public LinkedList<AlaInfoData> g;
    public int h;
    public String i;
    public String j;
    public MetaData k;
    public int l;
    public int m;
    public LinkedList<b38> n;

    public q28() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 0;
        this.c = null;
        this.d = null;
        this.c = new LinkedList<>();
        this.g = new LinkedList<>();
        this.n = new LinkedList<>();
    }

    public AdvertAppInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.d;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }

    public LinkedList<AlaInfoData> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.g;
        }
        return (LinkedList) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public ForumData f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.a;
        }
        return (ForumData) invokeV.objValue;
    }

    public LinkedList<o28> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.c;
        }
        return (LinkedList) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public LinkedList<b38> i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.n;
        }
        return (LinkedList) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public final void b(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) != null) || (optJSONArray = jSONObject.optJSONArray("app")) == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return;
        }
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
        builder.verify = optJSONObject.optString(SmsLoginView.f.j);
        builder.ext_info = optJSONObject.optString("ext_info");
        builder.pos_name = optJSONObject.optString("pos_name");
        GoodsInfo c = c(optJSONObject);
        if (c != null) {
            ArrayList arrayList = new ArrayList();
            builder.goods_info = arrayList;
            arrayList.add(c);
        }
        builder.loc_code = optJSONObject.optString("loc_code");
        App build = builder.build(true);
        AdvertAppInfo advertAppInfo = new AdvertAppInfo();
        this.d = advertAppInfo;
        advertAppInfo.l(build);
        this.d.f = "c0111";
    }

    public final GoodsInfo c(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("goods_info");
            if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                return null;
            }
            GoodsInfo.Builder builder = new GoodsInfo.Builder();
            builder.id = Integer.valueOf(optJSONObject.optInt("id", 0));
            builder.user_name = optJSONObject.optString("user_name");
            builder.user_portrait = optJSONObject.optString(RecommendDetailActivityConfig.USER_PORTRAIT);
            builder.thread_title = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
            builder.thread_pic = optJSONObject.optString("thread_pic");
            builder.pop_window_text = optJSONObject.optString("pop_window_text");
            builder.goods_style = Integer.valueOf(optJSONObject.optInt("goods_style", 0));
            builder.label_visible = Integer.valueOf(optJSONObject.optInt("label_visible", 0));
            builder.label_text = optJSONObject.optString("label_text");
            builder.rank_level = Integer.valueOf(optJSONObject.optInt("rank_level", 0));
            builder.thread_type = optJSONObject.optString("thread_type");
            builder.button_text = optJSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
            builder.card_desc = optJSONObject.optString("card_desc");
            builder.card_tag = optJSONObject.optString("card_tag");
            builder.tag_name = optJSONObject.optString(PushConstants.SUB_TAGS_STATUS_NAME);
            builder.ad_source = optJSONObject.optString(TiebaStatic.Params.T_PLUS_AD_SOURCE);
            builder.tag_name_url = optJSONObject.optString("tag_name_url");
            builder.tag_name_wh = optJSONObject.optString("tag_name_wh");
            builder.lego_card = optJSONObject.optString("lego_card");
            return builder.build(true);
        }
        return (GoodsInfo) invokeL.objValue;
    }

    public final void l(JSONObject jSONObject, boolean z) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048587, this, jSONObject, z) == null) && jSONObject != null && (optJSONArray = jSONObject.optJSONArray("recom_ala_info")) != null) {
            if (z) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    AlaInfoData alaInfoData = new AlaInfoData();
                    alaInfoData.parserJson(optJSONArray.optJSONObject(i));
                    this.g.addLast(alaInfoData);
                }
                return;
            }
            for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                AlaInfoData alaInfoData2 = new AlaInfoData();
                alaInfoData2.parserJson(optJSONArray.optJSONObject(length));
                this.g.addFirst(alaInfoData2);
            }
        }
    }

    public final void m(JSONObject jSONObject) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) && jSONObject != null && (optJSONArray = jSONObject.optJSONArray("recom_live_list")) != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        b38 b38Var = new b38();
                        b38Var.h(jSONObject2);
                        this.n.add(b38Var);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public void n(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, str, z) == null) {
            try {
                o(new JSONObject(str), Boolean.valueOf(z));
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }

    public void o(JSONObject jSONObject, Boolean bool) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048590, this, jSONObject, bool) != null) || jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("forum");
            if (optJSONObject != null) {
                ForumData forumData = new ForumData();
                this.a = forumData;
                forumData.parserJson(optJSONObject);
                this.e = optJSONObject.optString("frist_class");
                this.f = optJSONObject.optString("second_class");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("thread");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
                if (optJSONObject3 != null) {
                    MetaData metaData = new MetaData();
                    this.k = metaData;
                    metaData.setUserId(optJSONObject3.optString("user_id"));
                    this.k.setUserName(optJSONObject3.optString("user_name"));
                    this.k.setName_show(optJSONObject3.optString("nickname"));
                }
                this.j = optJSONObject2.optString("first_post_id");
                this.l = optJSONObject2.optInt("is_multiforum_thread");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI);
            if (optJSONObject4 != null) {
                this.h = optJSONObject4.optInt("reply_private_flag");
                this.i = optJSONObject4.optString("voice_message");
            }
            this.m = jSONObject.optInt("show_adsense", 0);
            this.b = jSONObject.optInt("pic_amount", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
            if (optJSONArray != null) {
                if (bool.booleanValue()) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        o28 o28Var = new o28();
                        o28Var.y(optJSONArray.optJSONObject(i));
                        int i2 = o28Var.i();
                        if (i2 >= 1 && i2 <= this.b) {
                            this.c.addLast(o28Var);
                        }
                    }
                } else {
                    for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                        o28 o28Var2 = new o28();
                        o28Var2.y(optJSONArray.getJSONObject(length));
                        int i3 = o28Var2.i();
                        if (i3 >= 1 && i3 <= this.b) {
                            this.c.addFirst(o28Var2);
                        }
                    }
                }
            }
            l(jSONObject, bool.booleanValue());
            b(jSONObject);
            m(jSONObject);
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }
}

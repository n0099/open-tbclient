package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.util.CommonHelper;
import com.baidu.tbadk.core.util.UrlSchemaJumpHelper;
import com.baidu.tbadk.coreExtra.data.ABTestExtraData;
import com.baidu.tbadk.coreExtra.data.CombineDownload;
import com.baidu.tbadk.coreExtra.data.NewGodData;
import com.baidu.tbadk.coreExtra.data.VersionData;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import com.baidu.tbadk.data.HotEventData;
import com.baidu.tbadk.data.LightEmotionData;
import com.baidu.tbadk.data.UserGrowthTaskListData;
import com.baidu.tbadk.dynamicres.data.AgreeMaterial;
import com.baidu.tieba.interest.InterestPanelShowManager;
import com.baidu.tieba.interest.data.RecentClientInfo;
import com.baidu.tieba.wallet.YYLiveConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.Gson;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class y25 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y89 A;
    public NewGodData B;
    public p15 C;
    public u05 D;
    public m15 E;
    public o15 F;
    public b15 G;
    public UserGrowthTaskListData H;
    public ArrayList I;
    public VersionData a;
    public g15 b;
    public h15 c;
    public String d;
    public CombineDownload e;
    public u15 f;
    public i25 g;
    public v05 h;
    public q05 i;
    public s05 j;
    public l15 k;
    public final p05 l;
    public w15 m;
    public n15 n;
    public int o;
    public int p;
    public int q;
    public int r;
    public i15 s;
    public o05 t;
    public ABTestExtraData u;
    public JSONArray v;
    public JSONArray w;
    public JSONArray x;
    public JSONObject y;
    public YYLiveConfig z;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(y25 y25Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y25Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                v95.d().g();
            }
        }
    }

    public y25() {
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
        this.p = 0;
        this.a = new VersionData();
        this.b = new g15();
        this.c = new h15();
        this.e = new CombineDownload();
        this.f = new u15();
        this.g = new i25();
        this.s = new i15();
        this.h = new v05();
        this.i = new q05();
        this.l = new p05();
        this.t = new o05();
        this.m = new w15();
        this.n = new n15();
        this.u = new ABTestExtraData();
        this.B = new NewGodData();
        this.C = new p15();
        this.j = new s05();
        this.k = new l15();
        this.D = new u05();
        this.E = new m15();
        this.F = new o15();
        this.G = new b15();
        this.I = new ArrayList();
    }

    public final JSONObject A(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONObject(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public final JSONArray z(JSONObject jSONObject, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, jSONObject, str)) == null) {
            try {
                return jSONObject.optJSONArray(str);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return null;
            }
        }
        return (JSONArray) invokeLL.objValue;
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            try {
                C(new JSONObject(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void C(JSONObject jSONObject) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        JSONObject optJSONObject;
        JSONObject jSONObject2;
        boolean z7;
        boolean z8;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            TbSingleton.getInstance().setVoiceRoomConfig(g25.a(jSONObject));
            TbSingleton.getInstance().setUpgradePopWindowConfig(c25.j(jSONObject));
            TbSingleton.getInstance().setPushStrategyConfig(x15.e(jSONObject));
            TbSingleton.getInstance().setHomePageLuckyConfig(m45.i(jSONObject));
            this.C.a(z(jSONObject, "index_tab_info"));
            this.a.parserJson(jSONObject.optJSONObject("version"));
            this.b.b(jSONObject.optJSONObject("client"));
            CommonHelper.setIp(jSONObject.optString("client_ip", null));
            sh.g(jSONObject.optString("client_ip", null));
            this.c.f(jSONObject.optJSONObject("config"));
            this.g.e0(jSONObject.optJSONObject("wl_config"));
            TbSingleton.getInstance().setWlConfigData(this.g);
            jSONObject.optJSONObject("channel_icon_config");
            this.j.c(jSONObject.optJSONObject("floating_icon"));
            TbSingleton.getInstance().setAdFloatViewData(this.j);
            this.k.d(jSONObject.optJSONObject("home_screen_ad"));
            TbSingleton.getInstance().setHomeInsertAdData(this.k);
            this.F.c(jSONObject.optJSONObject("https_switch_strategy_info"));
            TbadkCoreApplication.getInst().setHttpsWhileData(this.F);
            l45 l45Var = new l45();
            l45Var.d(jSONObject);
            if (l45Var.c()) {
                TbSingleton.getInstance().setHomeOperateData(l45Var);
            }
            String optString = jSONObject.optString("new_god_data", "");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("new_god_data");
            boolean z9 = true;
            if (!StringUtils.isNull(optString) && optJSONObject2 != null) {
                optJSONObject2.put("portrait", mq4.s().q());
                TbSingleton.getInstance().setNewGodDataJson(optJSONObject2);
                if (optJSONObject2.optInt("need_show_toast_bubble") == 1) {
                    ux4.k().u(ux4.o("key_new_god_pop_is_show"), true);
                    ux4.k().u(ux4.o("key_new_god_tip_is_show"), true);
                }
                this.B.parserJson(optString);
            }
            this.s.c(jSONObject.optJSONObject("consume_path"));
            TbadkCoreApplication.getInst().setConsumePathData(this.s);
            this.d = jSONObject.optString("config_version");
            this.p = jSONObject.optInt("is_uninterest");
            this.q = jSONObject.optInt("first_time_motivate");
            this.r = jSONObject.optInt("needNewUserLead");
            this.e.parserJson(jSONObject.optJSONObject("combine_download"));
            this.f.a(jSONObject.optJSONObject("mainbar"));
            jSONObject.optInt(TbConfig.SYNC_ACTIVE, 0);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001141, jSONObject));
            this.o = jSONObject.optInt("faceshop_version");
            if (this.o > TbadkCoreApplication.getInst().getFaceShopVersion()) {
                TbadkCoreApplication.getInst().setTempFaceShopVersion(this.o);
                TbadkCoreApplication.getInst().setFaceShopNew(true);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("lcs_strategy");
            if (optJSONObject3 != null) {
                TbadkCoreApplication.getInst().setLcsSwitchStratgy(optJSONObject3.toString());
            }
            new w25().c(jSONObject.optJSONObject("dis_adv_config"));
            WhiteListData whiteListData = new WhiteListData();
            whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
            TbSingleton.getInstance().setHostWhiteList(whiteListData);
            w05.c(jSONObject.optJSONArray("scheme_whitelist"));
            UrlSchemaJumpHelper.setBlackList(z(jSONObject, UrlSchemaJumpHelper.KEY_APP_JUMP_BLACK_LIST));
            this.h.a(jSONObject.optJSONObject("app_entrance"));
            this.i.g(jSONObject.optJSONObject("ad_adsense"));
            a35.d(jSONObject.optJSONObject("video_report_config"));
            this.l.b(jSONObject.optJSONObject("activity_switch"));
            this.t.b(A(jSONObject, "abtest_config"));
            this.u.parseJson(A(jSONObject, "new_abtest_entra"));
            this.v = z(jSONObject, "new_abtest_config");
            this.w = z(jSONObject, UbsABTestDataManager.PREF_KEY_SWITCHS);
            z(jSONObject, "outside_callback_icon");
            this.x = jSONObject.optJSONArray("windowStrategyList");
            this.y = A(jSONObject, "bear_sdk_config");
            if (A(jSONObject, "advertisement_config") != null) {
                this.D.d(A(jSONObject, "advertisement_config"));
            }
            YYLiveConfig yYLiveConfig = new YYLiveConfig();
            this.z = yYLiveConfig;
            yYLiveConfig.parseJson(A(jSONObject, "yy_live_config"));
            y89 y89Var = new y89();
            this.A = y89Var;
            y89Var.b(z(jSONObject, "yy_live_tab"));
            this.n.c(jSONObject.optJSONObject("hot_notify_config"));
            TbSingleton.getInstance().setHotNotifyConfig(this.n);
            vq4.b().f(this.x);
            this.m.d(jSONObject.optJSONObject("profile_icon"));
            TbSingleton tbSingleton = TbSingleton.getInstance();
            if (jSONObject.optInt("recommend_userstatus", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            tbSingleton.setNewUser(z);
            ux4 k = ux4.k();
            if (jSONObject.optInt("ala_channel_white", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            k.u("key_live_forum_enter_switch", z2);
            TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
            JSONArray z10 = z(jSONObject, "offpack");
            if (z10 != null && z10.length() > 0 && (jSONObject2 = z10.getJSONObject(0)) != null) {
                md8 md8Var = new md8();
                md8Var.e(jSONObject2.optString("mod_name"));
                if (jSONObject2.optInt("upload_offline_web_cache") == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                md8Var.f(z7);
                if (jSONObject2.optInt("clear_offline_web_cache") == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                md8Var.d(z8);
                if (!TextUtils.isEmpty(md8Var.a())) {
                    TbSingleton.getInstance().setUploadAndClearModule(md8Var);
                }
            }
            String optString2 = jSONObject.optString("proxy_ip");
            String optString3 = jSONObject.optString("proxy_port");
            TbadkCoreApplication.getInst().setProxyIp(optString2);
            TbadkCoreApplication.getInst().setProxyPort(optString3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ad_sdk_priority", jSONObject.optString("ad_sdk_priority", null));
            jSONObject3.put("12_20_0_screen_fill_Ad_experiment", jSONObject.optString("12_20_0_screen_fill_Ad_experiment", null));
            jSONObject3.put("ad_origin_config_switch", jSONObject.optString("ad_origin_config_switch", null));
            jSONObject3.put("bear_sid_type", jSONObject.optString("bear_sid_type", null));
            jSONObject3.put("screen_fill_data_result", jSONObject.optJSONObject("screen_fill_data_result"));
            int optInt = jSONObject.optInt("ad_num_competition_frs", 5);
            int optInt2 = jSONObject.optInt("ad_num_competition_personalize", 2);
            ux4.k().w("key_mix_frs_ad_count", optInt);
            ux4.k().w("key_mix_home_page_ad_count", optInt2);
            MessageManager.getInstance().runTask(2016552, null, jSONObject3);
            TbSingleton tbSingleton2 = TbSingleton.getInstance();
            if (jSONObject.optInt("is_yy_user", 1) == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            tbSingleton2.setSyncYYSwitch(z3);
            JSONObject optJSONObject4 = jSONObject.optJSONObject(LowFlowsActivityConfig.LF_USER_INFO);
            if (optJSONObject4 != null) {
                String optString4 = optJSONObject4.optString(LowFlowsActivityConfig.LF_USER);
                TbSingleton.getInstance().setLFUser(optString4);
                if (!StringUtils.isNull(optString4) && "2".equals(optString4)) {
                    TbSingleton.getInstance().setLFUserTaskId(optJSONObject4.optString(LowFlowsActivityConfig.LF_USER_TASKID));
                    TbSingleton.getInstance().setBannerText(optJSONObject4.optString(LowFlowsActivityConfig.LF_BANNER_TEXT));
                }
            }
            ux4.k().w("key_personalized_rec_switch", jSONObject.optInt("personalized_rec_switch"));
            JSONObject A = A(jSONObject, "homepage_interest_config");
            if (A != null && this.E != null) {
                this.E.e(A);
                TbSingleton.getInstance().setHomepageInterestConfig(this.E);
            }
            wf7 wf7Var = new wf7();
            JSONObject optJSONObject5 = jSONObject.optJSONObject("recent_client_info");
            if (optJSONObject5 != null) {
                wf7Var.d(RecentClientInfo.parseJson(optJSONObject5));
            }
            JSONObject optJSONObject6 = jSONObject.optJSONObject("new_user_interest_board_config");
            if (optJSONObject6 != null) {
                wf7Var.c(uf7.e(optJSONObject6));
            }
            InterestPanelShowManager.a().c(wf7Var);
            JSONObject optJSONObject7 = jSONObject.optJSONObject("bottom_bubble_config");
            if (optJSONObject7 != null) {
                v95.d().h(optJSONObject7);
                hh.a().post(new a(this));
            }
            ux4.k().w("key_work_video_guide_pop", jSONObject.optInt("videoup_guide_pop", -1));
            TbSingleton.getInstance().setVideoEventsConfig(f25.d(jSONObject));
            ux4.k().y("key_sync_extra_field", jSONObject.optString("extra"));
            int optInt3 = jSONObject.optInt("icon_task_flag");
            TbSingleton tbSingleton3 = TbSingleton.getInstance();
            if (optInt3 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            tbSingleton3.showStampMissionDialog = z4;
            int optInt4 = jSONObject.optInt("afSearch_tab", 0);
            rg8 d = rg8.d();
            if (optInt4 == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            d.h(z5);
            int optInt5 = jSONObject.optInt("is_need_remind_live_rooms");
            TbSingleton tbSingleton4 = TbSingleton.getInstance();
            if (optInt5 == 1) {
                z6 = true;
            } else {
                z6 = false;
            }
            tbSingleton4.setIsNeedRemindLiveRoom(z6);
            JSONObject optJSONObject8 = jSONObject.optJSONObject("search_guide");
            xu7.b().a();
            if (optJSONObject8 != null && (optJSONObject = optJSONObject8.optJSONObject("pb")) != null) {
                if (optJSONObject.optInt("is_show", 0) != 1) {
                    z9 = false;
                }
                int optInt6 = optJSONObject.optInt("pos", -1);
                zv7 zv7Var = new zv7();
                zv7Var.a = z9;
                zv7Var.b = optInt6;
                xu7.b().d(zv7Var);
            }
            k55.g().a(AgreeMaterial.B(jSONObject.optJSONObject("agree_material")));
            JSONObject optJSONObject9 = jSONObject.optJSONObject("live_activity_guide");
            if (optJSONObject9 != null) {
                o45 o45Var = new o45();
                o45Var.f(optJSONObject9);
                TbSingleton.getInstance().mLiveActivityGuide = o45Var;
            } else {
                TbSingleton.getInstance().mLiveActivityGuide = null;
            }
            this.G.h(jSONObject.optJSONObject("bear_sid_config"));
            D();
            TbSingleton.getInstance().setColourHeaderConfig(i45.r(jSONObject));
            fp5.e().k(jSONObject.optJSONObject("member_guide"));
            fp5.e().j(jSONObject.optJSONObject("close_ad_tips"));
            JSONArray optJSONArray = jSONObject.optJSONArray("interact_memes");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    LightEmotionData lightEmotionData = new LightEmotionData();
                    lightEmotionData.parseJson(optJSONArray.getJSONObject(i));
                    this.I.add(lightEmotionData);
                }
                TbSingleton.getInstance().setLightEmotionInfo(this.I);
            }
            UserGrowthTaskListData userGrowthTaskListData = (UserGrowthTaskListData) new Gson().fromJson(jSONObject.optString("user_growth_task_list"), (Class<Object>) UserGrowthTaskListData.class);
            TbSingleton.getInstance().setUserGrowthTaskListData(userGrowthTaskListData);
            HotEventData.getInstance().parsJson(jSONObject.optJSONObject("thread_recommend_info"));
            this.H = userGrowthTaskListData;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.G != null) {
            ux4.k().y("key_server_splash_bear_sid", this.G.f());
            ux4.k().y("key_server_homepage_bear_sid", this.G.b());
            ux4.k().y("key_server_frs_bear_sid", this.G.a());
            ux4.k().y("key_server_pb_banner_bear_sid", this.G.c());
            ux4.k().y("key_server_pb_comment_bear_sid", this.G.d());
            ux4.k().y("key_server_picpage_bear_sid", this.G.e());
            ux4.k().y("key_server_videoflow_bear_sid", this.G.g());
        }
    }

    public o05 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.t;
        }
        return (o05) invokeV.objValue;
    }

    public ABTestExtraData b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.u;
        }
        return (ABTestExtraData) invokeV.objValue;
    }

    public JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.v;
        }
        return (JSONArray) invokeV.objValue;
    }

    public p05 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.l;
        }
        return (p05) invokeV.objValue;
    }

    public q05 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return (q05) invokeV.objValue;
    }

    public s05 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.j;
        }
        return (s05) invokeV.objValue;
    }

    public u05 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.D;
        }
        return (u05) invokeV.objValue;
    }

    public v05 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return (v05) invokeV.objValue;
    }

    public g15 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (g15) invokeV.objValue;
    }

    public CombineDownload j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.e;
        }
        return (CombineDownload) invokeV.objValue;
    }

    public h15 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.c;
        }
        return (h15) invokeV.objValue;
    }

    public JSONObject l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.y;
        }
        return (JSONObject) invokeV.objValue;
    }

    public n15 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.n;
        }
        return (n15) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.q == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.r;
        }
        return invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public NewGodData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.B;
        }
        return (NewGodData) invokeV.objValue;
    }

    public w15 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.m;
        }
        return (w15) invokeV.objValue;
    }

    public JSONArray s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.w;
        }
        return (JSONArray) invokeV.objValue;
    }

    public UserGrowthTaskListData t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.H;
        }
        return (UserGrowthTaskListData) invokeV.objValue;
    }

    public VersionData u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.a;
        }
        return (VersionData) invokeV.objValue;
    }

    public i25 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.g;
        }
        return (i25) invokeV.objValue;
    }

    public YYLiveConfig w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.z;
        }
        return (YYLiveConfig) invokeV.objValue;
    }

    public y89 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.A;
        }
        return (y89) invokeV.objValue;
    }

    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }
}

package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.log.DefaultLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.tbadk.BdToken.BdTokenController;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestDataManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.dialog.yun.YunDialogDataManager;
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
/* loaded from: classes8.dex */
public class yf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public x0b A;
    public NewGodData B;
    public ee5 C;
    public id5 D;
    public de5 E;
    public pd5 F;
    public UserGrowthTaskListData G;
    public ArrayList<LightEmotionData> H;
    public VersionData a;
    public vd5 b;
    public wd5 c;
    public String d;
    public CombineDownload e;
    public je5 f;
    public ze5 g;
    public jd5 h;
    public ed5 i;
    public gd5 j;
    public be5 k;
    public final dd5 l;
    public ne5 m;
    public ce5 n;
    public int o;
    public int p;
    public int q;
    public int r;
    public xd5 s;
    public cd5 t;
    public ABTestExtraData u;
    public JSONArray v;
    public JSONArray w;
    public JSONArray x;
    public JSONObject y;
    public YYLiveConfig z;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(yf5 yf5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf5Var};
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
                qo5.f().j();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ JSONArray a;

        public b(yf5 yf5Var, JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yf5Var, jSONArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h29 defaultLog = DefaultLog.getInstance();
                defaultLog.c("WebPreheat", "sync返回预热H5:" + this.a);
                b06.e(this.a);
            }
        }
    }

    public yf5() {
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
        this.b = new vd5();
        this.c = new wd5();
        this.e = new CombineDownload();
        this.f = new je5();
        this.g = new ze5();
        this.s = new xd5();
        this.h = new jd5();
        this.i = new ed5();
        this.l = new dd5();
        this.t = new cd5();
        this.m = new ne5();
        this.n = new ce5();
        this.u = new ABTestExtraData();
        this.B = new NewGodData();
        this.C = new ee5();
        this.j = new gd5();
        this.k = new be5();
        this.D = new id5();
        this.E = new de5();
        this.F = new pd5();
        this.H = new ArrayList<>();
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
                h29 a2 = yk.a();
                a2.b(Config.DEVICE_PART, "sync exception1: " + e.getMessage());
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
        JSONObject jSONObject2;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        try {
            TbSingleton.getInstance().setSyncJson(jSONObject);
            YunDialogDataManager.j().o(jSONObject.optJSONArray("h5_pop_ups"));
            JSONObject optJSONObject = jSONObject.optJSONObject("h5_pop_ups_config");
            if (optJSONObject != null) {
                YunDialogDataManager.j().p(optJSONObject);
            }
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            if (currentActivity != null) {
                m65.p(currentActivity, l65.c);
            }
            BdTokenController.J().R(jSONObject);
            TbSingleton.getInstance().setVoiceRoomConfig(xe5.a(jSONObject));
            TbSingleton.getInstance().setUpgradePopWindowConfig(te5.j(jSONObject));
            TbSingleton.getInstance().setPushStrategyConfig(oe5.e(jSONObject));
            TbSingleton.getInstance().setMainTabPopConfig(ke5.c(jSONObject));
            this.C.a(z(jSONObject, "index_tab_info"));
            this.a.parserJson(jSONObject.optJSONObject("version"));
            this.b.b(jSONObject.optJSONObject(CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT));
            CommonHelper.setIp(jSONObject.optString("client_ip", null));
            kh.g(jSONObject.optString("client_ip", null));
            this.c.f(jSONObject.optJSONObject("config"));
            this.g.f0(jSONObject.optJSONObject("wl_config"));
            TbSingleton.getInstance().setWlConfigData(this.g);
            jSONObject.optJSONObject("channel_icon_config");
            this.j.c(jSONObject.optJSONObject("floating_icon"));
            TbSingleton.getInstance().setAdFloatViewData(this.j);
            this.k.d(jSONObject.optJSONObject("home_screen_ad"));
            TbSingleton.getInstance().setHomeInsertAdData(this.k);
            this.E.c(jSONObject.optJSONObject("https_switch_strategy_info"));
            TbadkCoreApplication.getInst().setHttpsWhileData(this.E);
            zh5 zh5Var = new zh5();
            zh5Var.d(jSONObject);
            if (zh5Var.c()) {
                TbSingleton.getInstance().setHomeOperateData(zh5Var);
            }
            String optString = jSONObject.optString("new_god_data", "");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("new_god_data");
            boolean z8 = true;
            if (!StringUtils.isNull(optString) && optJSONObject2 != null) {
                optJSONObject2.put("portrait", c15.t().r());
                TbSingleton.getInstance().setNewGodDataJson(optJSONObject2);
                if (optJSONObject2.optInt("need_show_toast_bubble") == 1) {
                    da5.p().A(da5.t("key_new_god_pop_is_show"), true);
                    da5.p().A(da5.t("key_new_god_tip_is_show"), true);
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
            new wf5().c(jSONObject.optJSONObject("dis_adv_config"));
            WhiteListData whiteListData = new WhiteListData();
            whiteListData.saveJson(jSONObject.optJSONArray("whitelist"));
            TbSingleton.getInstance().setHostWhiteList(whiteListData);
            kd5.c(jSONObject.optJSONArray("scheme_whitelist"));
            UrlSchemaJumpHelper.setBlackList(z(jSONObject, UrlSchemaJumpHelper.KEY_APP_JUMP_BLACK_LIST));
            this.h.a(jSONObject.optJSONObject("app_entrance"));
            this.i.g(jSONObject.optJSONObject("ad_adsense"));
            ag5.d(jSONObject.optJSONObject("video_report_config"));
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
            x0b x0bVar = new x0b();
            this.A = x0bVar;
            x0bVar.b(z(jSONObject, "yy_live_tab"));
            this.n.c(jSONObject.optJSONObject("hot_notify_config"));
            TbSingleton.getInstance().setHotNotifyConfig(this.n);
            o15.b().f(this.x);
            this.m.d(jSONObject.optJSONObject("profile_icon"));
            TbSingleton tbSingleton = TbSingleton.getInstance();
            if (jSONObject.optInt("recommend_userstatus", 0) == 1) {
                z = true;
            } else {
                z = false;
            }
            tbSingleton.setNewUser(z);
            da5 p = da5.p();
            if (jSONObject.optInt("ala_channel_white", 0) == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            p.A("key_live_forum_enter_switch", z2);
            TbSingleton.getInstance().setPcdnConfigData(jSONObject.optJSONObject("pcdn_config"));
            JSONArray z9 = z(jSONObject, "offpack");
            if (z9 != null && z9.length() > 0 && (jSONObject2 = z9.getJSONObject(0)) != null) {
                ux9 ux9Var = new ux9();
                ux9Var.e(jSONObject2.optString("mod_name"));
                if (jSONObject2.optInt("upload_offline_web_cache") == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                ux9Var.f(z6);
                if (jSONObject2.optInt("clear_offline_web_cache") == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                ux9Var.d(z7);
                if (!TextUtils.isEmpty(ux9Var.a())) {
                    TbSingleton.getInstance().setUploadAndClearModule(ux9Var);
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
            da5.p().F("key_mix_frs_ad_count", optInt);
            da5.p().F("key_mix_home_page_ad_count", optInt2);
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
            da5.p().F("key_personalized_rec_switch", jSONObject.optInt("personalized_rec_switch"));
            JSONObject optJSONObject5 = jSONObject.optJSONObject("bottom_bubble_config");
            if (optJSONObject5 != null) {
                qo5.f().k(optJSONObject5);
                zg.a().post(new a(this));
            }
            da5.p().F("key_work_video_guide_pop", jSONObject.optInt("videoup_guide_pop", -1));
            TbSingleton.getInstance().setVideoEventsConfig(we5.d(jSONObject));
            da5.p().J("key_sync_extra_field", jSONObject.optString("extra"));
            int optInt3 = jSONObject.optInt("icon_task_flag");
            TbSingleton tbSingleton3 = TbSingleton.getInstance();
            if (optInt3 == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            tbSingleton3.showStampMissionDialog = z4;
            int optInt4 = jSONObject.optInt("afSearch_tab", 0);
            g3a d = g3a.d();
            if (optInt4 == 1) {
                z5 = true;
            } else {
                z5 = false;
            }
            d.h(z5);
            int optInt5 = jSONObject.optInt("is_need_remind_live_rooms");
            TbSingleton tbSingleton4 = TbSingleton.getInstance();
            if (optInt5 != 1) {
                z8 = false;
            }
            tbSingleton4.setIsNeedRemindLiveRoom(z8);
            yi5.g().a(AgreeMaterial.X(jSONObject.optJSONObject("agree_material")));
            JSONObject optJSONObject6 = jSONObject.optJSONObject("live_activity_guide");
            if (optJSONObject6 != null) {
                bi5 bi5Var = new bi5();
                bi5Var.f(optJSONObject6);
                TbSingleton.getInstance().mLiveActivityGuide = bi5Var;
            } else {
                TbSingleton.getInstance().mLiveActivityGuide = null;
            }
            b06.c(jSONObject.optJSONArray("support_cache_url_list"));
            JSONArray optJSONArray = jSONObject.optJSONArray("cache_url_list");
            if (optJSONArray != null) {
                da5.p().J("key_cache_url_list", optJSONArray.toString());
                zg.a().post(new b(this, optJSONArray));
            } else {
                da5.p().J("key_cache_url_list", "");
            }
            this.F.h(jSONObject.optJSONObject("bear_sid_config"));
            D();
            JSONObject optJSONObject7 = jSONObject.optJSONObject("top_level_navi");
            if (optJSONObject7 != null) {
                da5.p().J("key_home_color_header_config", optJSONObject7.toString());
            } else {
                da5.p().Q("key_home_color_header_config");
            }
            TbSingleton.getInstance().setColourHeaderConfig(uh5.p(optJSONObject7));
            z66.e().k(jSONObject.optJSONObject("member_guide"));
            z66.e().j(jSONObject.optJSONObject("close_ad_tips"));
            JSONArray optJSONArray2 = jSONObject.optJSONArray("interact_memes");
            if (optJSONArray2 != null) {
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    LightEmotionData lightEmotionData = new LightEmotionData();
                    lightEmotionData.parseJson(optJSONArray2.getJSONObject(i));
                    this.H.add(lightEmotionData);
                }
                TbSingleton.getInstance().setLightEmotionInfo(this.H);
            }
            UserGrowthTaskListData userGrowthTaskListData = (UserGrowthTaskListData) new Gson().fromJson(jSONObject.optString("user_growth_task_list"), (Class<Object>) UserGrowthTaskListData.class);
            TbSingleton.getInstance().setUserGrowthTaskListData(userGrowthTaskListData);
            HotEventData.getInstance().parsJson(jSONObject.optJSONObject("thread_recommend_info"));
            this.G = userGrowthTaskListData;
            new eg5().b(jSONObject);
        } catch (Exception e) {
            h29 a2 = yk.a();
            a2.b(Config.DEVICE_PART, "sync exception2: " + e.getMessage());
            BdLog.e(e.getMessage());
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.F != null) {
            da5.p().J("key_server_splash_bear_sid", this.F.f());
            da5.p().J("key_server_homepage_bear_sid", this.F.b());
            da5.p().J("key_server_frs_bear_sid", this.F.a());
            da5.p().J("key_server_pb_banner_bear_sid", this.F.c());
            da5.p().J("key_server_pb_comment_bear_sid", this.F.d());
            da5.p().J("key_server_picpage_bear_sid", this.F.e());
            da5.p().J("key_server_videoflow_bear_sid", this.F.g());
        }
    }

    public cd5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.t;
        }
        return (cd5) invokeV.objValue;
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

    public dd5 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.l;
        }
        return (dd5) invokeV.objValue;
    }

    public ed5 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return (ed5) invokeV.objValue;
    }

    public gd5 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.j;
        }
        return (gd5) invokeV.objValue;
    }

    public id5 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.D;
        }
        return (id5) invokeV.objValue;
    }

    public jd5 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h;
        }
        return (jd5) invokeV.objValue;
    }

    public vd5 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (vd5) invokeV.objValue;
    }

    public CombineDownload j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.e;
        }
        return (CombineDownload) invokeV.objValue;
    }

    public wd5 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.c;
        }
        return (wd5) invokeV.objValue;
    }

    public JSONObject l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.y;
        }
        return (JSONObject) invokeV.objValue;
    }

    public ce5 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.n;
        }
        return (ce5) invokeV.objValue;
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

    public ne5 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.m;
        }
        return (ne5) invokeV.objValue;
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
            return this.G;
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

    public ze5 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.g;
        }
        return (ze5) invokeV.objValue;
    }

    public YYLiveConfig w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.z;
        }
        return (YYLiveConfig) invokeV.objValue;
    }

    public x0b x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.A;
        }
        return (x0b) invokeV.objValue;
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

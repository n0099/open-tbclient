package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdActivityStack;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.download.center.clearcache.DiskManagerSharedPrefsUtils;
import com.baidu.searchbox.launch.ScheduleStrategy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.ActivityPrizeData;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.coreExtra.data.VideoPreloadData;
import com.baidu.tbadk.pageStayDuration.PageStayDurationStat;
import com.baidu.tbadk.switchs.DisableZanSwitch;
import com.baidu.tbadk.switchs.WindowGreySwitch;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.downloadball.DownloadFloatBallConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class l95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public boolean B;
    public long C;
    public ActivityPrizeData D;
    public y85 E;
    public int F;
    public int G;
    public int H;
    public String I;
    public int J;
    public long K;
    public long L;
    public boolean M;
    public c95 N;
    public String O;
    public boolean P;
    public String Q;
    public String R;
    public String S;

    /* renamed from: T  reason: collision with root package name */
    public String f1130T;
    public int U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;
    public int a;
    public String a0;
    public int b;
    public String b0;
    public String c;
    public String c0;
    public String d;
    public int d0;
    public String e;
    public HashMap<Long, String> e0;
    public String f;
    public String f0;
    public String g;
    public String g0;
    public String h;
    public int h0;
    public String i;
    public final VideoPreloadData i0;
    public String j;
    public int j0;
    public long k;
    public s85 k0;
    public int l;
    public int l0;
    public long m;
    public int m0;
    public int n;
    public int n0;
    public int o;
    public int o0;
    public int p;
    public int p0;
    public String q;
    public int q0;
    public String r;
    public int r0;
    public String s;
    public int s0;
    public int t;
    public int t0;
    public int u;
    public String u0;
    public String v;
    public String v0;
    public String w;
    public int w0;
    public String x;
    public String x0;
    public int y;
    public int z;

    public void g0(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, jSONObject) == null) || jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optInt("Android_perf_fps_duration");
            this.b = jSONObject.optInt("Android_start_stat_instant_upload");
            TbSingleton.getInstance().isStartStatUploadImmediately = this.b == 1;
            this.c = jSONObject.optString("drop_pic");
            this.d = jSONObject.optString("drop_pic_md5");
            this.e = jSONObject.optString("drop_pic_num");
            this.f = jSONObject.optString("drop_bg_color_day");
            this.g = jSONObject.optString("drop_bg_color_night");
            this.h = jSONObject.optString("apply_vip_live_room_pid");
            this.q = jSONObject.optString("max_cache");
            this.r = jSONObject.optString("frs_max_cache");
            this.s = jSONObject.optString("frs_pn");
            this.i = jSONObject.optString("tail_link");
            this.j = jSONObject.optString("bubble_link");
            this.k = jSONObject.optLong("use_duration");
            jSONObject.optInt("xiaoying_time");
            jSONObject.optLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, 0L);
            jSONObject.optString("url_analyze_text");
            this.l = jSONObject.optInt("new_resign", 0);
            this.m = jSONObject.optLong("personalized_cache_seconds", DiskManagerSharedPrefsUtils.DISK_CHECK_DURATION_DEFAULT);
            this.n = jSONObject.optInt("personalized_max_count", 300);
            this.o = jSONObject.optInt("index_preload_not_see_thread_num", 3);
            jSONObject.optString("info_icon_url");
            jSONObject.optLong("info_time_stamp", 0L);
            jSONObject.optString("info_target_url");
            this.t = jSONObject.optInt("localvideo_open", 2);
            this.u = jSONObject.optInt("card_show_statistic", 200);
            this.v = jSONObject.optString("clean_smart_frs_cookie");
            PageStayDurationStat.getInstance().setMaxCostFromServer(jSONObject.optInt("statlog_path_max", 3));
            this.p = jSONObject.optInt("photo_cache_num", 60);
            this.w = jSONObject.optString("ueg_voice_warning");
            this.x = jSONObject.optString("nickname_activity_link");
            this.y = jSONObject.optInt("android_tab_show", 55);
            this.z = jSONObject.optInt("ribao_switch", 0);
            this.A = jSONObject.optLong("android_new_log_upload_interval", 0L);
            this.C = jSONObject.optLong("android_boss_new_log_upload_interval", 0L);
            this.B = jSONObject.optInt("android_pasteboard_delaytime", 0) == 1;
            this.i0.parserJson(jSONObject.optString("ios_video_preload_config"));
            this.w0 = jSONObject.optInt("ai_available_status");
            SharedPrefHelper.getInstance().putBoolean("KEY_ANDROID_PASTE_BOARD_DELAY_TIME", this.B);
            JSONObject optJSONObject = jSONObject.optJSONObject("laxin_config");
            if (optJSONObject != null) {
                ActivityPrizeData activityPrizeData = new ActivityPrizeData();
                this.D = activityPrizeData;
                activityPrizeData.parse(optJSONObject);
                SharedPrefHelper sharedPrefHelper = SharedPrefHelper.getInstance();
                sharedPrefHelper.putString("activity_prize_data" + TbadkCoreApplication.getCurrentAccount(), optJSONObject.toString());
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("interest_board_config");
            if (optJSONObject2 != null) {
                s85 s85Var = new s85();
                this.k0 = s85Var;
                s85Var.a(optJSONObject2);
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("nani_video");
            if (optJSONObject3 != null) {
                y85 y85Var = new y85();
                this.E = y85Var;
                y85Var.a(optJSONObject3);
            }
            ar8.f(jSONObject.optInt("android_max_stranger"));
            TiebaPlusConfigData tiebaPlusConfigData = new TiebaPlusConfigData();
            tiebaPlusConfigData.setSwitchOpen(jSONObject.optInt("switch_open") == 1);
            tiebaPlusConfigData.setJumpUrl(jSONObject.optString("tiebaplus_jumpurl"));
            TbSingleton.getInstance().setTiebaPlusConfigData(tiebaPlusConfigData);
            this.F = jSONObject.optInt("style_ab_switch", 0);
            this.G = jSONObject.optInt("abstract_ab_switch", 0);
            this.r0 = jSONObject.optInt("android_baiduid_forward_switch", 0);
            this.H = jSONObject.optInt("android_smart_frs_cache_time", -1);
            String optString = jSONObject.optString("shoubai_regex", "");
            this.I = optString;
            if (!qd.isEmpty(optString)) {
                SharedPrefHelper.getInstance().putString("key_baidu_password_re", this.I);
            }
            this.J = jSONObject.optInt("android_show_ba_concern", 0);
            SharedPrefHelper.getInstance().putInt("key_concern_tab_tips_switch", this.J);
            this.K = jSONObject.optInt("dialog_pull_time", 60) * 60000;
            this.L = jSONObject.optInt("android_dialog_lock_show_time", 300) * 1000;
            this.M = jSONObject.optInt("android_show_lock_perm_dialog", 0) == 1;
            String optString2 = jSONObject.optString("android_spring_shake", "");
            if (!StringUtils.isNull(optString2)) {
                if (this.N == null) {
                    this.N = new c95();
                }
                this.N.parserJson(optString2);
                SharedPrefHelper.getInstance().putString("shake_data", optString2);
            }
            this.O = jSONObject.optString("share_panel_text", "");
            SharedPrefHelper.getInstance().putInt("key_personalized_refresh_type", jSONObject.optInt("personalized_refresh_type", 0));
            int optInt = jSONObject.optInt("audit_package_switch", 0);
            if (optInt == 0) {
                this.P = false;
            } else if (optInt == 1) {
                this.P = true;
            }
            SharedPrefHelper.getInstance().putBoolean("audit_package_switch", this.P);
            this.Q = jSONObject.optString("profile_swan_app_key");
            SharedPrefHelper.getInstance().putString("profile_swan_app_key", this.Q);
            this.R = jSONObject.optString("android_mission_system_entrance_url");
            SharedPrefHelper.getInstance().putString("index_activity_abtest_url", this.R);
            this.S = jSONObject.optString("android_mission_system_entrance_icon");
            SharedPrefHelper.getInstance().putString("index_activity_abtest_icon_url", this.S);
            this.f1130T = jSONObject.optString("obj_source");
            SharedPrefHelper.getInstance().putString("index_activity_abtest_obj_source", this.f1130T);
            this.f0 = jSONObject.optString("namoaixud_sign_link");
            this.U = jSONObject.optInt("home_page_style_ab_test", 0);
            SharedPrefHelper.getInstance().putInt("index_activity_abtest_switch_json", this.U);
            this.g0 = jSONObject.optString(TiebaStatic.Params.SAMPLE_ID);
            SharedPrefHelper.getInstance().putString("key_ubs_sample_id", this.g0);
            im5.q("multi_process_sample_id", this.g0);
            t85.c(jSONObject.optString("js_whitelist"));
            no5.f().j(jSONObject.optString("stat_keys_list"));
            this.V = jSONObject.optString("frs_new_live_tab_video_h5", "https://tieba.baidu.com/n/interact/video/game?");
            SharedPrefHelper.getInstance().putString("ala_game_frs_live_tab_video_url", this.V);
            this.W = jSONObject.optString("ala_personal_income_detail_url", "https://tieba.baidu.com/mo/q/ala/getUserLives");
            SharedPrefHelper.getInstance().putString("ala_personal_income_detail_url", this.W);
            this.X = jSONObject.optString("ala_personal_privilege_detail_url", "http://lumotian.rmb.rmb.otp.baidu.com/cashliveui/privilege.html");
            SharedPrefHelper.getInstance().putString("ala_personal_privilege_detail_url", this.X);
            this.Y = jSONObject.optString("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
            SharedPrefHelper.getInstance().putString("ala_personal_exp_detail_url", this.Y);
            String optString3 = jSONObject.optString("showlive_forum");
            if (!StringUtils.isNull(optString3)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(optString3);
                    this.Z = jSONObject2.optString("go_url", TbConfig.TIEBA_ADDRESS + "f?kw=百度直播");
                    SharedPrefHelper.getInstance().putString("show_live_forum_url", this.Z);
                    this.a0 = jSONObject2.optString("forum_name", "百度直播");
                    SharedPrefHelper.getInstance().putString("show_live_forum_name", this.a0);
                } catch (JSONException e) {
                    BdLog.e(e);
                }
            }
            String optString4 = jSONObject.optString("user_live_mark_page");
            if (!StringUtils.isNull(optString4)) {
                try {
                    JSONObject jSONObject3 = new JSONObject(optString4);
                    this.b0 = jSONObject3.optString("mark_introduce_page", "http://ufanzhib0.baiduux.com/h5/xuzhangshuoming.html");
                    this.c0 = jSONObject3.optString("effect_introduce_page", "http://ufanzhib0.baiduux.com/h5/jinchangtexiaoshuoming.html");
                    SharedPrefHelper.getInstance().putString("ala_my_live_privilege_mark_detail_url", this.b0);
                    SharedPrefHelper.getInstance().putString("ala_my_live_privilege_effect_detail_url", this.c0);
                } catch (JSONException e2) {
                    BdLog.e(e2);
                }
            }
            String optString5 = jSONObject.optString("credit_conf");
            if (!StringUtils.isNull(optString5)) {
                try {
                    this.d0 = new JSONObject(optString5).optInt("ucenter_display");
                    SharedPrefHelper.getInstance().putInt("baidu_financial_display", this.d0);
                } catch (JSONException e3) {
                    BdLog.e(e3);
                }
            }
            String optString6 = jSONObject.optString("live_bar");
            h0(optString6);
            SharedPrefHelper.getInstance().putString("ala_live_bar_map_str", optString6);
            SharedPrefHelper.getInstance().putInt("key_is_show_shoubai_dynamic_guide", jSONObject.optInt("is_show_shoubai_dynamic_guide"));
            SharedPrefHelper.getInstance().putInt("key_show_ala_friend_tab", jSONObject.optInt("live_dating_tab_switch"));
            SharedPrefHelper.getInstance().putBoolean("key_show_vivo_badge", jSONObject.optInt("is_vivo_test_uid") == 1);
            this.h0 = jSONObject.optInt("video_red_icon_interval");
            new s75().n(jSONObject);
            d95 d95Var = new d95();
            d95Var.d(jSONObject.optJSONObject("share_panel_conf"));
            TbSingleton.getInstance().setSharePanelConfData(d95Var);
            String optString7 = jSONObject.optString("BackMechanism_sid1");
            String optString8 = jSONObject.optString("BackMechanism_sid2");
            SharedPrefHelper.getInstance().putString("key_pb_back_sid1", optString7);
            SharedPrefHelper.getInstance().putString("key_pb_back_sid2", optString8);
            this.j0 = jSONObject.optInt("video_works_progress_bar_waiting_time");
            SharedPrefHelper.getInstance().putInt("key_video_works_progress_bar_waiting_time", this.j0);
            this.l0 = jSONObject.optInt("works_add_topic_max_num");
            this.m0 = jSONObject.optInt("thread_image_width_limit");
            this.n0 = jSONObject.optInt("thread_image_height_limit");
            this.o0 = jSONObject.optInt("image_upload_concurrency");
            this.p0 = jSONObject.optInt("image_chunk_size");
            this.q0 = jSONObject.optInt("image_upload_retry");
            int optInt2 = jSONObject.optInt("launch_protect_onelevel_limit");
            if (optInt2 > 0) {
                SharedPrefHelper.getInstance().putInt("key_first_level_safe_mode_continuous_crash_time", optInt2);
            }
            int optInt3 = jSONObject.optInt("launch_protect_twolevel_limit");
            if (optInt3 > 0) {
                SharedPrefHelper.getInstance().putInt("key_second_level_safe_mode_continuous_crash_time", optInt3);
            }
            SharedPrefHelper.getInstance().putString("key_sync_task_switch", jSONObject.optString("android_sync_task_switch"));
            int optInt4 = jSONObject.optInt("video_ad_play_flag", 0);
            if (optInt4 == 1 || optInt4 == 2 || optInt4 == 3) {
                SharedPrefHelper.getInstance().putInt("auto_play_video_switch", optInt4);
            }
            String optString9 = jSONObject.optString("chatroom_config_2_12.33.0");
            if (!TextUtils.isEmpty(optString9)) {
                f85 f85Var = new f85();
                f85Var.c(optString9);
                TbSingleton.getInstance().setChatGroupThreadHold(f85Var.a(ScheduleStrategy.getDeviceScore()));
            }
            SharedPrefHelper.getInstance().putBoolean("key_group_chat_chatroom_picture_switch", jSONObject.optInt("chatroom_picture_switch", 1) == 1);
            SharedPrefHelper.getInstance().putBoolean("key_group_chat_chatroom_audio_switch", jSONObject.optInt("chatroom_audio_switch", 1) == 1);
            TbSingleton.getInstance().setLoopChatroomFrequency(jSONObject.optInt("loop_chatroom_frs_frequency", 5));
            TbSingleton.getInstance().mAdFloatTipsAppLimitCount = jSONObject.optInt("app_install_tip_num", 2);
            TbSingleton.getInstance().mAdFloatTipsDayLimitCount = jSONObject.optInt("daily_install_tip_num", 1);
            u26.h().o(jSONObject.optJSONObject("motivational_video_guide"));
            DownloadFloatBallConfig.g().o(jSONObject.optJSONObject("download_edge_float"));
            String optString10 = jSONObject.optString("ios_lite_mode_info");
            if (!StringUtils.isNull(optString10)) {
                try {
                    JSONObject jSONObject4 = new JSONObject(optString10);
                    int optInt5 = jSONObject4.optInt("themeIsBlack", 0);
                    BdActivityStack.getInst().setActivityIsGrey(optInt5 == 1);
                    WindowGreySwitch.setNewValue(optInt5);
                    DisableZanSwitch.setNewValue(jSONObject4.optInt("disableZan", 0));
                } catch (JSONException e4) {
                    BdLog.e(e4);
                }
            }
            TbSingleton.getInstance().setSendMsgCountToRemindSubscribe(jSONObject.optInt("chatroom_pop_exit_num", 1));
            this.s0 = jSONObject.optInt("forum_group_entrance_guide_frequency", 0);
            SharedPrefHelper.getInstance().putInt(SharedPrefHelper.getSharedPrefKeyWithAccount("forum_group_entrance_guide_frequency"), this.s0);
            this.t0 = jSONObject.optInt("forum_group_feed_card_frequency", 0);
            SharedPrefHelper.getInstance().putInt(SharedPrefHelper.getSharedPrefKeyWithAccount("forum_group_feed_card_frequency"), this.t0);
            this.u0 = jSONObject.optString("frs_loop_hot_chat_day_resource");
            SharedPrefHelper.getInstance().putString("frs_loop_hot_chat_day_resource", this.u0);
            this.v0 = jSONObject.optString("frs_loop_hot_chat_night_resource");
            SharedPrefHelper.getInstance().putString("frs_loop_hot_chat_night_resource", this.v0);
            String optString11 = jSONObject.optString("dynamic_res_url");
            if (!StringUtils.isNull(optString11)) {
                SharedPrefHelper.getInstance().putString("dynamic_res_url", optString11);
            }
            mh5.b.a().b(jSONObject.optJSONObject("festival_switches_config"));
            String optString12 = jSONObject.optString("ubc3Config");
            if (!StringUtils.isNull(optString12)) {
                SharedPrefHelper.getInstance().putString("key_ubc_yalog_config", optString12);
            }
            SharedPrefHelper.getInstance().putString("key_funny_sprite_uk", jSONObject.optString("funny_sprite_uk", ""));
            String optString13 = jSONObject.optString("funny_sprite_name", "");
            SharedPrefHelper.getInstance().putString("key_funny_sprite_name", optString13);
            TbSingleton.getInstance().setFunnySpriteName(optString13);
            TbSingleton.getInstance().setFunnySpriteAvatar(jSONObject.optString("funny_sprite_avatar", ""));
            String optString14 = jSONObject.optString("funny_sprite_timeout_data");
            if (!qd.isEmpty(optString14)) {
                try {
                    JSONObject jSONObject5 = new JSONObject(optString14);
                    SharedPrefHelper.getInstance().putInt("key_funny_sprite_msg_time_out", jSONObject5.optInt("funny_sprite_timeout"));
                    SharedPrefHelper.getInstance().putString("key_funny_sprite_msg_time_out_content", jSONObject5.optString("funny_sprite_timeout_content"));
                } catch (JSONException e5) {
                    BdLog.e(e5);
                }
            }
            SharedPrefHelper.getInstance().putInt("key_sprite_skip_appear_anim", jSONObject.optInt("sprite_skip_appear_anim_limit", 100));
            SharedPrefHelper.getInstance().putInt("key_sprite_skip_anim_req_delay", jSONObject.optInt("sprite_skip_anim_req_delay", 1000));
            if (jSONObject.has("funny_sprite_config")) {
                TbSingleton.getInstance().setFunnySpriteConfig((o85) DataExt.toEntity(jSONObject.optString("funny_sprite_config"), o85.class));
            }
            SharedPrefHelper.getInstance().putInt("privacy_common_param_android", jSONObject.optInt("privacy_common_param_android", 0));
            SharedPrefHelper.getInstance().putInt("privacy_cookie_param_android", jSONObject.optInt("privacy_cookie_param_android", 1));
            SharedPrefHelper.getInstance().putInt("privacy_mac_param_android", jSONObject.optInt("privacy_mac_param_android", 1));
            SharedPrefHelper.getInstance().putInt("webview_blank_page_switch_android", jSONObject.optInt("webview_blank_page_switch_android_1244", 2));
            SharedPrefHelper.getInstance().putInt("webview_reuse_limit_android", jSONObject.optInt("webview_reuse_limit", 3));
            String optString15 = jSONObject.optString("chatroom_subscribe_tips");
            if (optString15 == null) {
                return;
            }
            try {
                JSONObject jSONObject6 = new JSONObject(optString15);
                JSONObject optJSONObject4 = jSONObject6.optJSONObject("single_stop");
                if (optJSONObject4 != null) {
                    String optString16 = optJSONObject4.optString("tip");
                    int optInt6 = optJSONObject4.optInt("x");
                    TbSingleton.getInstance().setGuideTips(optString16);
                    TbSingleton.getInstance().setSecond(optInt6);
                }
                JSONObject optJSONObject5 = jSONObject6.optJSONObject("single_send_message");
                if (optJSONObject5 != null) {
                    String optString17 = optJSONObject5.optString("message");
                    String optString18 = optJSONObject5.optString("y");
                    TbSingleton.getInstance().setSingleSendMessageTips(optString17);
                    TbSingleton.getInstance().setMsgCount(optString18);
                }
                JSONObject optJSONObject6 = jSONObject6.optJSONObject("continuous_access");
                if (optJSONObject6 != null) {
                    String optString19 = optJSONObject6.optString("message");
                    String optString20 = optJSONObject6.optString("z");
                    TbSingleton.getInstance().setContinuousAccessTips(optString19);
                    TbSingleton.getInstance().setDayCount(optString20);
                }
            } catch (Exception e6) {
                BdLog.e(e6);
            }
            TbSingleton.getInstance().parseGroupChatDisturbText(jSONObject);
            zi6.d(jSONObject);
            new qa5().b(jSONObject);
            try {
                SharedPrefHelper.getInstance().putLong("key_msg_remind_frequency_minute", TimeUnit.MINUTES.toMillis(jSONObject.optLong("msg_remind_frequency_minute", 0L)));
            } catch (Exception e7) {
                BdLog.e(e7);
            }
            String optString21 = jSONObject.optString("sprite_meme_config");
            this.x0 = optString21;
            pf5.a.b(optString21);
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public l95() {
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
        this.t = 2;
        this.v = "";
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.J = 0;
        this.M = false;
        this.e0 = new HashMap<>();
        this.i0 = new VideoPreloadData();
    }

    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.q;
        }
        return (String) invokeV.objValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.S;
        }
        return (String) invokeV.objValue;
    }

    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f1130T;
        }
        return (String) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.R;
        }
        return (String) invokeV.objValue;
    }

    public y85 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.E;
        }
        return (y85) invokeV.objValue;
    }

    public long F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.A;
        }
        return invokeV.longValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.l;
        }
        return invokeV.intValue;
    }

    public String H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.x;
        }
        return (String) invokeV.objValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.o;
        }
        return invokeV.intValue;
    }

    public long J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.m;
        }
        return invokeV.longValue;
    }

    public int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.Q;
        }
        return (String) invokeV.objValue;
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.z;
        }
        return invokeV.intValue;
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.g0;
        }
        return (String) invokeV.objValue;
    }

    public c95 O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.N;
        }
        return (c95) invokeV.objValue;
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.O;
        }
        return (String) invokeV.objValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.x0;
        }
        return (String) invokeV.objValue;
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public int S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.F;
        }
        return invokeV.intValue;
    }

    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.w;
        }
        return (String) invokeV.objValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.q0;
        }
        return invokeV.intValue;
    }

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.p0;
        }
        return invokeV.intValue;
    }

    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.n0;
        }
        return invokeV.intValue;
    }

    public int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.m0;
        }
        return invokeV.intValue;
    }

    public int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.o0;
        }
        return invokeV.intValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.M;
        }
        return invokeV.booleanValue;
    }

    public long a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.k;
        }
        return invokeV.longValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.G;
        }
        return invokeV.intValue;
    }

    public VideoPreloadData b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.i0;
        }
        return (VideoPreloadData) invokeV.objValue;
    }

    public ActivityPrizeData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.D;
        }
        return (ActivityPrizeData) invokeV.objValue;
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.h0;
        }
        return invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.w0;
        }
        return invokeV.intValue;
    }

    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.f0;
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.B;
        }
        return invokeV.booleanValue;
    }

    public int e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.l0;
        }
        return invokeV.intValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.y;
        }
        return invokeV.intValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.P;
        }
        return invokeV.booleanValue;
    }

    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.r0;
        }
        return invokeV.intValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.C;
        }
        return invokeV.longValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.v;
        }
        return (String) invokeV.objValue;
    }

    public long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.K;
        }
        return invokeV.longValue;
    }

    public long m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.L;
        }
        return invokeV.longValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.r;
        }
        return (String) invokeV.objValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.n;
        }
        return invokeV.intValue;
    }

    public s85 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.k0;
        }
        return (s85) invokeV.objValue;
    }

    public HashMap<Long, String> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.e0;
        }
        return (HashMap) invokeV.objValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (this.t == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void h0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            if (StringUtils.isNull(str)) {
                str = SharedPrefHelper.getInstance().getString("ala_live_bar_map_str", "");
                if (StringUtils.isNull(str)) {
                    return;
                }
            }
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        long optLong = optJSONObject.optLong("id", 0L);
                        this.e0.put(Long.valueOf(optLong), optJSONObject.optString("name"));
                    }
                }
            }
        }
    }
}

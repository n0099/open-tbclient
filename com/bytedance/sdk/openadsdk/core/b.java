package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.baidu.webkit.internal.ETAG;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.e.m;
import com.qq.e.comm.constants.Constants;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.e.a a(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.e.n nVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, jSONObject, adSlot, nVar)) == null) {
            if (jSONObject == null) {
                return null;
            }
            try {
                com.bytedance.sdk.openadsdk.core.e.a aVar = new com.bytedance.sdk.openadsdk.core.e.a();
                aVar.a(jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID));
                aVar.a(jSONObject.optInt(Constants.KEYS.RET));
                aVar.b(jSONObject.optString("message"));
                if (aVar.b() != 0) {
                    return null;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
                if (optJSONArray != null) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        com.bytedance.sdk.openadsdk.core.e.m b2 = b(optJSONArray.optJSONObject(i2), adSlot, nVar);
                        if (b2 != null && a(b2)) {
                            aVar.a(b2);
                        }
                    }
                }
                return aVar;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (com.bytedance.sdk.openadsdk.core.e.a) invokeLLL.objValue;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.e.m b(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.e.n nVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65544, null, jSONObject, adSlot, nVar)) == null) {
            if (jSONObject == null) {
                return null;
            }
            com.bytedance.sdk.openadsdk.core.e.m mVar = new com.bytedance.sdk.openadsdk.core.e.m();
            mVar.m(jSONObject.optInt("interaction_type"));
            mVar.d(jSONObject.optString("target_url"));
            mVar.a(jSONObject.optInt("use_media_video_player", 0));
            mVar.n(jSONObject.optInt("landing_scroll_percentage", -1));
            mVar.e(jSONObject.optString("gecko_id"));
            mVar.a(jSONObject.optJSONObject(ETAG.KEY_EXTENSION));
            mVar.j(jSONObject.optString(LegoListActivityConfig.AD_ID));
            mVar.c(jSONObject.optString("source"));
            mVar.m(jSONObject.optString("package_name"));
            mVar.j(jSONObject.optInt("play_bar_show_time", -200));
            JSONObject optJSONObject = jSONObject.optJSONObject("icon");
            mVar.a(jSONObject.optBoolean(StatisticConstants.SCREENSHOT, false));
            mVar.h(jSONObject.optInt("play_bar_style", 0));
            mVar.l(jSONObject.optString("market_url", ""));
            mVar.f(jSONObject.optInt("video_adaptation", 0));
            mVar.e(jSONObject.optInt("feed_video_opentype", 0));
            mVar.b(jSONObject.optJSONObject("session_params"));
            mVar.c(jSONObject.optInt("render_control", nVar != null ? nVar.f66493e : 1));
            if (optJSONObject != null) {
                com.bytedance.sdk.openadsdk.core.e.l lVar = new com.bytedance.sdk.openadsdk.core.e.l();
                lVar.a(optJSONObject.optString("url"));
                lVar.b(optJSONObject.optInt("height"));
                lVar.a(optJSONObject.optInt("width"));
                mVar.a(lVar);
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("reward_data");
            if (optJSONObject2 != null) {
                mVar.b(optJSONObject2.optInt("reward_amount", 0));
                mVar.a(optJSONObject2.optString("reward_name", ""));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("image");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    com.bytedance.sdk.openadsdk.core.e.l lVar2 = new com.bytedance.sdk.openadsdk.core.e.l();
                    JSONObject optJSONObject3 = optJSONArray.optJSONObject(i2);
                    lVar2.a(optJSONObject3.optString("url"));
                    lVar2.b(optJSONObject3.optInt("height"));
                    lVar2.a(optJSONObject3.optInt("width"));
                    lVar2.a(optJSONObject3.optInt("duration"));
                    lVar2.a(optJSONObject3.optBoolean("image_preview"));
                    lVar2.b(optJSONObject3.optString("image_key"));
                    mVar.b(lVar2);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("show_url");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    mVar.af().add(optJSONArray2.optString(i3));
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("click_url");
            if (optJSONArray3 != null) {
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    mVar.ag().add(optJSONArray3.optString(i4));
                }
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject("click_area");
            if (optJSONObject4 != null) {
                com.bytedance.sdk.openadsdk.core.e.e eVar = new com.bytedance.sdk.openadsdk.core.e.e();
                eVar.f66403a = optJSONObject4.optBoolean("click_upper_content_area", true);
                eVar.f66404b = optJSONObject4.optBoolean("click_upper_non_content_area", true);
                eVar.f66405c = optJSONObject4.optBoolean("click_lower_content_area", true);
                eVar.f66406d = optJSONObject4.optBoolean("click_lower_non_content_area", true);
                eVar.f66407e = optJSONObject4.optBoolean("click_button_area", true);
                eVar.f66408f = optJSONObject4.optBoolean("click_video_area", true);
                mVar.a(eVar);
            }
            JSONObject optJSONObject5 = jSONObject.optJSONObject("adslot");
            if (optJSONObject5 != null) {
                mVar.a(c(optJSONObject5));
            } else {
                mVar.a(adSlot);
            }
            mVar.i(jSONObject.optInt("intercept_flag", 0));
            mVar.f(jSONObject.optString(Oauth2AccessToken.KEY_PHONE_NUM));
            mVar.g(jSONObject.optString("title"));
            mVar.h(jSONObject.optString("description"));
            mVar.i(jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT));
            mVar.g(jSONObject.optInt("ad_logo", 1));
            mVar.k(jSONObject.optString("ext"));
            mVar.o(jSONObject.optInt("image_mode"));
            mVar.v(jSONObject.optInt("orientation", 1));
            mVar.a((float) jSONObject.optDouble("aspect_ratio", 100.0d));
            JSONObject optJSONObject6 = jSONObject.optJSONObject("app");
            JSONObject optJSONObject7 = jSONObject.optJSONObject("download_sdk_conf");
            JSONObject optJSONObject8 = jSONObject.optJSONObject("deep_link");
            mVar.a(d(optJSONObject6));
            mVar.a(e(optJSONObject7));
            mVar.a(i(optJSONObject8));
            mVar.a(new com.bytedance.sdk.openadsdk.core.e.o(jSONObject));
            mVar.a(new com.bytedance.sdk.openadsdk.dislike.c.b(jSONObject));
            mVar.p(jSONObject.optInt("count_down"));
            mVar.a(jSONObject.optLong(GameGuideConfigInfo.KEY_EXPIRATION_TIME));
            JSONObject optJSONObject9 = jSONObject.optJSONObject("video");
            if (optJSONObject9 != null) {
                mVar.a(j(optJSONObject9));
            }
            JSONObject optJSONObject10 = jSONObject.optJSONObject("download_conf");
            if (optJSONObject10 != null) {
                mVar.a(f(optJSONObject10));
            }
            mVar.q(jSONObject.optInt("if_both_open"));
            mVar.r(jSONObject.optInt("if_double_deeplink"));
            JSONObject optJSONObject11 = jSONObject.optJSONObject("app_manage");
            if (optJSONObject11 != null) {
                mVar.a(b(optJSONObject11));
                mVar.b(optJSONObject11.toString());
            }
            mVar.a(k(jSONObject.optJSONObject("media_ext")));
            mVar.s(jSONObject.optInt("landing_page_type"));
            JSONObject optJSONObject12 = jSONObject.optJSONObject("tpl_info");
            if (optJSONObject12 != null) {
                m.a aVar = new m.a();
                aVar.b(optJSONObject12.optString("id"));
                aVar.c(optJSONObject12.optString(PackageTable.MD5));
                aVar.d(optJSONObject12.optString("url"));
                aVar.e(optJSONObject12.optString("data"));
                aVar.f(optJSONObject12.optString("diff_data"));
                aVar.g(optJSONObject12.optString("dynamic_creative"));
                aVar.a(optJSONObject12.optString("version"));
                mVar.a(aVar);
            }
            JSONObject optJSONObject13 = jSONObject.optJSONObject("middle_tpl_info");
            if (optJSONObject13 != null) {
                m.a aVar2 = new m.a();
                aVar2.b(optJSONObject13.optString("middle_id"));
                aVar2.c(optJSONObject13.optString("middle_md5"));
                aVar2.d(optJSONObject13.optString("middle_url"));
                aVar2.e(optJSONObject13.optString("middle_data"));
                aVar2.f(optJSONObject13.optString("middle_diff_data"));
                aVar2.g(optJSONObject13.optString("middle_dynamic_creative"));
                aVar2.a(optJSONObject13.optString("middle_version"));
                mVar.b(aVar2);
            }
            mVar.d(jSONObject.optInt("if_block_lp", 0));
            mVar.k(jSONObject.optInt("cache_sort", 1));
            mVar.l(jSONObject.optInt("if_sp_cache", 0));
            JSONObject optJSONObject14 = jSONObject.optJSONObject("render");
            if (optJSONObject14 != null) {
                mVar.t(optJSONObject14.optInt("render_sequence", 0));
                mVar.u(optJSONObject14.optInt("backup_render_control", 1));
            }
            JSONObject optJSONObject15 = jSONObject.optJSONObject("splash_control");
            if (optJSONObject15 != null) {
                mVar.a(g(optJSONObject15));
            }
            JSONObject optJSONObject16 = jSONObject.optJSONObject("splash_icon");
            if (optJSONObject16 != null) {
                mVar.a(h(optJSONObject16));
            }
            mVar.n(jSONObject.optString("ad_info"));
            mVar.d(jSONObject.optBoolean("close_on_dislike", false));
            mVar.o(jSONObject.optString("adx_name"));
            return mVar;
        }
        return (com.bytedance.sdk.openadsdk.core.e.m) invokeLLL.objValue;
    }

    public static AdSlot c(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("mCodeId", "");
            int optInt = jSONObject.optInt("mImgAcceptedWidth", 0);
            int optInt2 = jSONObject.optInt("mImgAcceptedHeight", 0);
            int optInt3 = jSONObject.optInt("mAdCount", 6);
            boolean optBoolean = jSONObject.optBoolean("mSupportDeepLink", true);
            String optString2 = jSONObject.optString("mRewardName", "");
            int optInt4 = jSONObject.optInt("mRewardAmount", 0);
            String optString3 = jSONObject.optString("mMediaExtra", "");
            String optString4 = jSONObject.optString("mUserID", "");
            int optInt5 = jSONObject.optInt("mOrientation", 2);
            return new AdSlot.Builder().setCodeId(optString).setImageAcceptedSize(optInt, optInt2).setExpressViewAcceptedSize((float) jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d), (float) jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d)).setAdCount(optInt3).setSupportDeepLink(optBoolean).setRewardName(optString2).setRewardAmount(optInt4).setMediaExtra(optString3).setUserID(optString4).setOrientation(optInt5).setNativeAdType(jSONObject.optInt("mNativeAdType", 0)).setIsAutoPlay(jSONObject.optBoolean("mIsAutoPlay", false)).build();
        }
        return (AdSlot) invokeL.objValue;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.e.b d(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            com.bytedance.sdk.openadsdk.core.e.b bVar = new com.bytedance.sdk.openadsdk.core.e.b();
            bVar.c(jSONObject.optString("app_name"));
            bVar.d(jSONObject.optString("package_name"));
            bVar.b(jSONObject.optString("download_url"));
            bVar.a(jSONObject.optInt("score", 4));
            bVar.b(jSONObject.optInt("comment_num", 6870));
            bVar.c(jSONObject.optInt("app_size", 0));
            bVar.a(jSONObject.optString("quick_app_url", ""));
            return bVar;
        }
        return (com.bytedance.sdk.openadsdk.core.e.b) invokeL.objValue;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.e.j e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            com.bytedance.sdk.openadsdk.core.e.j jVar = new com.bytedance.sdk.openadsdk.core.e.j();
            jVar.a(jSONObject.optInt("ah", 1));
            jVar.b(jSONObject.optInt("am", 1));
            return jVar;
        }
        return (com.bytedance.sdk.openadsdk.core.e.j) invokeL.objValue;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.e.h f(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            com.bytedance.sdk.openadsdk.core.e.h hVar = new com.bytedance.sdk.openadsdk.core.e.h();
            hVar.c(jSONObject.optInt("auto_open", 1));
            hVar.d(jSONObject.optInt("download_mode", 0));
            hVar.e(jSONObject.optInt("auto_control", 0));
            hVar.i(jSONObject.optInt("auto_control_choose", 0));
            hVar.j(jSONObject.optInt("auto_control_time", 300));
            hVar.b(jSONObject.optInt("download_type", -1));
            hVar.a(jSONObject.optInt("if_suspend_download", 1));
            hVar.k(jSONObject.optInt("if_send_click", 0));
            hVar.f(jSONObject.optInt("dl_popup", 1));
            hVar.g(jSONObject.optInt("market_popup", 1));
            hVar.h(jSONObject.optInt("if_pop_lp", 1));
            return hVar;
        }
        return (com.bytedance.sdk.openadsdk.core.e.h) invokeL.objValue;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.e.r g(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            com.bytedance.sdk.openadsdk.core.e.r rVar = new com.bytedance.sdk.openadsdk.core.e.r();
            rVar.a(jSONObject.optInt("splash_clickarea", 1));
            rVar.a(jSONObject.optString("splash_clicktext", ""));
            rVar.b(jSONObject.optInt("area_height", 50));
            rVar.c(jSONObject.optInt("area_width", 236));
            rVar.d(jSONObject.optInt("area_blank_height", 82));
            rVar.e(jSONObject.optInt("half_blank_height", 56));
            return rVar;
        }
        return (com.bytedance.sdk.openadsdk.core.e.r) invokeL.objValue;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.e.s h(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            com.bytedance.sdk.openadsdk.core.e.s sVar = new com.bytedance.sdk.openadsdk.core.e.s();
            sVar.b(jSONObject.optInt("splash_icon_height", 72));
            sVar.a(jSONObject.optInt("splash_icon_width", 54));
            sVar.a(jSONObject.optString("splash_icon_url", ""));
            sVar.d(jSONObject.optInt("splash_icon_video_height", 126));
            sVar.c(jSONObject.optInt("splash_icon_video_width", 71));
            return sVar;
        }
        return (com.bytedance.sdk.openadsdk.core.e.s) invokeL.objValue;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.e.g i(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            com.bytedance.sdk.openadsdk.core.e.g gVar = new com.bytedance.sdk.openadsdk.core.e.g();
            gVar.a(jSONObject.optString("deeplink_url"));
            gVar.b(jSONObject.optString("fallback_url"));
            gVar.a(jSONObject.optInt("fallback_type"));
            return gVar;
        }
        return (com.bytedance.sdk.openadsdk.core.e.g) invokeL.objValue;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.e.x j(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            com.bytedance.sdk.openadsdk.core.e.x xVar = new com.bytedance.sdk.openadsdk.core.e.x();
            xVar.b(jSONObject.optInt("cover_height"));
            xVar.c(jSONObject.optInt("cover_width"));
            xVar.a(jSONObject.optString("resolution"));
            xVar.a(jSONObject.optLong("size"));
            xVar.a(jSONObject.optDouble(AdWebVideoActivityConfig.KEY_VIDEO_DURATION));
            xVar.b(jSONObject.optString("cover_url"));
            xVar.c(jSONObject.optString("video_url"));
            xVar.d(jSONObject.optString("endcard"));
            xVar.e(jSONObject.optString("playable_download_url"));
            xVar.g(jSONObject.optInt("if_playable_loading_show", 0));
            xVar.h(jSONObject.optInt("remove_loading_page_type", 0));
            xVar.f(jSONObject.optString("file_hash"));
            xVar.a(jSONObject.optInt("fallback_endcard_judge", 0));
            xVar.d(jSONObject.optInt("video_preload_size", 307200));
            xVar.e(jSONObject.optInt("reward_video_cached_type", 0));
            xVar.f(jSONObject.optInt("execute_cached_type", 0));
            return xVar;
        }
        return (com.bytedance.sdk.openadsdk.core.e.x) invokeL.objValue;
    }

    public static Map<String, Object> k(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    hashMap.put(next, jSONObject.opt(next));
                }
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.e.m a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return b(jSONObject, null, null);
        }
        return (com.bytedance.sdk.openadsdk.core.e.m) invokeL.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0073, code lost:
        if (r0 != 16) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(com.bytedance.sdk.openadsdk.core.e.m mVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, mVar)) == null) {
            boolean z = mVar != null;
            if (TextUtils.isEmpty(mVar.ak()) || mVar.ak().length() <= 1 || !a(mVar.an())) {
                return false;
            }
            int X = mVar.X();
            if (X == 2 || X == 3 ? TextUtils.isEmpty(mVar.Z()) : !(X == 4 ? a(mVar.al()) : X != 5 || !TextUtils.isEmpty(mVar.ae()))) {
                z = false;
            }
            if (z) {
                int ap = mVar.ap();
                if (ap != 2 && ap != 3 && ap != 4) {
                    if (ap == 5 || ap == 15) {
                        if (!a(mVar.V())) {
                            return false;
                        }
                    }
                    return z;
                }
                if (!a(mVar.ad())) {
                    return false;
                }
                return z;
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.e.g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, gVar)) == null) {
            if (gVar == null) {
                return true;
            }
            if (TextUtils.isEmpty(gVar.a()) || TextUtils.isEmpty(gVar.b())) {
                return false;
            }
            return gVar.c() == 1 || gVar.c() == 2;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.e.x xVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, xVar)) == null) ? (xVar == null || TextUtils.isEmpty(xVar.i()) || TextUtils.isEmpty(xVar.h())) ? false : true : invokeL.booleanValue;
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.e.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) ? (bVar == null || TextUtils.isEmpty(bVar.b())) ? false : true : invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(List<com.bytedance.sdk.openadsdk.core.e.l> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, list)) == null) {
            if (list != null && list.size() > 0) {
                for (com.bytedance.sdk.openadsdk.core.e.l lVar : list) {
                    if (lVar == null || TextUtils.isEmpty(lVar.a())) {
                        return false;
                    }
                    while (r4.hasNext()) {
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.e.c b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            com.bytedance.sdk.openadsdk.core.e.c cVar = new com.bytedance.sdk.openadsdk.core.e.c();
            cVar.b(jSONObject.optString("developer_name"));
            cVar.a(jSONObject.optString("app_version"));
            JSONArray optJSONArray = jSONObject.optJSONArray("permissions");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                cVar.a(optJSONArray);
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        cVar.a(optJSONObject.optString(IdCardActivity.RESULT_PERMISSION_KEY), optJSONObject.optString("permission_desc"));
                    }
                }
            }
            cVar.c(jSONObject.optString("privacy_policy_url"));
            cVar.e(jSONObject.optString("app_name"));
            cVar.d(jSONObject.optString("package_name"));
            return cVar;
        }
        return (com.bytedance.sdk.openadsdk.core.e.c) invokeL.objValue;
    }
}

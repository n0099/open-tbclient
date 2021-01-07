package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.ar.gesture.GestureAR;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.qq.e.comm.constants.Constants;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {
    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.a a(JSONObject jSONObject, AdSlot adSlot) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.d.a aVar = new com.bytedance.sdk.openadsdk.core.d.a();
            aVar.a(jSONObject.optString("request_id"));
            aVar.a(jSONObject.optInt(Constants.KEYS.RET));
            aVar.b(jSONObject.optString("message"));
            if (aVar.b() == 0) {
                JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        com.bytedance.sdk.openadsdk.core.d.l b2 = b(optJSONArray.optJSONObject(i), adSlot);
                        if (b2 != null && a(b2)) {
                            aVar.a(b2);
                        }
                    }
                }
                return aVar;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.l a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return b(jSONObject, null);
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.l b(JSONObject jSONObject, AdSlot adSlot) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.l lVar = new com.bytedance.sdk.openadsdk.core.d.l();
        lVar.k(jSONObject.optInt("interaction_type"));
        lVar.e(jSONObject.optString("target_url"));
        lVar.f(jSONObject.optString("gecko_id"));
        lVar.k(jSONObject.optString(LegoListActivityConfig.AD_ID));
        lVar.d(jSONObject.optString("source"));
        lVar.n(jSONObject.optString("package_name"));
        lVar.n(jSONObject.optInt("dislike_control", 0));
        lVar.h(jSONObject.optInt("play_bar_show_time", -200));
        lVar.a(jSONObject.optBoolean("is_playable"));
        lVar.b(jSONObject.optInt("playable_type", 0));
        lVar.a(jSONObject.optString("playable_style"));
        JSONObject optJSONObject = jSONObject.optJSONObject(AlaStaticKeys.ALA_STATIC_VALUE_ICON);
        lVar.b(jSONObject.optBoolean(StatisticConstants.SCREENSHOT, false));
        lVar.f(jSONObject.optInt("play_bar_style", 0));
        lVar.m(jSONObject.optString("market_url", ""));
        lVar.d(jSONObject.optInt("video_adaptation", 0));
        lVar.c(jSONObject.optInt("feed_video_opentype", 0));
        lVar.a(jSONObject.optJSONObject("session_params"));
        if (optJSONObject != null) {
            com.bytedance.sdk.openadsdk.core.d.k kVar = new com.bytedance.sdk.openadsdk.core.d.k();
            kVar.a(optJSONObject.optString("url"));
            kVar.b(optJSONObject.optInt("height"));
            kVar.a(optJSONObject.optInt("width"));
            lVar.a(kVar);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("cover_image");
        if (optJSONObject2 != null) {
            com.bytedance.sdk.openadsdk.core.d.k kVar2 = new com.bytedance.sdk.openadsdk.core.d.k();
            kVar2.a(optJSONObject2.optString("url"));
            kVar2.b(optJSONObject2.optInt("height"));
            kVar2.a(optJSONObject2.optInt("width"));
            lVar.b(kVar2);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("image");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                com.bytedance.sdk.openadsdk.core.d.k kVar3 = new com.bytedance.sdk.openadsdk.core.d.k();
                JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                kVar3.a(optJSONObject3.optString("url"));
                kVar3.b(optJSONObject3.optInt("height"));
                kVar3.a(optJSONObject3.optInt("width"));
                lVar.c(kVar3);
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("show_url");
        if (optJSONArray2 != null) {
            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                lVar.O().add(optJSONArray2.optString(i2));
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("click_url");
        if (optJSONArray3 != null) {
            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                lVar.P().add(optJSONArray3.optString(i3));
            }
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("click_area");
        if (optJSONObject4 != null) {
            com.bytedance.sdk.openadsdk.core.d.e eVar = new com.bytedance.sdk.openadsdk.core.d.e();
            eVar.f6791a = optJSONObject4.optBoolean("click_upper_content_area", true);
            eVar.f6792b = optJSONObject4.optBoolean("click_upper_non_content_area", true);
            eVar.c = optJSONObject4.optBoolean("click_lower_content_area", true);
            eVar.d = optJSONObject4.optBoolean("click_lower_non_content_area", true);
            eVar.e = optJSONObject4.optBoolean("click_button_area", true);
            eVar.f = optJSONObject4.optBoolean("click_video_area", true);
            lVar.a(eVar);
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("adslot");
        if (optJSONObject5 != null) {
            lVar.a(c(optJSONObject5));
        } else {
            lVar.a(adSlot);
        }
        lVar.g(jSONObject.optInt("intercept_flag", 0));
        lVar.g(jSONObject.optString(Oauth2AccessToken.KEY_PHONE_NUM));
        lVar.h(jSONObject.optString("title"));
        lVar.i(jSONObject.optString("description"));
        lVar.j(jSONObject.optString("button_text"));
        lVar.e(jSONObject.optInt("ad_logo", 1));
        lVar.l(jSONObject.optString("ext"));
        lVar.l(jSONObject.optInt("image_mode"));
        JSONObject optJSONObject6 = jSONObject.optJSONObject("app");
        JSONObject optJSONObject7 = jSONObject.optJSONObject("deep_link");
        lVar.a(e(optJSONObject6));
        lVar.a(g(optJSONObject7));
        JSONArray optJSONArray4 = jSONObject.optJSONArray("filter_words");
        if (optJSONArray4 != null) {
            for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                FilterWord d = d(optJSONArray4.optJSONObject(i4));
                if (d != null && d.isValid()) {
                    lVar.a(d);
                }
            }
        }
        lVar.m(jSONObject.optInt("count_down"));
        lVar.a(jSONObject.optLong("expiration_time"));
        JSONObject optJSONObject8 = jSONObject.optJSONObject("video");
        if (optJSONObject8 != null) {
            lVar.a(h(optJSONObject8));
        }
        JSONObject optJSONObject9 = jSONObject.optJSONObject("download_conf");
        if (optJSONObject9 != null) {
            lVar.a(f(optJSONObject9));
        }
        JSONObject optJSONObject10 = jSONObject.optJSONObject("app_manage");
        if (optJSONObject10 != null) {
            lVar.a(b(optJSONObject10));
            lVar.c(optJSONObject10.toString());
        }
        lVar.a(i(jSONObject.optJSONObject("media_ext")));
        JSONObject optJSONObject11 = jSONObject.optJSONObject("tpl_info");
        if (optJSONObject11 != null) {
            l.a aVar = new l.a();
            aVar.b(optJSONObject11.optString("id"));
            aVar.c(optJSONObject11.optString("md5"));
            aVar.d(optJSONObject11.optString("url"));
            aVar.e(optJSONObject11.optString("data"));
            aVar.f(optJSONObject11.optString("diff_data"));
            aVar.g(optJSONObject11.optString("dynamic_creative"));
            aVar.a(optJSONObject11.optString("version"));
            lVar.a(aVar);
        }
        lVar.a(jSONObject.optInt("if_block_lp", 0));
        lVar.i(jSONObject.optInt("cache_sort", 1));
        lVar.j(jSONObject.optInt("if_sp_cache", 0));
        return lVar;
    }

    private static AdSlot c(JSONObject jSONObject) {
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
        int optInt6 = jSONObject.optInt("mNativeAdType", 0);
        return new AdSlot.Builder().setCodeId(optString).setImageAcceptedSize(optInt, optInt2).setExpressViewAcceptedSize((float) jSONObject.optDouble("mExpressViewAcceptedWidth", 0.0d), (float) jSONObject.optDouble("mExpressViewAcceptedHeight", 0.0d)).setAdCount(optInt3).setSupportDeepLink(optBoolean).setRewardName(optString2).setRewardAmount(optInt4).setMediaExtra(optString3).setUserID(optString4).setOrientation(optInt5).setNativeAdType(optInt6).setIsAutoPlay(jSONObject.optBoolean("mIsAutoPlay", false)).build();
    }

    private static FilterWord d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            FilterWord filterWord = new FilterWord();
            filterWord.setId(jSONObject.optString("id"));
            filterWord.setName(jSONObject.optString("name"));
            filterWord.setIsSelected(jSONObject.optBoolean("is_selected"));
            JSONArray optJSONArray = jSONObject.optJSONArray("options");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    FilterWord d = d(optJSONArray.optJSONObject(i));
                    if (d != null && d.isValid()) {
                        filterWord.addOption(d);
                    }
                }
            }
            return filterWord;
        } catch (Throwable th) {
            return null;
        }
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.d.b e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.b bVar = new com.bytedance.sdk.openadsdk.core.d.b();
        bVar.c(jSONObject.optString("app_name"));
        bVar.d(jSONObject.optString("package_name"));
        bVar.b(jSONObject.optString("download_url"));
        bVar.a(jSONObject.optInt(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, 4));
        bVar.b(jSONObject.optInt("comment_num", 6870));
        bVar.c(jSONObject.optInt("app_size", 0));
        bVar.a(jSONObject.optString("quick_app_url", ""));
        return bVar;
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.d.h f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.h hVar = new com.bytedance.sdk.openadsdk.core.d.h();
        hVar.c(jSONObject.optInt("auto_open", 0));
        hVar.d(jSONObject.optInt("download_mode", 0));
        hVar.e(jSONObject.optInt("auto_control", 0));
        hVar.b(jSONObject.optInt("download_type", -1));
        hVar.a(jSONObject.optInt("if_suspend_download", 1));
        hVar.f(jSONObject.optInt("dl_popup", 1));
        hVar.g(jSONObject.optInt("market_popup", 1));
        hVar.h(jSONObject.optInt("if_pop_lp", 1));
        return hVar;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.c b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.c cVar = new com.bytedance.sdk.openadsdk.core.d.c();
        cVar.b(jSONObject.optString("developer_name"));
        cVar.a(jSONObject.optString("app_version"));
        JSONArray optJSONArray = jSONObject.optJSONArray("permissions");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            cVar.a(optJSONArray);
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    cVar.a(optJSONObject.optString("permission_name"), optJSONObject.optString("permission_desc"));
                }
            }
        }
        cVar.c(jSONObject.optString("privacy_policy_url"));
        cVar.e(jSONObject.optString("app_name"));
        cVar.d(jSONObject.optString("package_name"));
        return cVar;
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.d.g g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.g gVar = new com.bytedance.sdk.openadsdk.core.d.g();
        gVar.a(jSONObject.optString("deeplink_url"));
        gVar.b(jSONObject.optString("fallback_url"));
        gVar.a(jSONObject.optInt("fallback_type"));
        return gVar;
    }

    @Nullable
    private static com.bytedance.sdk.openadsdk.core.d.s h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.s sVar = new com.bytedance.sdk.openadsdk.core.d.s();
        sVar.b(jSONObject.optInt("cover_height"));
        sVar.c(jSONObject.optInt("cover_width"));
        sVar.a(jSONObject.optString("resolution"));
        sVar.a(jSONObject.optLong("size"));
        sVar.a(jSONObject.optDouble(AdWebVideoActivityConfig.KEY_VIDEO_DURATION));
        sVar.b(jSONObject.optString("cover_url"));
        sVar.c(jSONObject.optString("video_url"));
        sVar.d(jSONObject.optString("endcard"));
        sVar.e(jSONObject.optString("playable_download_url"));
        sVar.f(jSONObject.optString("file_hash"));
        sVar.d(jSONObject.optInt("if_playable_loading_show", 0));
        sVar.e(jSONObject.optInt("remove_loading_page_type", 0));
        sVar.a(jSONObject.optInt("fallback_endcard_judge", 0));
        return sVar;
    }

    private static Map<String, Object> i(JSONObject jSONObject) {
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

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        boolean z = lVar != null;
        if (TextUtils.isEmpty(lVar.T()) || lVar.T().length() <= 1 || !a(lVar.V())) {
            return false;
        }
        switch (lVar.H()) {
            case 2:
            case 3:
                if (TextUtils.isEmpty(lVar.K())) {
                    z = false;
                    break;
                }
                break;
            case 4:
                if (!a(lVar.U())) {
                    z = false;
                    break;
                }
                break;
            case 5:
                if (TextUtils.isEmpty(lVar.N())) {
                    z = false;
                    break;
                }
                break;
        }
        if (z) {
            switch (lVar.X()) {
                case 2:
                case 3:
                case 4:
                case 16:
                    if (!a(lVar.M())) {
                        return false;
                    }
                    break;
                case 5:
                case 15:
                    if (!a(lVar.F())) {
                        return false;
                    }
                    break;
            }
            return z;
        }
        return z;
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.g gVar) {
        if (gVar == null) {
            return true;
        }
        if (TextUtils.isEmpty(gVar.a()) || TextUtils.isEmpty(gVar.b())) {
            return false;
        }
        return gVar.c() == 1 || gVar.c() == 2;
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.s sVar) {
        return (sVar == null || TextUtils.isEmpty(sVar.h()) || TextUtils.isEmpty(sVar.g())) ? false : true;
    }

    private static boolean a(com.bytedance.sdk.openadsdk.core.d.b bVar) {
        return (bVar == null || TextUtils.isEmpty(bVar.b())) ? false : true;
    }

    private static boolean a(List<com.bytedance.sdk.openadsdk.core.d.k> list) {
        if (list != null && list.size() > 0) {
            for (com.bytedance.sdk.openadsdk.core.d.k kVar : list) {
                if (kVar == null) {
                    return false;
                }
                if (TextUtils.isEmpty(kVar.a())) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

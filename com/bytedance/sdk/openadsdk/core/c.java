package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.qq.e.comm.constants.Constants;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.a a(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.d.m mVar) {
        if (jSONObject == null) {
            return null;
        }
        try {
            com.bytedance.sdk.openadsdk.core.d.a aVar = new com.bytedance.sdk.openadsdk.core.d.a();
            aVar.a(jSONObject.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID));
            aVar.a(jSONObject.optInt(Constants.KEYS.RET));
            aVar.b(jSONObject.optString("message"));
            if (aVar.b() != 0) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    com.bytedance.sdk.openadsdk.core.d.l b2 = b(optJSONArray.optJSONObject(i2), adSlot, mVar);
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

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.l b(JSONObject jSONObject, AdSlot adSlot, com.bytedance.sdk.openadsdk.core.d.m mVar) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.l lVar = new com.bytedance.sdk.openadsdk.core.d.l();
        lVar.n(jSONObject.optInt("interaction_type"));
        lVar.f(jSONObject.optString("target_url"));
        lVar.a(jSONObject.optInt("use_media_video_player", 0));
        lVar.a(jSONObject.optJSONObject("playable"));
        lVar.o(jSONObject.optInt("landing_scroll_percentage", -1));
        lVar.g(jSONObject.optString("gecko_id"));
        lVar.l(jSONObject.optString(LegoListActivityConfig.AD_ID));
        lVar.e(jSONObject.optString("source"));
        lVar.o(jSONObject.optString("package_name"));
        lVar.u(jSONObject.optInt("dislike_control", 0));
        lVar.k(jSONObject.optInt("play_bar_show_time", -200));
        lVar.a(jSONObject.optBoolean("is_playable"));
        lVar.e(jSONObject.optInt("playable_type", 0));
        lVar.b(jSONObject.optString("playable_style"));
        JSONObject optJSONObject = jSONObject.optJSONObject("icon");
        lVar.b(jSONObject.optBoolean("screenshot", false));
        lVar.i(jSONObject.optInt("play_bar_style", 0));
        lVar.n(jSONObject.optString("market_url", ""));
        lVar.g(jSONObject.optInt("video_adaptation", 0));
        lVar.f(jSONObject.optInt("feed_video_opentype", 0));
        lVar.b(jSONObject.optJSONObject("session_params"));
        lVar.c(jSONObject.optInt("render_control", mVar != null ? mVar.f27913e : 1));
        if (optJSONObject != null) {
            com.bytedance.sdk.openadsdk.core.d.k kVar = new com.bytedance.sdk.openadsdk.core.d.k();
            kVar.a(optJSONObject.optString("url"));
            kVar.b(optJSONObject.optInt("height"));
            kVar.a(optJSONObject.optInt("width"));
            lVar.a(kVar);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("reward_data");
        if (optJSONObject2 != null) {
            lVar.b(optJSONObject2.optInt("reward_amount", 0));
            lVar.a(optJSONObject2.optString("reward_name", ""));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("cover_image");
        if (optJSONObject3 != null) {
            com.bytedance.sdk.openadsdk.core.d.k kVar2 = new com.bytedance.sdk.openadsdk.core.d.k();
            kVar2.a(optJSONObject3.optString("url"));
            kVar2.b(optJSONObject3.optInt("height"));
            kVar2.a(optJSONObject3.optInt("width"));
            lVar.b(kVar2);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("image");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                com.bytedance.sdk.openadsdk.core.d.k kVar3 = new com.bytedance.sdk.openadsdk.core.d.k();
                JSONObject optJSONObject4 = optJSONArray.optJSONObject(i2);
                kVar3.a(optJSONObject4.optString("url"));
                kVar3.b(optJSONObject4.optInt("height"));
                kVar3.a(optJSONObject4.optInt("width"));
                kVar3.a(optJSONObject4.optInt("duration"));
                lVar.c(kVar3);
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("show_url");
        if (optJSONArray2 != null) {
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                lVar.ah().add(optJSONArray2.optString(i3));
            }
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("click_url");
        if (optJSONArray3 != null) {
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                lVar.ai().add(optJSONArray3.optString(i4));
            }
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("click_area");
        if (optJSONObject5 != null) {
            com.bytedance.sdk.openadsdk.core.d.e eVar = new com.bytedance.sdk.openadsdk.core.d.e();
            eVar.f27833a = optJSONObject5.optBoolean("click_upper_content_area", true);
            eVar.f27834b = optJSONObject5.optBoolean("click_upper_non_content_area", true);
            eVar.f27835c = optJSONObject5.optBoolean("click_lower_content_area", true);
            eVar.f27836d = optJSONObject5.optBoolean("click_lower_non_content_area", true);
            eVar.f27837e = optJSONObject5.optBoolean("click_button_area", true);
            eVar.f27838f = optJSONObject5.optBoolean("click_video_area", true);
            lVar.a(eVar);
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("adslot");
        if (optJSONObject6 != null) {
            lVar.a(c(optJSONObject6));
        } else {
            lVar.a(adSlot);
        }
        lVar.j(jSONObject.optInt("intercept_flag", 0));
        lVar.h(jSONObject.optString(Oauth2AccessToken.KEY_PHONE_NUM));
        lVar.i(jSONObject.optString("title"));
        lVar.j(jSONObject.optString("description"));
        lVar.k(jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT));
        lVar.h(jSONObject.optInt("ad_logo", 1));
        lVar.m(jSONObject.optString("ext"));
        lVar.p(jSONObject.optInt("image_mode"));
        JSONObject optJSONObject7 = jSONObject.optJSONObject("app");
        JSONObject optJSONObject8 = jSONObject.optJSONObject("deep_link");
        lVar.a(e(optJSONObject7));
        lVar.a(h(optJSONObject8));
        JSONArray optJSONArray4 = jSONObject.optJSONArray("filter_words");
        if (optJSONArray4 != null) {
            for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                FilterWord d2 = d(optJSONArray4.optJSONObject(i5));
                if (d2 != null && d2.isValid()) {
                    lVar.a(d2);
                }
            }
        }
        lVar.a(PersonalizationPrompt.parseFromJson(jSONObject.optJSONObject("personalization_prompts")));
        lVar.q(jSONObject.optInt("count_down"));
        lVar.a(jSONObject.optLong(GameGuideConfigInfo.KEY_EXPIRATION_TIME));
        JSONObject optJSONObject9 = jSONObject.optJSONObject("video");
        if (optJSONObject9 != null) {
            lVar.a(i(optJSONObject9));
        }
        JSONObject optJSONObject10 = jSONObject.optJSONObject("download_conf");
        if (optJSONObject10 != null) {
            lVar.a(f(optJSONObject10));
        }
        lVar.r(jSONObject.optInt("if_both_open"));
        lVar.s(jSONObject.optInt("if_double_deeplink"));
        JSONObject optJSONObject11 = jSONObject.optJSONObject("app_manage");
        if (optJSONObject11 != null) {
            lVar.a(b(optJSONObject11));
            lVar.d(optJSONObject11.toString());
        }
        lVar.a(j(jSONObject.optJSONObject("media_ext")));
        lVar.t(jSONObject.optInt("landing_page_type"));
        JSONObject optJSONObject12 = jSONObject.optJSONObject("tpl_info");
        if (optJSONObject12 != null) {
            l.a aVar = new l.a();
            aVar.b(optJSONObject12.optString("id"));
            aVar.c(optJSONObject12.optString(PackageTable.MD5));
            aVar.d(optJSONObject12.optString("url"));
            aVar.e(optJSONObject12.optString("data"));
            aVar.f(optJSONObject12.optString("diff_data"));
            aVar.g(optJSONObject12.optString("dynamic_creative"));
            aVar.a(optJSONObject12.optString("version"));
            lVar.a(aVar);
        }
        JSONObject optJSONObject13 = jSONObject.optJSONObject("middle_tpl_info");
        if (optJSONObject13 != null) {
            l.a aVar2 = new l.a();
            aVar2.b(optJSONObject13.optString("middle_id"));
            aVar2.c(optJSONObject13.optString("middle_md5"));
            aVar2.d(optJSONObject13.optString("middle_url"));
            aVar2.e(optJSONObject13.optString("middle_data"));
            aVar2.f(optJSONObject13.optString("middle_diff_data"));
            aVar2.g(optJSONObject13.optString("middle_dynamic_creative"));
            aVar2.a(optJSONObject13.optString("middle_version"));
            lVar.b(aVar2);
        }
        lVar.d(jSONObject.optInt("if_block_lp", 0));
        lVar.l(jSONObject.optInt("cache_sort", 1));
        lVar.m(jSONObject.optInt("if_sp_cache", 0));
        JSONObject optJSONObject14 = jSONObject.optJSONObject("splash_control");
        if (optJSONObject14 != null) {
            lVar.a(g(optJSONObject14));
        }
        return lVar;
    }

    public static AdSlot c(JSONObject jSONObject) {
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

    public static FilterWord d(JSONObject jSONObject) {
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
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    FilterWord d2 = d(optJSONArray.optJSONObject(i2));
                    if (d2 != null && d2.isValid()) {
                        filterWord.addOption(d2);
                    }
                }
            }
            return filterWord;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.b e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.b bVar = new com.bytedance.sdk.openadsdk.core.d.b();
        bVar.c(jSONObject.optString("app_name"));
        bVar.d(jSONObject.optString("package_name"));
        bVar.b(jSONObject.optString("download_url"));
        bVar.a(jSONObject.optInt("score", 4));
        bVar.b(jSONObject.optInt("comment_num", 6870));
        bVar.c(jSONObject.optInt("app_size", 0));
        bVar.a(jSONObject.optString("quick_app_url", ""));
        return bVar;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.h f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.h hVar = new com.bytedance.sdk.openadsdk.core.d.h();
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

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.q g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.q qVar = new com.bytedance.sdk.openadsdk.core.d.q();
        qVar.a(jSONObject.optInt("splash_clickarea", 1));
        qVar.a(jSONObject.optString("splash_clicktext", ""));
        qVar.b(jSONObject.optInt("area_height", 50));
        qVar.c(jSONObject.optInt("area_width", 236));
        qVar.d(jSONObject.optInt("area_blank_height", 82));
        qVar.e(jSONObject.optInt("half_blank_height", 56));
        return qVar;
    }

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.g h(JSONObject jSONObject) {
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
    public static com.bytedance.sdk.openadsdk.core.d.v i(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.d.v vVar = new com.bytedance.sdk.openadsdk.core.d.v();
        vVar.b(jSONObject.optInt("cover_height"));
        vVar.c(jSONObject.optInt("cover_width"));
        vVar.a(jSONObject.optString("resolution"));
        vVar.a(jSONObject.optLong("size"));
        vVar.a(jSONObject.optDouble(AdWebVideoActivityConfig.KEY_VIDEO_DURATION));
        vVar.b(jSONObject.optString("cover_url"));
        vVar.c(jSONObject.optString("video_url"));
        vVar.d(jSONObject.optString("endcard"));
        vVar.e(jSONObject.optString("playable_download_url"));
        vVar.f(jSONObject.optString("file_hash"));
        vVar.d(jSONObject.optInt("if_playable_loading_show", 0));
        vVar.e(jSONObject.optInt("remove_loading_page_type", 0));
        vVar.a(jSONObject.optInt("fallback_endcard_judge", 0));
        return vVar;
    }

    public static Map<String, Object> j(JSONObject jSONObject) {
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

    @Nullable
    public static com.bytedance.sdk.openadsdk.core.d.l a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return b(jSONObject, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x006f, code lost:
        if (r0 != 16) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        boolean z = lVar != null;
        if (TextUtils.isEmpty(lVar.am()) || lVar.am().length() <= 1 || !a(lVar.ao())) {
            return false;
        }
        int Z = lVar.Z();
        if (Z == 2 || Z == 3 ? TextUtils.isEmpty(lVar.ac()) : !(Z == 4 ? a(lVar.an()) : Z != 5 || !TextUtils.isEmpty(lVar.ag()))) {
            z = false;
        }
        if (z) {
            int aq = lVar.aq();
            if (aq != 2 && aq != 3 && aq != 4) {
                if (aq == 5 || aq == 15) {
                    if (!a(lVar.X())) {
                        return false;
                    }
                }
                return z;
            }
            if (!a(lVar.af())) {
                return false;
            }
            return z;
        }
        return z;
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.d.g gVar) {
        if (gVar == null) {
            return true;
        }
        if (TextUtils.isEmpty(gVar.a()) || TextUtils.isEmpty(gVar.b())) {
            return false;
        }
        return gVar.c() == 1 || gVar.c() == 2;
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.d.v vVar) {
        return (vVar == null || TextUtils.isEmpty(vVar.i()) || TextUtils.isEmpty(vVar.h())) ? false : true;
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.d.b bVar) {
        return (bVar == null || TextUtils.isEmpty(bVar.b())) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(List<com.bytedance.sdk.openadsdk.core.d.k> list) {
        if (list != null && list.size() > 0) {
            for (com.bytedance.sdk.openadsdk.core.d.k kVar : list) {
                if (kVar == null || TextUtils.isEmpty(kVar.a())) {
                    return false;
                }
                while (r2.hasNext()) {
                }
            }
            return true;
        }
        return false;
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
}

package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.kwai.video.player.KsMediaMeta;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f5772a = {"ab_version", "device_brand", KsMediaMeta.KSM_KEY_LANGUAGE, "os_api", "resolution", "google_aid", "build_serial", "carrier", "install_id", "package", "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f5773b = {"ab_version", "device_brand", KsMediaMeta.KSM_KEY_LANGUAGE, "os_api", "resolution", "google_aid", "build_serial", "carrier", "iid", "app_name", SharedPrefConfig.VERSION_NAME, HttpConstants.DEVICE_TYPE, "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    public static String a(Context context, JSONObject jSONObject, String str, boolean z, f fVar) {
        HashMap<String, String> hO;
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap(f5772a.length + 10);
            for (int i = 0; i < f5772a.length; i++) {
                String optString = jSONObject.optString(f5772a[i], null);
                if (!TextUtils.isEmpty(optString)) {
                    hashMap.put(f5773b[i], optString);
                }
            }
            if (fVar != null) {
                try {
                    hO = fVar.hO(context);
                } catch (Exception e) {
                    au.a(e);
                }
            } else {
                hO = null;
            }
            if (av.b(context) && hO != null) {
                hashMap.putAll(hO);
            }
            try {
                HashMap<String, String> eld = b.ekS() == null ? null : b.ekS().eld();
                if (eld != null) {
                    hashMap.putAll(eld);
                }
            } catch (Exception e2) {
                au.a(e2);
            }
            if (b.pca.size() > 0) {
                hashMap.putAll(b.pca);
            }
            if (z) {
                hashMap.put("ssmix", "a");
            }
            String b2 = ar.b(context);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("ac", b2);
            }
            String str2 = (String) b.C("tweaked_channel", "");
            if (TextUtils.isEmpty(str2)) {
                str2 = (String) b.C("channel", "");
            }
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("channel", str2);
            }
            String optString2 = jSONObject.optString("os_version", null);
            if (optString2 != null && optString2.length() > 10) {
                optString2 = optString2.substring(0, 10);
            }
            hashMap.put("os_version", optString2);
            hashMap.put("_rticket", String.valueOf(System.currentTimeMillis()));
            hashMap.put("device_platform", HttpConstants.OS_TYPE_VALUE);
            int intValue = ((Integer) b.C("version_code", -1)).intValue();
            if (intValue != -1) {
                hashMap.put("version_code", String.valueOf(intValue));
            }
            int intValue2 = ((Integer) b.C("manifest_version_code", -1)).intValue();
            if (intValue2 != -1) {
                hashMap.put("manifest_version_code", String.valueOf(intValue2));
            }
            int intValue3 = ((Integer) b.C("update_version_code", -1)).intValue();
            if (intValue3 != -1) {
                hashMap.put("update_version_code", String.valueOf(intValue3));
            }
            String a2 = ba.a(jSONObject.optJSONObject("oaid"));
            if (!TextUtils.isEmpty(a2)) {
                hashMap.put("oaid", a2);
            }
            String optString3 = jSONObject.optString("cdid");
            if (!TextUtils.isEmpty(optString3)) {
                hashMap.put("cdid", optString3);
            }
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            return av.a(str + (str.indexOf(63) < 0 ? '?' : '&'), hashMap, "UTF-8");
        }
        return str;
    }

    public static String[] m(Context context, JSONObject jSONObject) {
        String str;
        String[] strArr = new String[aa.elx().elK().length];
        if (b.ekX()) {
            str = "/service/2/app_log/?tt_data=a";
        } else {
            str = "/service/2/app_log/?";
        }
        for (int i = 0; i < aa.elx().elK().length; i++) {
            strArr[i] = a(context, jSONObject, aa.elx().elK()[i] + str, true, b.ekT());
            strArr[i] = aa.a(strArr[i], aa.f5771b);
        }
        return strArr;
    }

    public static String n(Context context, JSONObject jSONObject) {
        String str;
        if (b.ekX()) {
            str = "/service/2/app_log/?tt_data=a";
        } else {
            str = "/service/2/app_log/?";
        }
        return a(context, jSONObject, aa.elx().elL() + str, true, b.ekT());
    }
}

package com.bytedance.embedapplog;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.kwai.video.player.KsMediaMeta;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ab {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f5774a = {"ab_version", "device_brand", KsMediaMeta.KSM_KEY_LANGUAGE, "os_api", "resolution", "google_aid", "build_serial", "carrier", "install_id", "package", "app_version", "device_model", "udid", "density_dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f5775b = {"ab_version", "device_brand", KsMediaMeta.KSM_KEY_LANGUAGE, "os_api", "resolution", "google_aid", "build_serial", "carrier", "iid", "app_name", SharedPrefConfig.VERSION_NAME, HttpConstants.DEVICE_TYPE, "uuid", "dpi", "aliyun_uuid", "mcc_mnc", "sim_region", "ab_client", "ab_group", "ab_feature", "device_id", "openudid", "clientudid", "aid"};

    public static String a(Context context, JSONObject jSONObject, String str, boolean z, f fVar) {
        HashMap<String, String> hR;
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap(f5774a.length + 10);
            for (int i = 0; i < f5774a.length; i++) {
                String optString = jSONObject.optString(f5774a[i], null);
                if (!TextUtils.isEmpty(optString)) {
                    hashMap.put(f5775b[i], optString);
                }
            }
            if (fVar != null) {
                try {
                    hR = fVar.hR(context);
                } catch (Exception e) {
                    au.a(e);
                }
            } else {
                hR = null;
            }
            if (av.b(context) && hR != null) {
                hashMap.putAll(hR);
            }
            try {
                HashMap<String, String> enw = b.enl() == null ? null : b.enl().enw();
                if (enw != null) {
                    hashMap.putAll(enw);
                }
            } catch (Exception e2) {
                au.a(e2);
            }
            if (b.pmq.size() > 0) {
                hashMap.putAll(b.pmq);
            }
            if (z) {
                hashMap.put("ssmix", "a");
            }
            String b2 = ar.b(context);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("ac", b2);
            }
            String str2 = (String) b.B("tweaked_channel", "");
            if (TextUtils.isEmpty(str2)) {
                str2 = (String) b.B("channel", "");
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
            int intValue = ((Integer) b.B("version_code", -1)).intValue();
            if (intValue != -1) {
                hashMap.put("version_code", String.valueOf(intValue));
            }
            int intValue2 = ((Integer) b.B("manifest_version_code", -1)).intValue();
            if (intValue2 != -1) {
                hashMap.put("manifest_version_code", String.valueOf(intValue2));
            }
            int intValue3 = ((Integer) b.B("update_version_code", -1)).intValue();
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
        String[] strArr = new String[aa.enQ().eod().length];
        if (b.enq()) {
            str = "/service/2/app_log/?tt_data=a";
        } else {
            str = "/service/2/app_log/?";
        }
        for (int i = 0; i < aa.enQ().eod().length; i++) {
            strArr[i] = a(context, jSONObject, aa.enQ().eod()[i] + str, true, b.enm());
            strArr[i] = aa.a(strArr[i], aa.f5773b);
        }
        return strArr;
    }

    public static String n(Context context, JSONObject jSONObject) {
        String str;
        if (b.enq()) {
            str = "/service/2/app_log/?tt_data=a";
        } else {
            str = "/service/2/app_log/?";
        }
        return a(context, jSONObject, aa.enQ().eoe() + str, true, b.enm());
    }
}

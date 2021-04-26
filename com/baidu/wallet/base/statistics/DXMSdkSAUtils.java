package com.baidu.wallet.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.beans.BeanConstants;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.UAFilterUtil;
import dxm.sasdk.DxmSdkSensorsDataAPI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class DXMSdkSAUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String f24107a = "DXMSdkSAUtils";

    /* renamed from: b  reason: collision with root package name */
    public static final String f24108b = "https://bi-sensors.duxiaoman.com/sa?project=production";

    /* renamed from: c  reason: collision with root package name */
    public static final DxmSdkSensorsDataAPI.DebugMode f24109c = DxmSdkSensorsDataAPI.DebugMode.DEBUG_OFF;

    /* renamed from: d  reason: collision with root package name */
    public static final String f24110d = "DXMSDK";

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            a a2 = a.a();
            jSONObject.put("UserAgent", UAFilterUtil.getInstance().getTrueUA(context));
            jSONObject.put("cuid", PhoneUtils.getCUID(context));
            jSONObject.put("cuid2", PhoneUtils.getCUID2(context));
            jSONObject.put("op", a2.d(context));
            jSONObject.put("sdk_version", BeanConstants.VERSION_NO);
            jSONObject.put("channel_id", BeanConstants.CHANNEL_ID);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        LogUtil.d(f24107a, "commonParams = " + jSONObject.toString());
        return jSONObject;
    }

    public static void initSensorStat(Context context) {
        LogUtil.d(f24107a, "initSensorStat");
        DxmSdkSensorsDataAPI.J(context, f24108b, f24109c);
        onChangeProperties(a(context));
    }

    public static void onChangeProperties(JSONObject jSONObject) {
        try {
            DxmSdkSensorsDataAPI.H().E(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void onEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        onEventWithValues(str, Arrays.asList(""));
    }

    public static void onEventEnd(String str, int i2) {
        LogUtil.d(f24107a, "onEventEnd. id = " + str + " , retCode = " + i2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        refreshUnionIDProperty();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_key", str);
            jSONObject.put("value0", String.valueOf(i2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        DxmSdkSensorsDataAPI.H().O(f24110d, jSONObject);
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        LogUtil.d(f24107a, "onEventEndWithValues. id = " + str + " , retCode = " + i2 + " , values = " + collection);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (collection == null) {
            collection = new ArrayList<>();
        }
        collection.add(String.valueOf(i2));
        onEventWithValues(str, collection);
    }

    public static void onEventStart(String str) {
        LogUtil.d(f24107a, "onEventStart. id = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        refreshUnionIDProperty();
        DxmSdkSensorsDataAPI.H().P(str);
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        LogUtil.d(f24107a, "onEventWithValues. id = " + str + ", values = " + collection);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_key", str);
            JSONArray jSONArray = new JSONArray((Collection) collection);
            if (jSONArray.length() > 0) {
                jSONObject.put("value0", jSONArray.get(0));
            }
            if (jSONArray.length() > 1) {
                jSONObject.put("value1", jSONArray.get(1));
            }
            if (jSONArray.length() > 2) {
                jSONObject.put("value2", jSONArray.get(2));
            }
            if (jSONArray.length() > 3) {
                jSONObject.put("value3", jSONArray.get(3));
            }
            if (jSONArray.length() > 4) {
                jSONObject.put("value4", jSONArray.get(4));
            }
            if (jSONArray.length() > 5) {
                jSONObject.put("value5", jSONArray.get(5));
            }
            if (jSONArray.length() > 6) {
                jSONObject.put("value6", jSONArray.get(6));
            }
            if (jSONArray.length() > 7) {
                jSONObject.put("value7", jSONArray.get(7));
            }
            if (jSONArray.length() > 8) {
                jSONObject.put("value8", jSONArray.get(8));
            }
            refreshUnionIDProperty();
            DxmSdkSensorsDataAPI.H().M(f24110d, jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void refreshUnionIDProperty() {
        String unionId = WalletLoginHelper.getInstance().getUnionId();
        LogUtil.d(f24107a, "refreshUnionIDProperty union_id = " + unionId);
        if (!TextUtils.isEmpty(unionId)) {
            DxmSdkSensorsDataAPI.H().C(unionId);
        } else {
            DxmSdkSensorsDataAPI.H().D();
        }
    }
}

package com.baidu.ubc;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.io.GZIP;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.webkit.internal.ETAG;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public abstract class a implements u {
    private static final boolean DEBUG = AppConfig.isDebug();
    protected ad neN = new ad();

    public abstract ab a(String str, byte[] bArr, Map<String, String> map) throws IOException;

    @Override // com.baidu.ubc.u
    public boolean i(JSONObject jSONObject, boolean z) {
        return a("https://tcbox.baidu.com", jSONObject, z);
    }

    public boolean a(String str, JSONObject jSONObject, boolean z) {
        String str2;
        boolean dMk = this.neN.dMk();
        if (dMk) {
            str2 = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc";
        } else {
            str2 = str + "/ztbox?action=zubc";
        }
        String processUrl = com.baidu.d.b.b.uy().processUrl(str2);
        if (dMk && !TextUtils.isEmpty(processUrl)) {
            processUrl = UrlUtil.addParam(processUrl, ETAG.KEY_DEBUG, "1");
        }
        if (z) {
            processUrl = UrlUtil.addParam(processUrl, "reallog", "1");
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("Content-type", "application/x-www-form-urlencoded");
        hashMap.put("nb", "1");
        try {
            byte[] gZip = GZIP.gZip(jSONObject.toString().getBytes());
            if (gZip.length < 2) {
                return false;
            }
            gZip[0] = 117;
            gZip[1] = 123;
            ab a = a(processUrl, gZip, hashMap);
            if (!a.isSuccessful()) {
                if (DEBUG) {
                    Log.d("UploadManager", "postByteRequest, fail: " + a.getMessage());
                }
                a.close();
                return false;
            }
            try {
                int i = new JSONObject(a.getBody()).getInt(BdStatsConstant.StatsType.ERROR);
                if (i != 0) {
                    if (DEBUG) {
                        Log.d("UploadManager", "server error");
                    }
                    if (!DEBUG) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            String ee = ee(jSONObject);
                            jSONObject2.put("type", "sendFail");
                            jSONObject2.put("error_no", i);
                            if (!TextUtils.isEmpty(ee)) {
                                jSONObject2.put("md5", ee);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        UBC.onEvent(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject2.toString());
                    }
                }
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.d("UploadManager", "body tostring fail:" + e2.getMessage());
                }
            }
            a.close();
            return true;
        } catch (Exception e3) {
            if (DEBUG) {
                Log.d("UploadManager", "postByteRequest, Exception: ", e3);
            }
            return false;
        }
    }

    protected String ee(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("metadata")) {
            return "";
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
            if (jSONObject2 == null || !jSONObject2.has("md5")) {
                return "";
            }
            return jSONObject2.getString("md5");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}

package com.baidu.ubc;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.io.GZIP;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import com.baidu.webkit.internal.ETAG;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a implements u {
    private static final boolean DEBUG = AppConfig.isDebug();
    protected af oUH = new af();

    public abstract ad a(String str, byte[] bArr, Map<String, String> map) throws IOException;

    @Override // com.baidu.ubc.u
    public boolean i(JSONObject jSONObject, boolean z) {
        return a(BaseContentUploader.ONLINE_URL, jSONObject, z);
    }

    public boolean a(String str, JSONObject jSONObject, boolean z) {
        String str2;
        boolean eie = this.oUH.eie();
        if (eie) {
            str2 = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc";
        } else {
            str2 = str + "/ztbox?action=zubc";
        }
        String processUrl = com.baidu.d.c.b.ug().processUrl(str2);
        if (eie && !TextUtils.isEmpty(processUrl)) {
            processUrl = UrlUtil.addParam(processUrl, ETAG.KEY_DEBUG, "1");
        }
        if (z) {
            processUrl = UrlUtil.addParam(processUrl, "reallog", "1");
        }
        if (g.ehN().isBeta()) {
            processUrl = UrlUtil.addParam(processUrl, "beta", "1");
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
            ad a2 = a(processUrl, gZip, hashMap);
            if (!a2.isSuccessful()) {
                if (DEBUG) {
                    Log.d("UploadManager", "postByteRequest, fail: " + a2.getMessage());
                } else {
                    ac.eif().he(a2.getMessage(), null);
                }
                a2.close();
                return false;
            }
            try {
                int i = new JSONObject(a2.getBody()).getInt(BdStatsConstant.StatsType.ERROR);
                if (i != 0) {
                    if (DEBUG) {
                        Log.d("UploadManager", "server error");
                    }
                    if (!DEBUG) {
                        ac.eif().Nq(i);
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    Log.d("UploadManager", "body tostring fail:" + e.getMessage());
                } else {
                    ac.eif().XM(Log.getStackTraceString(e));
                }
            }
            a2.close();
            return true;
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("UploadManager", "postByteRequest, Exception: ", e2);
            } else {
                ac.eif().he(null, Log.getStackTraceString(e2));
            }
            return false;
        }
    }
}

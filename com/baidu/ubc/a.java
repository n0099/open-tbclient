package com.baidu.ubc;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.io.GZIP;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.BaseContentUploader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class a implements u {
    private static final boolean DEBUG = AppConfig.isDebug();
    protected af oSC = new af();

    public abstract ad a(String str, byte[] bArr, Map<String, String> map) throws IOException;

    @Override // com.baidu.ubc.u
    public boolean k(JSONObject jSONObject, boolean z) {
        return b(BaseContentUploader.ONLINE_URL, jSONObject, z);
    }

    public boolean b(String str, JSONObject jSONObject, boolean z) {
        String str2;
        boolean ehW = this.oSC.ehW();
        if (ehW) {
            str2 = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc";
        } else {
            str2 = str + "/ztbox?action=zubc";
        }
        String processUrl = com.baidu.d.c.b.ug().processUrl(str2);
        if (ehW && !TextUtils.isEmpty(processUrl)) {
            processUrl = UrlUtil.addParam(processUrl, "debug", "1");
        }
        if (z) {
            processUrl = UrlUtil.addParam(processUrl, "reallog", "1");
        }
        if (g.ehF().isBeta()) {
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
                    ac.ehX().he(a2.getMessage(), null);
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
                        ac.ehX().Nm(i);
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    Log.d("UploadManager", "body tostring fail:" + e.getMessage());
                } else {
                    ac.ehX().XF(Log.getStackTraceString(e));
                }
            }
            a2.close();
            return true;
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d("UploadManager", "postByteRequest, Exception: ", e2);
            } else {
                ac.ehX().he(null, Log.getStackTraceString(e2));
            }
            return false;
        }
    }
}

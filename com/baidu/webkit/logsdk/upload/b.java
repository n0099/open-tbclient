package com.baidu.webkit.logsdk.upload;

import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    public String a;
    public ConcurrentHashMap<Long, a> b = new ConcurrentHashMap<>();

    public static JSONObject a(a aVar, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("version", "1");
            jSONObject.putOpt(ExtraParamsManager.PARAM_LOG_TYPE, aVar.e.a);
            jSONObject.putOpt("file", Boolean.valueOf(aVar.c));
            jSONObject.putOpt("upload_time", Long.valueOf(j));
            jSONObject.putOpt(DownloadDataConstants.Columns.COLUMN_RETRY_COUNT, Integer.valueOf(aVar.b));
            jSONObject.putOpt("f2", aVar.f);
            com.baidu.webkit.logsdk.a.b.a().e();
            jSONObject.putOpt("f1", com.baidu.webkit.logsdk.b.b.e());
            jSONObject.putOpt("f3", com.baidu.webkit.logsdk.b.b.g());
            jSONObject.putOpt("log_level", Integer.valueOf(aVar.e.b));
            String str = aVar.i;
            String a = (TextUtils.isEmpty(str) || "null".equals(str)) ? "full".equals(aVar.e.e) ? com.baidu.webkit.logsdk.a.b.a().g().a(com.baidu.webkit.logsdk.a.b.d()) : com.baidu.webkit.logsdk.a.b.a().g().b(com.baidu.webkit.logsdk.a.b.d(), aVar.e.e) : aVar.i;
            if (!TextUtils.isEmpty(a)) {
                jSONObject.putOpt("base_info", Integer.toString(aVar.b));
                aVar.i = a;
            }
            jSONObject.putOpt("content", aVar.a);
        } catch (Throwable th) {
            com.baidu.webkit.logsdk.d.c.a(th);
        }
        return jSONObject;
    }

    public static void b(a aVar) {
        if (aVar.e.b == 1) {
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "real: content", com.baidu.webkit.logsdk.d.c.a(aVar.a, aVar.f));
        }
        if (aVar.e.b == 2) {
            try {
                JSONArray jSONArray = new JSONArray(aVar.a);
                for (int i = 0; i < jSONArray.length(); i++) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "short: content", com.baidu.webkit.logsdk.d.c.a(jSONArray.getString(i), aVar.f));
                }
            } catch (Exception e) {
                com.a.a.a.a.a.a.a.a(e);
            }
        }
        if (aVar.e.b == 3) {
            try {
                JSONObject jSONObject = new JSONObject(aVar.a);
                JSONObject jSONObject2 = jSONObject.getJSONObject("user");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "long: keyId=" + next);
                    JSONArray jSONArray2 = jSONObject2.getJSONArray(next);
                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "long: content=" + com.baidu.webkit.logsdk.d.c.a(jSONArray2.getString(i2), next));
                    }
                }
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "long: static", com.baidu.webkit.logsdk.d.c.a(jSONObject.getString("static"), aVar.f));
            } catch (Exception e2) {
                com.a.a.a.a.a.a.a.a(e2);
            }
        }
        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "baseinfo", com.baidu.webkit.logsdk.d.c.a(aVar.i, aVar.f));
    }

    public final String a(com.baidu.webkit.logsdk.b.a aVar) {
        String a;
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            if ("full".equals(aVar.e)) {
                com.baidu.webkit.logsdk.a.b a2 = com.baidu.webkit.logsdk.a.b.a();
                a = a2.g().a(a2.d, this.a);
                str = aVar.a;
            } else {
                a = com.baidu.webkit.logsdk.a.b.a().a(this.a, aVar.e);
                str = aVar.e;
            }
            if (!TextUtils.isEmpty(a)) {
                sb.append(a);
                if (sb.indexOf("?") < 0) {
                    sb.append("?");
                } else {
                    sb.append(ETAG.ITEM_SEPARATOR);
                }
            }
            String encode = URLEncoder.encode(str, "UTF-8");
            if (TextUtils.isEmpty(encode)) {
                sb.append("lt=").append(str);
            } else {
                sb.append("lt=").append(encode);
            }
        } catch (Exception e) {
            com.baidu.webkit.logsdk.d.c.a(e);
        }
        return sb.toString();
    }

    public final void a(long j) {
        if (j > 0) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "mNetTasks remove " + j);
            this.b.remove(Long.valueOf(j));
        }
    }

    public final void a(a aVar) {
        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "onUploadFailed", null);
        if (this.b.containsValue(aVar)) {
            com.baidu.webkit.logsdk.a.b.a().a(aVar, System.currentTimeMillis(), true);
        } else {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "onUploadFailed aTask not exists");
        }
    }

    public final boolean a() {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "isNetTaskAllComplete = " + this.b.isEmpty());
        try {
            if (com.baidu.webkit.logsdk.a.a && !this.b.isEmpty()) {
                Iterator<Map.Entry<Long, a>> it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "inComplete NetTask = " + it.next());
                }
            }
        } catch (ConcurrentModificationException e) {
            com.baidu.webkit.logsdk.d.c.a(e);
        }
        return this.b.isEmpty();
    }
}

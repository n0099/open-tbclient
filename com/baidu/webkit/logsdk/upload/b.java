package com.baidu.webkit.logsdk.upload;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.webkit.internal.ETAG;
import java.net.URLEncoder;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes19.dex */
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
                e.printStackTrace();
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
                e2.printStackTrace();
            }
        }
        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "baseinfo", com.baidu.webkit.logsdk.d.c.a(aVar.i, aVar.f));
    }

    public final String a(com.baidu.webkit.logsdk.b.a aVar) {
        String str;
        String str2;
        if ("full".equals(aVar.e)) {
            com.baidu.webkit.logsdk.a.b a = com.baidu.webkit.logsdk.a.b.a();
            str = a.g().a(a.d, this.a);
            str2 = aVar.a;
        } else {
            com.baidu.webkit.logsdk.a.b a2 = com.baidu.webkit.logsdk.a.b.a();
            str = this.a;
            String str3 = aVar.e;
            if ("full".equals(str3)) {
                str = a2.g().a(a2.d, str);
            } else {
                com.baidu.webkit.logsdk.a.a g = a2.g();
                Context context = a2.d;
                com.baidu.webkit.logsdk.b.c c = com.baidu.webkit.logsdk.a.b.a().e().c(str3);
                if ("full".equals(c.a)) {
                    str = g.a(context, str);
                } else {
                    HashSet<String> hashSet = c.b;
                    if (hashSet != null) {
                        String str4 = "";
                        String str5 = "";
                        String str6 = "";
                        StringBuilder sb = new StringBuilder(str);
                        if (!hashSet.isEmpty() && str.indexOf("?") < 0) {
                            sb.append("?");
                        }
                        com.baidu.webkit.logsdk.b c2 = com.baidu.webkit.logsdk.a.b.a().c();
                        Iterator<String> it = hashSet.iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            String a3 = g.a(next, context, c2);
                            if (j.c.equals(next)) {
                                str4 = a3;
                            } else if ("cuid".equals(next)) {
                                str5 = a3;
                            } else if ("uid".equals(next)) {
                                str6 = a3;
                            }
                            if (TextUtils.isEmpty(a3)) {
                                int a4 = g.a(next, context);
                                if (a4 > 0) {
                                    sb.append(ETAG.ITEM_SEPARATOR).append(next).append(ETAG.EQUAL).append(a4);
                                }
                            } else {
                                sb.append(ETAG.ITEM_SEPARATOR).append(next).append(ETAG.EQUAL).append(a3);
                            }
                        }
                        String str7 = TextUtils.isEmpty(str4) ? "" : "" + j.c;
                        if (!TextUtils.isEmpty(str5)) {
                            if (!TextUtils.isEmpty(str4)) {
                                str7 = str7 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS;
                            }
                            str7 = str7 + "cuid";
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            if (!TextUtils.isEmpty(str5) || !TextUtils.isEmpty(str4)) {
                                str7 = str7 + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS;
                            }
                            str7 = str7 + "uid";
                        }
                        if (!TextUtils.isEmpty(str7)) {
                            sb.append("&cen=").append(str7);
                        }
                        str = sb.toString();
                    }
                }
            }
            str2 = aVar.e;
        }
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            if (sb2.indexOf("?") < 0) {
                sb2.append("?");
            } else {
                sb2.append(ETAG.ITEM_SEPARATOR);
            }
        }
        try {
            String encode = URLEncoder.encode(str2, "UTF-8");
            if (TextUtils.isEmpty(encode)) {
                sb2.append("lt=").append(str2);
            } else {
                sb2.append("lt=").append(encode);
            }
        } catch (Exception e) {
            com.baidu.webkit.logsdk.d.c.a(e);
        }
        return sb2.toString();
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

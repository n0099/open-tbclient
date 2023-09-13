package com.baidu.webkit.logsdk.upload;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.baidu.webkit.logsdk.d.c;
import java.net.URLEncoder;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class b {
    public String a;
    public ConcurrentHashMap<Long, a> b = new ConcurrentHashMap<>();

    public static JSONObject a(a aVar, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("version", "1");
            jSONObject.putOpt("log_type", aVar.e.a);
            jSONObject.putOpt("file", Boolean.valueOf(aVar.c));
            jSONObject.putOpt("upload_time", Long.valueOf(j));
            jSONObject.putOpt("retry_count", Integer.valueOf(aVar.b));
            jSONObject.putOpt("f2", aVar.f);
            com.baidu.webkit.logsdk.a.b.a().e();
            jSONObject.putOpt("f1", com.baidu.webkit.logsdk.b.b.e());
            jSONObject.putOpt("f3", com.baidu.webkit.logsdk.b.b.g());
            jSONObject.putOpt(CyberCfgManager.KEY_INT_LOG_LEVEL, Integer.valueOf(aVar.e.b));
            String str = aVar.i;
            String a = (TextUtils.isEmpty(str) || StringUtil.NULL_STRING.equals(str)) ? "full".equals(aVar.e.e) ? com.baidu.webkit.logsdk.a.b.a().g().a(com.baidu.webkit.logsdk.a.b.d()) : com.baidu.webkit.logsdk.a.b.a().g().b(com.baidu.webkit.logsdk.a.b.d(), aVar.e.e) : aVar.i;
            if (!TextUtils.isEmpty(a)) {
                jSONObject.putOpt("base_info", Integer.toString(aVar.b));
                aVar.i = a;
            }
            jSONObject.putOpt("content", aVar.a);
        } catch (Throwable th) {
            c.a(th);
        }
        return jSONObject;
    }

    public final String a(com.baidu.webkit.logsdk.b.a aVar) {
        String str;
        String str2;
        if ("full".equals(aVar.e)) {
            com.baidu.webkit.logsdk.a.b a = com.baidu.webkit.logsdk.a.b.a();
            str = a.g().a(a.c, this.a);
            str2 = aVar.a;
        } else {
            com.baidu.webkit.logsdk.a.b a2 = com.baidu.webkit.logsdk.a.b.a();
            String str3 = this.a;
            String str4 = aVar.e;
            if ("full".equals(str4)) {
                str = a2.g().a(a2.c, str3);
            } else {
                com.baidu.webkit.logsdk.a.a g = a2.g();
                Context context = a2.c;
                com.baidu.webkit.logsdk.b.c d = com.baidu.webkit.logsdk.a.b.a().e().d(str4);
                if ("full".equals(d.a)) {
                    str = g.a(context, str3);
                } else {
                    HashSet<String> hashSet = d.b;
                    if (hashSet != null) {
                        StringBuilder sb = new StringBuilder(str3);
                        if (!hashSet.isEmpty() && str3.indexOf("?") < 0) {
                            sb.append("?");
                        }
                        com.baidu.webkit.logsdk.b c = com.baidu.webkit.logsdk.a.b.a().c();
                        Iterator<String> it = hashSet.iterator();
                        String str5 = "";
                        String str6 = "";
                        String str7 = str6;
                        String str8 = str7;
                        while (it.hasNext()) {
                            String next = it.next();
                            Iterator<String> it2 = it;
                            String a3 = g.a(next, context, c);
                            if ("ua".equals(next)) {
                                str6 = a3;
                            } else if ("cuid".equals(next)) {
                                str7 = a3;
                            } else if ("uid".equals(next)) {
                                str8 = a3;
                            }
                            if (TextUtils.isEmpty(a3)) {
                                int a4 = g.a(next, context);
                                if (a4 > 0) {
                                    sb.append("&");
                                    sb.append(next);
                                    sb.append("=");
                                    sb.append(a4);
                                }
                            } else {
                                sb.append("&");
                                sb.append(next);
                                sb.append("=");
                                sb.append(a3);
                            }
                            it = it2;
                        }
                        if (!TextUtils.isEmpty(str6)) {
                            str5 = "ua";
                        }
                        if (!TextUtils.isEmpty(str7)) {
                            if (!TextUtils.isEmpty(str6)) {
                                str5 = str5 + "_";
                            }
                            str5 = str5 + "cuid";
                        }
                        if (!TextUtils.isEmpty(str8)) {
                            if (!TextUtils.isEmpty(str7) || !TextUtils.isEmpty(str6)) {
                                str5 = str5 + "_";
                            }
                            str5 = str5 + "uid";
                        }
                        if (!TextUtils.isEmpty(str5)) {
                            sb.append("&cen=");
                            sb.append(str5);
                        }
                        str = sb.toString();
                    } else {
                        str = str3;
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
                sb2.append("&");
            }
        }
        try {
            String encode = URLEncoder.encode(str2, "UTF-8");
            if (TextUtils.isEmpty(encode)) {
                sb2.append("lt=");
                sb2.append(str2);
            } else {
                sb2.append("lt=");
                sb2.append(encode);
            }
        } catch (Exception e) {
            c.a(e);
        }
        return sb2.toString();
    }

    public final void a(long j) {
        if (j > 0) {
            c.e("BdLogSDK", "mNetTasks remove ".concat(String.valueOf(j)));
            this.b.remove(Long.valueOf(j));
        }
    }

    public final void a(a aVar) {
        c.a("BdLogSDK", "onUploadFailed", null);
        if (this.b.containsValue(aVar)) {
            com.baidu.webkit.logsdk.a.b.a().a(aVar, System.currentTimeMillis(), true);
        } else {
            c.e("BdLogSDK", "onUploadFailed aTask not exists");
        }
    }

    public final boolean a() {
        c.e("BdLogSDK", "isNetTaskAllComplete = " + this.b.isEmpty());
        try {
            if (com.baidu.webkit.logsdk.a.a && !this.b.isEmpty()) {
                Iterator<Map.Entry<Long, a>> it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    c.e("BdLogSDK", "inComplete NetTask = " + it.next());
                }
            }
        } catch (ConcurrentModificationException e) {
            c.a(e);
        }
        return this.b.isEmpty();
    }
}

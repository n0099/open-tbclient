package com.bytedance.embedapplog;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class av {

    /* renamed from: a  reason: collision with root package name */
    private static String f5789a;

    /* renamed from: b  reason: collision with root package name */
    private static String f5790b = ":push";

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
        return (jSONObject == null || jSONObject2 == null) ? a((Object) jSONObject, (Object) jSONObject2) : jSONObject.toString().equals(jSONObject2.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
        com.bytedance.embedapplog.av.f5789a = r0.processName;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        String str = f5789a;
        if (TextUtils.isEmpty(str)) {
            try {
                int myPid = Process.myPid();
                Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            f5789a = a();
            if (au.f5788b) {
                au.a("getProcessName, " + f5789a, null);
            }
            return f5789a;
        }
        return str;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Found unreachable blocks
        	at jadx.core.dex.visitors.blocks.DominatorTree.sortBlocks(DominatorTree.java:35)
        	at jadx.core.dex.visitors.blocks.DominatorTree.compute(DominatorTree.java:25)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.computeDominators(BlockProcessor.java:202)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:45)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [75=4] */
    private static java.lang.String a() {
        /*
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L66
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L66
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L66
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L66
            r4.<init>()     // Catch: java.lang.Throwable -> L66
            java.lang.String r5 = "/proc/"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L66
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L66
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L66
            java.lang.String r5 = "/cmdline"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Throwable -> L66
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L66
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L66
            java.lang.String r4 = "iso-8859-1"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L66
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L66
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42
            r2.<init>()     // Catch: java.lang.Throwable -> L42
        L37:
            int r3 = r1.read()     // Catch: java.lang.Throwable -> L42
            if (r3 <= 0) goto L49
            char r3 = (char) r3     // Catch: java.lang.Throwable -> L42
            r2.append(r3)     // Catch: java.lang.Throwable -> L42
            goto L37
        L42:
            r2 = move-exception
        L43:
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Exception -> L5e
        L48:
            return r0
        L49:
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Exception -> L53
            goto L48
        L53:
            r1 = move-exception
            goto L48
        L55:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L58:
            if (r3 == 0) goto L5d
            r3.close()     // Catch: java.lang.Exception -> L60
        L5d:
            throw r2
        L5e:
            r1 = move-exception
            goto L48
        L60:
            r0 = move-exception
            goto L5d
        L62:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L58
        L66:
            r1 = move-exception
            r1 = r0
            goto L43
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.av.a():java.lang.String");
    }

    public static boolean b(Context context) {
        String a2 = a(context);
        return a2 != null && a2.endsWith(f5790b);
    }

    public static JSONObject e(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e) {
            au.a(e);
        }
        return jSONObject;
    }

    public static String a(String str, HashMap<String, String> hashMap, String str2) {
        StringBuilder sb = new StringBuilder(str);
        for (String str3 : hashMap.keySet()) {
            String a2 = a(str3, str2);
            String str4 = hashMap.get(str3);
            String a3 = str4 != null ? a(str4, str2) : "";
            if (sb.length() > 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(a2).append("=").append(a3);
        }
        return sb.toString();
    }

    private static String a(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}

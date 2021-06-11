package com.baidu.webkit.logsdk.c;

import android.text.TextUtils;
import com.baidu.down.utils.Constants;
import com.baidu.sapi2.SapiOptions;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f26782c;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, Boolean> f26783a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public c f26784b;

    public b(c cVar) {
        this.f26784b = cVar;
    }

    public static void b() {
        try {
            com.baidu.webkit.logsdk.a.b.a().c();
        } catch (Exception e2) {
            com.baidu.webkit.logsdk.d.c.a(e2);
        }
    }

    public static boolean b(String str) {
        com.baidu.webkit.logsdk.a.b.a().e();
        try {
            return new File(com.baidu.webkit.logsdk.d.c.b(com.baidu.webkit.logsdk.d.c.c(str, SapiOptions.KEY_CACHE))).length() >= com.baidu.webkit.logsdk.b.b.a().getLong("filesize", Constants.TEST_SPEED_THRESHOLD_DEFAULT);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void a() {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataEventProcessor: checkLongTimeLogCanUpload");
        Iterator<String> it = this.f26783a.keySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                f26782c = true;
                return;
            }
            String next = it.next();
            if (!this.f26784b.d(com.baidu.webkit.logsdk.d.c.c(next, "upload"))) {
                HashMap<String, Boolean> hashMap = this.f26783a;
                if (!hashMap.get(next).booleanValue()) {
                    b();
                    com.baidu.webkit.logsdk.a.b.a().e();
                    long c2 = com.baidu.webkit.logsdk.b.b.c();
                    com.baidu.webkit.logsdk.a.b.a().e();
                    long b2 = com.baidu.webkit.logsdk.b.b.b(next);
                    boolean z2 = false;
                    if (b2 != 0 && System.currentTimeMillis() - b2 >= c2) {
                        com.baidu.webkit.logsdk.d.c.d(next, SapiOptions.KEY_CACHE);
                        com.baidu.webkit.logsdk.d.c.d(next, "upload");
                        com.baidu.webkit.logsdk.d.c.d(next, SevenZipUtils.FILE_NAME_TEMP);
                        long currentTimeMillis = System.currentTimeMillis();
                        com.baidu.webkit.logsdk.a.b.a().e();
                        com.baidu.webkit.logsdk.b.b.a(next, currentTimeMillis);
                    } else {
                        boolean b3 = b(next);
                        if (b3) {
                            z2 = b3;
                        } else {
                            com.baidu.webkit.logsdk.a.b.a().e();
                            long j = com.baidu.webkit.logsdk.b.b.a().getLong("timeup", 172800000L);
                            com.baidu.webkit.logsdk.a.b.a().e();
                            long b4 = com.baidu.webkit.logsdk.b.b.b(next);
                            if (b4 != 0 && System.currentTimeMillis() - b4 >= j) {
                                z2 = true;
                            }
                        }
                    }
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "canUpload: " + next + " = " + z2);
                    if (!com.baidu.webkit.logsdk.a.f26734a) {
                        z = z2;
                    }
                }
                hashMap.put(next, Boolean.valueOf(z));
            }
        }
    }

    public final void a(a aVar) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToCacheFile " + aVar.f26780a);
        try {
            String c2 = com.baidu.webkit.logsdk.d.c.c(aVar.f26780a, SapiOptions.KEY_CACHE);
            String b2 = com.baidu.webkit.logsdk.d.c.b(c2);
            File file = new File(b2);
            String a2 = file.exists() ? com.baidu.webkit.logsdk.d.c.a(file) : null;
            com.baidu.webkit.logsdk.b.a a3 = com.baidu.webkit.logsdk.a.b.a().e().a(aVar.f26780a);
            JSONObject jSONObject = !TextUtils.isEmpty(a2) ? new JSONObject(a2) : new JSONObject();
            String str = a3.f26768c;
            JSONArray jSONArray = jSONObject.has(str) ? jSONObject.getJSONArray(str) : new JSONArray();
            if (com.baidu.webkit.logsdk.a.f26735b) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "handleWriteDataToCacheFile jsonArray", jSONArray.toString());
            }
            int size = aVar.f26781b.size();
            for (int i2 = 0; i2 < size; i2++) {
                jSONArray.put(aVar.f26781b.get(i2));
            }
            jSONObject.put(a3.f26768c, jSONArray);
            if (com.baidu.webkit.logsdk.a.f26735b) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "handleWriteDataToCacheFile jsonObject", jSONObject.toString());
            }
            com.baidu.webkit.logsdk.d.c.b(b2, jSONObject.toString());
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToCacheFile writeDataToFile");
            aVar.f26781b.clear();
            c.a(a3);
            this.f26784b.b(c2);
        } catch (Exception e2) {
            com.baidu.webkit.logsdk.d.c.a(e2);
        }
    }

    public final void a(String str) {
        com.baidu.webkit.logsdk.upload.a aVar;
        try {
            File file = new File(com.baidu.webkit.logsdk.d.c.b(com.baidu.webkit.logsdk.d.c.c(str, SapiOptions.KEY_CACHE)));
            String str2 = null;
            if (file.exists()) {
                File file2 = new File(com.baidu.webkit.logsdk.d.c.b(com.baidu.webkit.logsdk.d.c.c(str, SevenZipUtils.FILE_NAME_TEMP)));
                file2.delete();
                file.renameTo(file2);
                str2 = com.baidu.webkit.logsdk.d.c.a(file2);
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "createFromCache fileData", str2);
            }
            com.baidu.webkit.logsdk.b.a a2 = com.baidu.webkit.logsdk.a.b.a().e().a(str);
            JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : new JSONObject();
            String str3 = a2.f26768c;
            JSONArray jSONArray = jSONObject.has(str3) ? jSONObject.getJSONArray(str3) : new JSONArray();
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "createFromCache jsonArray", jSONArray.toString());
            a a3 = this.f26784b.a(str);
            int size = a3.f26781b.size();
            for (int i2 = 0; i2 < size; i2++) {
                jSONArray.put(a3.f26781b.get(i2));
            }
            a3.f26781b.clear();
            com.baidu.webkit.logsdk.d.c.d(str, SevenZipUtils.FILE_NAME_TEMP);
            if (!TextUtils.isEmpty(str2) || jSONArray.length() > 0) {
                jSONObject.put(a2.f26768c, jSONArray);
                if ("frame_event".equals(str)) {
                    JSONObject jSONObject2 = new JSONObject();
                    com.baidu.webkit.logsdk.a.b.a().c();
                    jSONObject2.put("user", jSONObject);
                    aVar = new com.baidu.webkit.logsdk.upload.a(a2, jSONObject2.toString());
                } else {
                    aVar = new com.baidu.webkit.logsdk.upload.a(a2, jSONObject.toString());
                }
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "createFromCache task", aVar.f26797a);
                aVar.f26802f = a2.f26768c;
                aVar.f26803g = a2.f26769d;
                this.f26784b.a(aVar);
            }
        } catch (Exception e2) {
            com.baidu.webkit.logsdk.d.c.a(e2);
        }
    }

    public final void a(String str, boolean z) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "setCanUpload: " + str + " = " + z);
        this.f26783a.put(str, Boolean.valueOf(z));
    }
}

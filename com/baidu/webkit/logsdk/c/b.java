package com.baidu.webkit.logsdk.c;

import android.text.TextUtils;
import com.baidu.down.utils.Constants;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class b {
    private static boolean c;
    public HashMap<String, Boolean> a = new HashMap<>();
    public c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.b = cVar;
    }

    private static void b() {
        try {
            com.baidu.webkit.logsdk.a.b.a().c();
        } catch (Exception e) {
            com.baidu.webkit.logsdk.d.c.a(e);
        }
    }

    private static boolean b(String str) {
        com.baidu.webkit.logsdk.a.b.a().e();
        try {
            return new File(com.baidu.webkit.logsdk.d.c.b(com.baidu.webkit.logsdk.d.c.c(str, "cache"))).length() >= com.baidu.webkit.logsdk.b.b.a().getLong("filesize", Constants.TEST_SPEED_THRESHOLD_DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void a() {
        boolean b;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataEventProcessor: checkLongTimeLogCanUpload");
        for (String str : this.a.keySet()) {
            if (!this.b.d(com.baidu.webkit.logsdk.d.c.c(str, "upload"))) {
                HashMap<String, Boolean> hashMap = this.a;
                if (this.a.get(str).booleanValue()) {
                    b = true;
                } else {
                    b();
                    com.baidu.webkit.logsdk.a.b.a().e();
                    long c2 = com.baidu.webkit.logsdk.b.b.c();
                    com.baidu.webkit.logsdk.a.b.a().e();
                    long b2 = com.baidu.webkit.logsdk.b.b.b(str);
                    if (b2 != 0 && System.currentTimeMillis() - b2 >= c2) {
                        com.baidu.webkit.logsdk.d.c.d(str, "cache");
                        com.baidu.webkit.logsdk.d.c.d(str, "upload");
                        com.baidu.webkit.logsdk.d.c.d(str, "temp");
                        long currentTimeMillis = System.currentTimeMillis();
                        com.baidu.webkit.logsdk.a.b.a().e();
                        com.baidu.webkit.logsdk.b.b.a(str, currentTimeMillis);
                        b = false;
                    } else {
                        b = b(str);
                        if (!b) {
                            com.baidu.webkit.logsdk.a.b.a().e();
                            long j = com.baidu.webkit.logsdk.b.b.a().getLong("timeup", 172800000L);
                            com.baidu.webkit.logsdk.a.b.a().e();
                            long b3 = com.baidu.webkit.logsdk.b.b.b(str);
                            b = b3 != 0 && System.currentTimeMillis() - b3 >= j;
                        }
                    }
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "canUpload: " + str + " = " + b);
                    if (com.baidu.webkit.logsdk.a.a) {
                        b = true;
                    }
                }
                hashMap.put(str, Boolean.valueOf(b));
            }
        }
        c = true;
    }

    public final void a(a aVar) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToCacheFile " + aVar.a);
        try {
            String c2 = com.baidu.webkit.logsdk.d.c.c(aVar.a, "cache");
            String b = com.baidu.webkit.logsdk.d.c.b(c2);
            File file = new File(b);
            String a = file.exists() ? com.baidu.webkit.logsdk.d.c.a(file) : null;
            com.baidu.webkit.logsdk.b.a a2 = com.baidu.webkit.logsdk.a.b.a().e().a(aVar.a);
            JSONObject jSONObject = !TextUtils.isEmpty(a) ? new JSONObject(a) : new JSONObject();
            String str = a2.c;
            JSONArray jSONArray = jSONObject.has(str) ? jSONObject.getJSONArray(str) : new JSONArray();
            if (com.baidu.webkit.logsdk.a.b) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "handleWriteDataToCacheFile jsonArray", jSONArray.toString());
            }
            int size = aVar.b.size();
            for (int i = 0; i < size; i++) {
                jSONArray.put(aVar.b.get(i));
            }
            jSONObject.put(a2.c, jSONArray);
            if (com.baidu.webkit.logsdk.a.b) {
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "handleWriteDataToCacheFile jsonObject", jSONObject.toString());
            }
            com.baidu.webkit.logsdk.d.c.b(b, jSONObject.toString());
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "handleWriteDataToCacheFile writeDataToFile");
            aVar.b.clear();
            c.a(a2);
            this.b.b(c2);
        } catch (Exception e) {
            com.baidu.webkit.logsdk.d.c.a(e);
        }
    }

    public final void a(String str) {
        String str2;
        com.baidu.webkit.logsdk.upload.a aVar;
        try {
            File file = new File(com.baidu.webkit.logsdk.d.c.b(com.baidu.webkit.logsdk.d.c.c(str, "cache")));
            if (file.exists()) {
                File file2 = new File(com.baidu.webkit.logsdk.d.c.b(com.baidu.webkit.logsdk.d.c.c(str, "temp")));
                file2.delete();
                file.renameTo(file2);
                String a = com.baidu.webkit.logsdk.d.c.a(file2);
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "createFromCache fileData", a);
                str2 = a;
            } else {
                str2 = null;
            }
            com.baidu.webkit.logsdk.b.a a2 = com.baidu.webkit.logsdk.a.b.a().e().a(str);
            JSONObject jSONObject = !TextUtils.isEmpty(str2) ? new JSONObject(str2) : new JSONObject();
            String str3 = a2.c;
            JSONArray jSONArray = jSONObject.has(str3) ? jSONObject.getJSONArray(str3) : new JSONArray();
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "createFromCache jsonArray", jSONArray.toString());
            a a3 = this.b.a(str);
            int size = a3.b.size();
            for (int i = 0; i < size; i++) {
                jSONArray.put(a3.b.get(i));
            }
            a3.b.clear();
            com.baidu.webkit.logsdk.d.c.d(str, "temp");
            if (!TextUtils.isEmpty(str2) || jSONArray.length() > 0) {
                jSONObject.put(a2.c, jSONArray);
                if ("frame_event".equals(str)) {
                    JSONObject jSONObject2 = new JSONObject();
                    com.baidu.webkit.logsdk.a.b.a().c();
                    jSONObject2.put("user", jSONObject);
                    aVar = new com.baidu.webkit.logsdk.upload.a(a2, jSONObject2.toString());
                } else {
                    aVar = new com.baidu.webkit.logsdk.upload.a(a2, jSONObject.toString());
                }
                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "createFromCache task", aVar.a);
                aVar.f = a2.c;
                aVar.g = a2.d;
                this.b.a(aVar);
            }
        } catch (Exception e) {
            com.baidu.webkit.logsdk.d.c.a(e);
        }
    }

    public final void a(String str, boolean z) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "setCanUpload: " + str + " = " + z);
        this.a.put(str, Boolean.valueOf(z));
    }
}

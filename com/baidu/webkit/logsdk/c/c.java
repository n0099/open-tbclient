package com.baidu.webkit.logsdk.c;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sapi2.SapiOptions;
import com.baidu.webkit.logsdk.upload.BdLogNetRequest;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: e  reason: collision with root package name */
    public b f26702e;

    /* renamed from: d  reason: collision with root package name */
    public final Object f26701d = new Object();

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<com.baidu.webkit.logsdk.upload.a> f26698a = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, a> f26700c = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f26699b = new ConcurrentHashMap<>();

    public static com.baidu.webkit.logsdk.upload.a a(File file, com.baidu.webkit.logsdk.b.a aVar) {
        String a2 = com.baidu.webkit.logsdk.d.c.a(file);
        if (com.baidu.webkit.logsdk.a.f26650b) {
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "buildTaskFromFile read", a2);
        }
        String[] split = a2.split("\\r\\n");
        if (split.length == 4) {
            int i = 0;
            try {
                i = Integer.parseInt(split[0]);
            } catch (Exception e2) {
                com.baidu.webkit.logsdk.d.c.a(e2);
            }
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "buildTaskFromFile count = " + i);
            String str = split[1];
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "buildTaskFromFile keyId = " + str);
            String str2 = split[2];
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "buildTaskFromFile baseInfoEncode", str2);
            String str3 = split[3];
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "buildTaskFromFile content", str3);
            com.baidu.webkit.logsdk.upload.a aVar2 = new com.baidu.webkit.logsdk.upload.a(aVar, str3, str);
            aVar2.i = str2;
            aVar2.f26711b = i;
            return aVar2;
        }
        return null;
    }

    public static String a(String str, long j) {
        JSONObject jSONObject;
        boolean z;
        try {
            jSONObject = new JSONObject(str);
            z = true;
        } catch (Exception unused) {
            jSONObject = new JSONObject();
            z = false;
        }
        try {
            if (z) {
                jSONObject.put("log_time", j);
            } else {
                jSONObject.put("log_time", j);
                jSONObject.put("data", str);
            }
        } catch (Exception e2) {
            com.baidu.webkit.logsdk.d.c.a(e2);
        }
        if (com.baidu.webkit.logsdk.a.f26650b) {
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor new log", jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public static void a(com.baidu.webkit.logsdk.b.a aVar) {
        com.baidu.webkit.logsdk.b.b e2 = com.baidu.webkit.logsdk.a.b.a().e();
        String f2 = com.baidu.webkit.logsdk.b.b.f();
        if (f2.equals(aVar.f26681c)) {
            return;
        }
        int a2 = com.baidu.webkit.logsdk.d.c.a(f2);
        if ((a2 != 0 || TextUtils.isEmpty(com.baidu.webkit.logsdk.d.c.a(e2, f2))) && a2 != 1) {
            return;
        }
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "updateConfig = " + aVar.f26679a + " ;enType = " + a2);
        aVar.f26681c = f2;
        aVar.f26682d = com.baidu.webkit.logsdk.b.b.d();
        e2.f26687d.put(aVar.f26679a, aVar);
    }

    public static boolean e(String str) {
        try {
            long parseLong = Long.parseLong(str);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.webkit.logsdk.a.b.a().e();
            return currentTimeMillis - parseLong < com.baidu.webkit.logsdk.b.b.c();
        } catch (Exception e2) {
            com.baidu.webkit.logsdk.d.c.a(e2);
            return false;
        }
    }

    public final a a(String str) {
        if (!this.f26700c.containsKey(str)) {
            this.f26700c.put(str, new a(str));
        }
        return this.f26700c.get(str);
    }

    public final void a() {
        if (this.f26700c.isEmpty()) {
            return;
        }
        for (String str : this.f26700c.keySet()) {
            a aVar = this.f26700c.get(str);
            if (!aVar.f26694b.isEmpty()) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor destroy type = " + str);
                com.baidu.webkit.logsdk.b.a a2 = com.baidu.webkit.logsdk.a.b.a().e().a(str);
                int i = a2.f26680b;
                if (i == 2) {
                    this.f26698a.add(new com.baidu.webkit.logsdk.upload.a(a2, aVar.a()));
                    aVar.f26694b.clear();
                } else if (i == 3) {
                    c(com.baidu.webkit.logsdk.d.c.c(aVar.f26693a, SapiOptions.q));
                    this.f26702e.a(aVar);
                }
            }
        }
    }

    public final void a(int i) {
        com.baidu.webkit.logsdk.upload.a a2;
        com.baidu.webkit.logsdk.a.b.a().g();
        if (com.baidu.webkit.logsdk.a.a.c(com.baidu.webkit.logsdk.a.b.d())) {
            com.baidu.webkit.logsdk.a.b.a().e();
            i = Math.min(i, com.baidu.webkit.logsdk.b.b.b());
        } else {
            com.baidu.webkit.logsdk.a.b.a().g();
            if (!com.baidu.webkit.logsdk.a.a.b(com.baidu.webkit.logsdk.a.b.d()).equals("wifi")) {
                return;
            }
        }
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalRetryFile check " + i);
        File[] listFiles = new File(com.baidu.webkit.logsdk.d.c.a()).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.isFile()) {
                String name = file.getName();
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "LocalRetryFile: " + name);
                if (!TextUtils.isEmpty(name) && !d(name)) {
                    try {
                        byte[] decode = Base64.decode(name, 0);
                        if (decode.length > 0) {
                            String str = new String(decode);
                            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "LocalRetryFile realFileName", str);
                            String[] split = str.split("-");
                            if (split.length > 1) {
                                String str2 = split[0];
                                String str3 = split[1];
                                com.baidu.webkit.logsdk.b.a a3 = com.baidu.webkit.logsdk.a.b.a().e().a(str2);
                                int i2 = a3.f26680b;
                                if (!str3.equals(SapiOptions.q) && !str3.equals(SevenZipUtils.FILE_NAME_TEMP)) {
                                    if (str3.equals("upload")) {
                                        if (i == 3 && i2 == 3) {
                                            c().a(str2, true);
                                        }
                                    } else if (e(str3)) {
                                        if (i2 <= i && i2 > 0 && (a2 = a(file, a3)) != null) {
                                            a2.f26717h = name;
                                            c(name);
                                            this.f26698a.add(a2);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                    file.delete();
                }
            }
        }
    }

    public final void a(com.baidu.webkit.logsdk.upload.a aVar) {
        this.f26698a.add(aVar);
    }

    public final void b(String str) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "removeFileHandlingState " + str);
        synchronized (this.f26701d) {
            if (this.f26699b.containsKey(str)) {
                int intValue = this.f26699b.get(str).intValue();
                if (intValue > 1) {
                    this.f26699b.put(str, Integer.valueOf(intValue - 1));
                } else {
                    this.f26699b.remove(str);
                }
            }
        }
    }

    public final synchronized boolean b() {
        if (this.f26698a.isEmpty()) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "schedule empty");
            return false;
        }
        com.baidu.webkit.logsdk.upload.a remove = this.f26698a.remove(0);
        if (remove != null) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "schedule task");
            int i = remove.f26714e.f26680b;
            com.baidu.webkit.logsdk.a.b.a().e();
            int b2 = com.baidu.webkit.logsdk.b.b.b();
            com.baidu.webkit.logsdk.a.b.a().g();
            if (!com.baidu.webkit.logsdk.a.a.c(com.baidu.webkit.logsdk.a.b.d()) || i <= b2) {
                com.baidu.webkit.logsdk.upload.b f2 = com.baidu.webkit.logsdk.a.b.a().f();
                long currentTimeMillis = System.currentTimeMillis();
                f2.f26719b.put(Long.valueOf(currentTimeMillis), remove);
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "mNetTasks put " + currentTimeMillis);
                JSONObject a2 = com.baidu.webkit.logsdk.upload.b.a(remove, currentTimeMillis);
                remove.f26713d = currentTimeMillis;
                String a3 = f2.a(remove.f26714e);
                if (com.baidu.webkit.logsdk.a.f26650b) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "upload object", a2.toString());
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "upload url", a3);
                    com.baidu.webkit.logsdk.upload.b.b(remove);
                } else {
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "upload");
                }
                com.baidu.webkit.logsdk.upload.c cVar = new com.baidu.webkit.logsdk.upload.c(f2, remove);
                try {
                    try {
                        if (com.baidu.webkit.logsdk.a.b.a().f26662b == null) {
                            BdLogNetRequest.uploadLog(a3, a2, null, cVar);
                        }
                    } catch (Throwable unused) {
                        f2.a(remove);
                    }
                } catch (Throwable unused2) {
                }
            } else {
                com.baidu.webkit.logsdk.a.b.a().a(remove, System.currentTimeMillis(), false);
            }
        }
        return !this.f26698a.isEmpty();
    }

    public final b c() {
        if (this.f26702e == null) {
            this.f26702e = new b(this);
        }
        return this.f26702e;
    }

    public final void c(String str) {
        synchronized (this.f26701d) {
            int intValue = this.f26699b.containsKey(str) ? 1 + this.f26699b.get(str).intValue() : 1;
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addFileHandlingState " + str + "; value = " + intValue);
            this.f26699b.put(str, Integer.valueOf(intValue));
        }
    }

    public final synchronized void d() {
        File[] listFiles = new File(com.baidu.webkit.logsdk.d.c.a()).listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum num = " + length);
        if (length >= 1000) {
            Arrays.sort(listFiles, new d(this));
            int max = Math.max(length - 1000, 99);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum deleteNum " + max);
            int i = 0;
            while (i <= max) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum i = " + i);
                File file = listFiles[i];
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum lastModified = " + file.lastModified());
                String str = new String(Base64.decode(file.getName(), 0));
                String[] split = str.split("-");
                if (split.length > 1) {
                    String str2 = split[1];
                    if (str2.equals(SapiOptions.q) || str2.equals(SevenZipUtils.FILE_NAME_TEMP) || str2.equals("upload")) {
                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "checkLocalFileNum file", str);
                        i++;
                        max++;
                    }
                }
                if (file.delete()) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "checkLocalFileNum delete file", str);
                    i++;
                }
            }
        }
    }

    public final boolean d(String str) {
        boolean containsKey;
        synchronized (this.f26701d) {
            containsKey = this.f26699b.containsKey(str);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "isFileHandlingState " + str + ": " + containsKey);
        }
        return containsKey;
    }
}

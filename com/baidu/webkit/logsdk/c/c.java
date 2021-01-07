package com.baidu.webkit.logsdk.c;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.webkit.logsdk.upload.BdLogNetRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public final class c {
    private b e;
    private final Object d = new Object();

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<com.baidu.webkit.logsdk.upload.a> f6007a = new LinkedList<>();
    private ConcurrentHashMap<String, a> c = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f6008b = new ConcurrentHashMap<>();

    public static com.baidu.webkit.logsdk.upload.a a(File file, com.baidu.webkit.logsdk.b.a aVar) {
        int i = 0;
        String a2 = com.baidu.webkit.logsdk.d.c.a(file);
        if (com.baidu.webkit.logsdk.a.f5985b) {
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "buildTaskFromFile read", a2);
        }
        String[] split = a2.split("\\r\\n");
        if (split.length == 4) {
            try {
                i = Integer.parseInt(split[0]);
            } catch (Exception e) {
                com.baidu.webkit.logsdk.d.c.a(e);
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
            aVar2.f6015b = i;
            return aVar2;
        }
        return null;
    }

    public static String a(String str, long j) {
        JSONObject jSONObject;
        boolean z = false;
        try {
            jSONObject = new JSONObject(str);
            z = true;
        } catch (Exception e) {
            jSONObject = new JSONObject();
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
        if (com.baidu.webkit.logsdk.a.f5985b) {
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor new log", jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public static void a(com.baidu.webkit.logsdk.b.a aVar) {
        com.baidu.webkit.logsdk.b.b e = com.baidu.webkit.logsdk.a.b.a().e();
        String f = com.baidu.webkit.logsdk.b.b.f();
        if (f.equals(aVar.c)) {
            return;
        }
        int a2 = com.baidu.webkit.logsdk.d.c.a(f);
        if ((a2 != 0 || TextUtils.isEmpty(com.baidu.webkit.logsdk.d.c.a(e, f))) && a2 != 1) {
            return;
        }
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "updateConfig = " + aVar.f5997a + " ;enType = " + a2);
        aVar.c = f;
        aVar.d = com.baidu.webkit.logsdk.b.b.d();
        e.d.put(aVar.f5997a, aVar);
    }

    private static boolean e(String str) {
        try {
            long parseLong = Long.parseLong(str);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.webkit.logsdk.a.b.a().e();
            return currentTimeMillis - parseLong < com.baidu.webkit.logsdk.b.b.c();
        } catch (Exception e) {
            com.baidu.webkit.logsdk.d.c.a(e);
            return false;
        }
    }

    public final a a(String str) {
        if (!this.c.containsKey(str)) {
            this.c.put(str, new a(str));
        }
        return this.c.get(str);
    }

    public final void a() {
        if (this.c.isEmpty()) {
            return;
        }
        for (String str : this.c.keySet()) {
            a aVar = this.c.get(str);
            if (!aVar.f6004b.isEmpty()) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "BdLogDataProcessor destroy type = " + str);
                com.baidu.webkit.logsdk.b.a a2 = com.baidu.webkit.logsdk.a.b.a().e().a(str);
                if (a2.f5998b == 2) {
                    this.f6007a.add(new com.baidu.webkit.logsdk.upload.a(a2, aVar.a()));
                    aVar.f6004b.clear();
                } else if (a2.f5998b == 3) {
                    c(com.baidu.webkit.logsdk.d.c.c(aVar.f6003a, "cache"));
                    this.e.a(aVar);
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
                        if (decode.length <= 0) {
                            file.delete();
                        } else {
                            String str = new String(decode);
                            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "LocalRetryFile realFileName", str);
                            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                            if (split.length > 1) {
                                String str2 = split[0];
                                String str3 = split[1];
                                com.baidu.webkit.logsdk.b.a a3 = com.baidu.webkit.logsdk.a.b.a().e().a(str2);
                                int i2 = a3.f5998b;
                                if (!str3.equals("cache") && !str3.equals("temp")) {
                                    if (str3.equals("upload")) {
                                        if (i == 3 && i2 == 3) {
                                            c().a(str2, true);
                                        }
                                    } else if (!e(str3)) {
                                        file.delete();
                                    } else if (i2 <= i && i2 > 0 && (a2 = a(file, a3)) != null) {
                                        a2.h = name;
                                        c(name);
                                        this.f6007a.add(a2);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        file.delete();
                    }
                }
            }
        }
    }

    public final void a(com.baidu.webkit.logsdk.upload.a aVar) {
        this.f6007a.add(aVar);
    }

    public final void b(String str) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "removeFileHandlingState " + str);
        synchronized (this.d) {
            if (this.f6008b.containsKey(str)) {
                int intValue = this.f6008b.get(str).intValue();
                if (intValue > 1) {
                    this.f6008b.put(str, Integer.valueOf(intValue - 1));
                } else {
                    this.f6008b.remove(str);
                }
            }
        }
    }

    public final synchronized boolean b() {
        boolean z;
        if (this.f6007a.isEmpty()) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "schedule empty");
            z = false;
        } else {
            com.baidu.webkit.logsdk.upload.a remove = this.f6007a.remove(0);
            if (remove != null) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "schedule task");
                int i = remove.e.f5998b;
                com.baidu.webkit.logsdk.a.b.a().e();
                int b2 = com.baidu.webkit.logsdk.b.b.b();
                com.baidu.webkit.logsdk.a.b.a().g();
                if (!com.baidu.webkit.logsdk.a.a.c(com.baidu.webkit.logsdk.a.b.d()) || i <= b2) {
                    com.baidu.webkit.logsdk.upload.b f = com.baidu.webkit.logsdk.a.b.a().f();
                    long currentTimeMillis = System.currentTimeMillis();
                    f.f6017b.put(Long.valueOf(currentTimeMillis), remove);
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "mNetTasks put " + currentTimeMillis);
                    JSONObject a2 = com.baidu.webkit.logsdk.upload.b.a(remove, currentTimeMillis);
                    remove.d = currentTimeMillis;
                    String a3 = f.a(remove.e);
                    if (com.baidu.webkit.logsdk.a.f5985b) {
                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "upload object", a2.toString());
                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "upload url", a3);
                        com.baidu.webkit.logsdk.upload.b.b(remove);
                    } else {
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "upload");
                    }
                    com.baidu.webkit.logsdk.upload.c cVar = new com.baidu.webkit.logsdk.upload.c(f, remove);
                    try {
                        if (com.baidu.webkit.logsdk.a.b.a().f5989b == null) {
                            BdLogNetRequest.uploadLog(a3, a2, null, cVar);
                        }
                    } catch (Throwable th) {
                        try {
                            f.a(remove);
                        } catch (Throwable th2) {
                        }
                    }
                } else {
                    com.baidu.webkit.logsdk.a.b.a().a(remove, System.currentTimeMillis(), false);
                }
            }
            z = !this.f6007a.isEmpty();
        }
        return z;
    }

    public final b c() {
        if (this.e == null) {
            this.e = new b(this);
        }
        return this.e;
    }

    public final void c(String str) {
        synchronized (this.d) {
            int intValue = this.f6008b.containsKey(str) ? this.f6008b.get(str).intValue() + 1 : 1;
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addFileHandlingState " + str + "; value = " + intValue);
            this.f6008b.put(str, Integer.valueOf(intValue));
        }
    }

    public final synchronized void d() {
        int i = 0;
        synchronized (this) {
            File[] listFiles = new File(com.baidu.webkit.logsdk.d.c.a()).listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum num = " + length);
                if (length >= 1000) {
                    Arrays.sort(listFiles, new d(this));
                    int max = Math.max(length - 1000, 99);
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum deleteNum " + max);
                    while (i <= max) {
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum i = " + i);
                        File file = listFiles[i];
                        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum lastModified = " + file.lastModified());
                        String str = new String(Base64.decode(file.getName(), 0));
                        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        if (split.length > 1) {
                            String str2 = split[1];
                            if (str2.equals("cache") || str2.equals("temp") || str2.equals("upload")) {
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
        }
    }

    public final boolean d(String str) {
        boolean containsKey;
        synchronized (this.d) {
            containsKey = this.f6008b.containsKey(str);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "isFileHandlingState " + str + ": " + containsKey);
        }
        return containsKey;
    }
}

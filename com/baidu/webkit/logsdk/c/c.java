package com.baidu.webkit.logsdk.c;

import android.text.TextUtils;
import android.util.Base64;
import com.baidu.sapi2.SapiOptions;
import com.baidu.webkit.logsdk.d;
import com.baidu.webkit.logsdk.d.c;
import com.baidu.webkit.logsdk.upload.BdLogNetRequest;
import com.baidu.webkit.sdk.SevenZipUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c {

    /* renamed from: d  reason: collision with root package name */
    public b f26870d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f26871e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public LinkedList<com.baidu.webkit.logsdk.upload.a> f26867a = new LinkedList<>();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, a> f26868b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f26869c = new ConcurrentHashMap<>();

    public static com.baidu.webkit.logsdk.upload.a a(File file, com.baidu.webkit.logsdk.b.a aVar) {
        String a2 = com.baidu.webkit.logsdk.d.c.a(file);
        if (com.baidu.webkit.logsdk.a.f26817b) {
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "buildTaskFromFile read", a2);
        }
        String[] split = a2.split("\\r\\n");
        if (split.length == 4) {
            int i2 = 0;
            try {
                i2 = Integer.parseInt(split[0]);
            } catch (Exception e2) {
                com.baidu.webkit.logsdk.d.c.a(e2);
            }
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "buildTaskFromFile count = ".concat(String.valueOf(i2)));
            String str = split[1];
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "buildTaskFromFile keyId = ".concat(String.valueOf(str)));
            String str2 = split[2];
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "buildTaskFromFile baseInfoEncode", str2);
            String str3 = split[3];
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "buildTaskFromFile content", str3);
            com.baidu.webkit.logsdk.upload.a aVar2 = new com.baidu.webkit.logsdk.upload.a(aVar, str3, str);
            aVar2.f26887i = str2;
            aVar2.f26880b = i2;
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
        if (com.baidu.webkit.logsdk.a.f26817b) {
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogDataProcessor new log", jSONObject.toString());
        }
        return jSONObject.toString();
    }

    public static void a(com.baidu.webkit.logsdk.b.a aVar) {
        com.baidu.webkit.logsdk.b.b e2 = com.baidu.webkit.logsdk.a.b.a().e();
        String f2 = com.baidu.webkit.logsdk.b.b.f();
        if (f2.equals(aVar.f26850c)) {
            return;
        }
        int a2 = com.baidu.webkit.logsdk.d.c.a(f2);
        if ((a2 != 0 || TextUtils.isEmpty(com.baidu.webkit.logsdk.d.c.a(e2, f2))) && a2 != 1) {
            return;
        }
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "updateConfig = " + aVar.f26848a + " ;enType = " + a2);
        aVar.f26850c = f2;
        aVar.f26851d = com.baidu.webkit.logsdk.b.b.d();
        e2.a(aVar);
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
        if (!this.f26868b.containsKey(str)) {
            this.f26868b.put(str, new a(str));
        }
        return this.f26868b.get(str);
    }

    public final void a(int i2) {
        com.baidu.webkit.logsdk.upload.a a2;
        com.baidu.webkit.logsdk.a.b.a().g();
        if (com.baidu.webkit.logsdk.a.a.c(com.baidu.webkit.logsdk.a.b.d())) {
            com.baidu.webkit.logsdk.a.b.a().e();
            i2 = Math.min(i2, com.baidu.webkit.logsdk.b.b.b());
        } else {
            com.baidu.webkit.logsdk.a.b.a().g();
            if (!com.baidu.webkit.logsdk.a.a.b(com.baidu.webkit.logsdk.a.b.d()).equals("wifi")) {
                return;
            }
        }
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalRetryFile check ".concat(String.valueOf(i2)));
        File[] listFiles = new File(com.baidu.webkit.logsdk.d.c.a()).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.isFile()) {
                String name = file.getName();
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "LocalRetryFile: ".concat(String.valueOf(name)));
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
                                int i3 = a3.f26849b;
                                if (!str3.equals(SapiOptions.KEY_CACHE) && !str3.equals(SevenZipUtils.FILE_NAME_TEMP)) {
                                    if (str3.equals("upload")) {
                                        if (i2 == 3 && i3 == 3) {
                                            b().a(str2, true);
                                        }
                                    } else if (e(str3)) {
                                        if (i3 <= i2 && i3 > 0 && (a2 = a(file, a3)) != null) {
                                            a2.f26886h = name;
                                            c(name);
                                            this.f26867a.add(a2);
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
        this.f26867a.add(aVar);
    }

    public final synchronized boolean a() {
        if (this.f26867a.isEmpty()) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "schedule empty");
            return false;
        }
        final com.baidu.webkit.logsdk.upload.a remove = this.f26867a.remove(0);
        if (remove != null) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "schedule task");
            int i2 = remove.f26883e.f26849b;
            com.baidu.webkit.logsdk.a.b.a().e();
            int b2 = com.baidu.webkit.logsdk.b.b.b();
            com.baidu.webkit.logsdk.a.b.a().g();
            if (!com.baidu.webkit.logsdk.a.a.c(com.baidu.webkit.logsdk.a.b.d()) || i2 <= b2) {
                final com.baidu.webkit.logsdk.upload.b f2 = com.baidu.webkit.logsdk.a.b.a().f();
                long currentTimeMillis = System.currentTimeMillis();
                f2.f26889b.put(Long.valueOf(currentTimeMillis), remove);
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "mNetTasks put ".concat(String.valueOf(currentTimeMillis)));
                JSONObject a2 = com.baidu.webkit.logsdk.upload.b.a(remove, currentTimeMillis);
                remove.f26882d = currentTimeMillis;
                String a3 = f2.a(remove.f26883e);
                if (com.baidu.webkit.logsdk.a.f26817b) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "upload object", a2.toString());
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "upload url", a3);
                    if (remove.f26883e.f26849b == 1) {
                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "real: content", com.baidu.webkit.logsdk.d.c.a(remove.f26879a, remove.f26884f));
                    }
                    if (remove.f26883e.f26849b == 2) {
                        try {
                            JSONArray jSONArray = new JSONArray(remove.f26879a);
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "short: content", com.baidu.webkit.logsdk.d.c.a(jSONArray.getString(i3), remove.f26884f));
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (remove.f26883e.f26849b == 3) {
                        try {
                            JSONObject jSONObject = new JSONObject(remove.f26879a);
                            JSONObject jSONObject2 = jSONObject.getJSONObject("user");
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "long: keyId=".concat(String.valueOf(next)));
                                JSONArray jSONArray2 = jSONObject2.getJSONArray(next);
                                for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "long: content=".concat(String.valueOf(com.baidu.webkit.logsdk.d.c.a(jSONArray2.getString(i4), next))));
                                }
                            }
                            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "long: static", com.baidu.webkit.logsdk.d.c.a(jSONObject.getString("static"), remove.f26884f));
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "baseinfo", com.baidu.webkit.logsdk.d.c.a(remove.f26887i, remove.f26884f));
                } else {
                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "upload");
                }
                d dVar = new d() { // from class: com.baidu.webkit.logsdk.upload.b.1
                    @Override // com.baidu.webkit.logsdk.d
                    public final void a(byte[] bArr) {
                        if (bArr == null) {
                            b.this.a(remove);
                            return;
                        }
                        b bVar = b.this;
                        a aVar = remove;
                        c.a("BdLogSDK", "onUploadSuccess", null);
                        com.baidu.webkit.logsdk.b.a aVar2 = aVar.f26883e;
                        String str = aVar2.f26848a;
                        if (aVar2.f26849b == 3) {
                            com.baidu.webkit.logsdk.a.b.a().e();
                            com.baidu.webkit.logsdk.b.b.a(str, System.currentTimeMillis());
                            com.baidu.webkit.logsdk.a.b.a().h().b().a(str, false);
                        }
                        String str2 = aVar.f26886h;
                        if (!TextUtils.isEmpty(str2)) {
                            com.baidu.webkit.logsdk.a.b.a().h().b(str2);
                            new File(c.b(str2)).delete();
                        }
                        bVar.a(aVar.f26882d);
                        com.baidu.webkit.logsdk.a.b.a().a(0L);
                    }
                };
                try {
                    try {
                        if (com.baidu.webkit.logsdk.a.b.a().f26828a == null) {
                            BdLogNetRequest.uploadLog(a3, a2, null, dVar);
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
        return !this.f26867a.isEmpty();
    }

    public final b b() {
        if (this.f26870d == null) {
            this.f26870d = new b(this);
        }
        return this.f26870d;
    }

    public final void b(String str) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "removeFileHandlingState ".concat(String.valueOf(str)));
        synchronized (this.f26871e) {
            if (this.f26869c.containsKey(str)) {
                int intValue = this.f26869c.get(str).intValue();
                if (intValue > 1) {
                    this.f26869c.put(str, Integer.valueOf(intValue - 1));
                } else {
                    this.f26869c.remove(str);
                }
            }
        }
    }

    public final synchronized void c() {
        File[] listFiles = new File(com.baidu.webkit.logsdk.d.c.a()).listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum num = ".concat(String.valueOf(length)));
        if (length >= 1000) {
            Arrays.sort(listFiles, new Comparator<File>() { // from class: com.baidu.webkit.logsdk.c.c.1
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // java.util.Comparator
                public final /* synthetic */ int compare(File file, File file2) {
                    int i2 = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
                    if (i2 > 0) {
                        return 1;
                    }
                    return i2 == 0 ? 0 : -1;
                }
            });
            int max = Math.max(length - 1000, 99);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum deleteNum ".concat(String.valueOf(max)));
            int i2 = 0;
            while (i2 <= max) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum i = ".concat(String.valueOf(i2)));
                File file = listFiles[i2];
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum lastModified = " + file.lastModified());
                String str = new String(Base64.decode(file.getName(), 0));
                String[] split = str.split("-");
                if (split.length > 1) {
                    String str2 = split[1];
                    if (str2.equals(SapiOptions.KEY_CACHE) || str2.equals(SevenZipUtils.FILE_NAME_TEMP) || str2.equals("upload")) {
                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "checkLocalFileNum file", str);
                        i2++;
                        max++;
                    }
                }
                if (file.delete()) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "checkLocalFileNum delete file", str);
                    i2++;
                }
            }
        }
    }

    public final void c(String str) {
        synchronized (this.f26871e) {
            int intValue = this.f26869c.containsKey(str) ? 1 + this.f26869c.get(str).intValue() : 1;
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addFileHandlingState " + str + "; value = " + intValue);
            this.f26869c.put(str, Integer.valueOf(intValue));
        }
    }

    public final boolean d(String str) {
        boolean containsKey;
        synchronized (this.f26871e) {
            containsKey = this.f26869c.containsKey(str);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "isFileHandlingState " + str + ": " + containsKey);
        }
        return containsKey;
    }
}

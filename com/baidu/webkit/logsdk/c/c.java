package com.baidu.webkit.logsdk.c;

import android.text.TextUtils;
import android.util.Base64;
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
/* loaded from: classes9.dex */
public final class c {
    public b d;
    public final Object e = new Object();
    public LinkedList<com.baidu.webkit.logsdk.upload.a> a = new LinkedList<>();
    public ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, Integer> c = new ConcurrentHashMap<>();

    public static com.baidu.webkit.logsdk.upload.a a(File file, com.baidu.webkit.logsdk.b.a aVar) {
        String a = com.baidu.webkit.logsdk.d.c.a(file);
        if (com.baidu.webkit.logsdk.a.b) {
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "buildTaskFromFile read", a);
        }
        String[] split = a.split("\\r\\n");
        if (split.length == 4) {
            int i = 0;
            try {
                i = Integer.parseInt(split[0]);
            } catch (Exception e) {
                com.baidu.webkit.logsdk.d.c.a(e);
            }
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "buildTaskFromFile count = ".concat(String.valueOf(i)));
            String str = split[1];
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "buildTaskFromFile keyId = ".concat(String.valueOf(str)));
            String str2 = split[2];
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "buildTaskFromFile baseInfoEncode", str2);
            String str3 = split[3];
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "buildTaskFromFile content", str3);
            com.baidu.webkit.logsdk.upload.a aVar2 = new com.baidu.webkit.logsdk.upload.a(aVar, str3, str);
            aVar2.i = str2;
            aVar2.b = i;
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
        } catch (Exception e) {
            com.baidu.webkit.logsdk.d.c.a(e);
        }
        if (com.baidu.webkit.logsdk.a.b) {
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
        int a = com.baidu.webkit.logsdk.d.c.a(f);
        if ((a != 0 || TextUtils.isEmpty(com.baidu.webkit.logsdk.d.c.a(e, f))) && a != 1) {
            return;
        }
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "updateConfig = " + aVar.a + " ;enType = " + a);
        aVar.c = f;
        aVar.d = com.baidu.webkit.logsdk.b.b.d();
        e.a(aVar);
    }

    public static boolean e(String str) {
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
        if (!this.b.containsKey(str)) {
            this.b.put(str, new a(str));
        }
        return this.b.get(str);
    }

    public final void a(int i) {
        com.baidu.webkit.logsdk.upload.a a;
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
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalRetryFile check ".concat(String.valueOf(i)));
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
                                com.baidu.webkit.logsdk.b.a a2 = com.baidu.webkit.logsdk.a.b.a().e().a(str2);
                                int i2 = a2.b;
                                if (!str3.equals("cache") && !str3.equals(SevenZipUtils.FILE_NAME_TEMP)) {
                                    if (str3.equals("upload")) {
                                        if (i == 3 && i2 == 3) {
                                            b().a(str2, true);
                                        }
                                    } else if (e(str3)) {
                                        if (i2 <= i && i2 > 0 && (a = a(file, a2)) != null) {
                                            a.h = name;
                                            c(name);
                                            this.a.add(a);
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
        this.a.add(aVar);
    }

    public final synchronized boolean a() {
        if (this.a.isEmpty()) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "schedule empty");
            return false;
        }
        final com.baidu.webkit.logsdk.upload.a remove = this.a.remove(0);
        if (remove != null) {
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "schedule task");
            int i = remove.e.b;
            com.baidu.webkit.logsdk.a.b.a().e();
            int b = com.baidu.webkit.logsdk.b.b.b();
            com.baidu.webkit.logsdk.a.b.a().g();
            if (!com.baidu.webkit.logsdk.a.a.c(com.baidu.webkit.logsdk.a.b.d()) || i <= b) {
                final com.baidu.webkit.logsdk.upload.b f = com.baidu.webkit.logsdk.a.b.a().f();
                long currentTimeMillis = System.currentTimeMillis();
                f.b.put(Long.valueOf(currentTimeMillis), remove);
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "mNetTasks put ".concat(String.valueOf(currentTimeMillis)));
                JSONObject a = com.baidu.webkit.logsdk.upload.b.a(remove, currentTimeMillis);
                remove.d = currentTimeMillis;
                String a2 = f.a(remove.e);
                if (com.baidu.webkit.logsdk.a.b) {
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "upload object", a.toString());
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "upload url", a2);
                    if (remove.e.b == 1) {
                        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "real: content", com.baidu.webkit.logsdk.d.c.a(remove.a, remove.f));
                    }
                    if (remove.e.b == 2) {
                        try {
                            JSONArray jSONArray = new JSONArray(remove.a);
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "short: content", com.baidu.webkit.logsdk.d.c.a(jSONArray.getString(i2), remove.f));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (remove.e.b == 3) {
                        try {
                            JSONObject jSONObject = new JSONObject(remove.a);
                            JSONObject jSONObject2 = jSONObject.getJSONObject("user");
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "long: keyId=".concat(String.valueOf(next)));
                                JSONArray jSONArray2 = jSONObject2.getJSONArray(next);
                                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                    com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "long: content=".concat(String.valueOf(com.baidu.webkit.logsdk.d.c.a(jSONArray2.getString(i3), next))));
                                }
                            }
                            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "long: static", com.baidu.webkit.logsdk.d.c.a(jSONObject.getString("static"), remove.f));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "baseinfo", com.baidu.webkit.logsdk.d.c.a(remove.i, remove.f));
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
                        com.baidu.webkit.logsdk.b.a aVar2 = aVar.e;
                        String str = aVar2.a;
                        if (aVar2.b == 3) {
                            com.baidu.webkit.logsdk.a.b.a().e();
                            com.baidu.webkit.logsdk.b.b.a(str, System.currentTimeMillis());
                            com.baidu.webkit.logsdk.a.b.a().h().b().a(str, false);
                        }
                        String str2 = aVar.h;
                        if (!TextUtils.isEmpty(str2)) {
                            com.baidu.webkit.logsdk.a.b.a().h().b(str2);
                            new File(c.b(str2)).delete();
                        }
                        bVar.a(aVar.d);
                        com.baidu.webkit.logsdk.a.b.a().a(0L);
                    }
                };
                try {
                    try {
                        if (com.baidu.webkit.logsdk.a.b.a().a == null) {
                            BdLogNetRequest.uploadLog(a2, a, null, dVar);
                        }
                    } catch (Throwable unused) {
                        f.a(remove);
                    }
                } catch (Throwable unused2) {
                }
            } else {
                com.baidu.webkit.logsdk.a.b.a().a(remove, System.currentTimeMillis(), false);
            }
        }
        return !this.a.isEmpty();
    }

    public final b b() {
        if (this.d == null) {
            this.d = new b(this);
        }
        return this.d;
    }

    public final void b(String str) {
        com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "removeFileHandlingState ".concat(String.valueOf(str)));
        synchronized (this.e) {
            if (this.c.containsKey(str)) {
                int intValue = this.c.get(str).intValue();
                if (intValue > 1) {
                    this.c.put(str, Integer.valueOf(intValue - 1));
                } else {
                    this.c.remove(str);
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
                    int i = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
                    if (i > 0) {
                        return 1;
                    }
                    return i == 0 ? 0 : -1;
                }
            });
            int max = Math.max(length - 1000, 99);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum deleteNum ".concat(String.valueOf(max)));
            int i = 0;
            while (i <= max) {
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum i = ".concat(String.valueOf(i)));
                File file = listFiles[i];
                com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "checkLocalFileNum lastModified = " + file.lastModified());
                String str = new String(Base64.decode(file.getName(), 0));
                String[] split = str.split("-");
                if (split.length > 1) {
                    String str2 = split[1];
                    if (str2.equals("cache") || str2.equals(SevenZipUtils.FILE_NAME_TEMP) || str2.equals("upload")) {
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

    public final void c(String str) {
        synchronized (this.e) {
            int intValue = this.c.containsKey(str) ? 1 + this.c.get(str).intValue() : 1;
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "addFileHandlingState " + str + "; value = " + intValue);
            this.c.put(str, Integer.valueOf(intValue));
        }
    }

    public final boolean d(String str) {
        boolean containsKey;
        synchronized (this.e) {
            containsKey = this.c.containsKey(str);
            com.baidu.webkit.logsdk.d.c.e("BdLogSDK", "isFileHandlingState " + str + ": " + containsKey);
        }
        return containsKey;
    }
}

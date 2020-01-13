package com.baidu.webkit.internal.daemon;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.baidu.webkit.internal.ConectivityUtils;
import com.baidu.webkit.internal.d;
import com.baidubce.http.Headers;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes10.dex */
public final class b implements Runnable {
    private byte[] a = null;
    private Context b;
    private String c;

    /* loaded from: classes10.dex */
    private class a implements d.c {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }

        @Override // com.baidu.webkit.internal.d.c
        public final boolean a() {
            Log.d("siteinfo", "FSO DownloadListener onConnShutdown.");
            try {
                if (b.this.a != null) {
                    File file = new File(b.this.c + "/site_info_t7_60.txt");
                    String str = new String(Base64.decode(new String(b.this.a, "utf-8").getBytes(), 0));
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.close();
                    Log.d("siteinfo", "FSO init site info success.");
                    b.this.a = null;
                    return true;
                }
                return true;
            } catch (Throwable th) {
                Log.e("siteinfo", "parse data error:", th);
                return true;
            }
        }

        @Override // com.baidu.webkit.internal.d.c
        public final boolean a(int i) {
            Log.d("siteinfo", "FSO DownloadListener onResponseCode:" + i);
            return i == 200 || d.a(i);
        }

        @Override // com.baidu.webkit.internal.d.c
        public final boolean a(byte[] bArr, int i) {
            Log.d("siteinfo", "FSO DownloadListener onReceivedData.");
            if (b.this.a == null) {
                b.this.a = new byte[0];
            }
            byte[] bArr2 = new byte[b.this.a.length + i];
            System.arraycopy(b.this.a, 0, bArr2, 0, b.this.a.length);
            System.arraycopy(bArr, 0, bArr2, b.this.a.length, i);
            b.this.a = bArr2;
            return true;
        }
    }

    private b(Context context) {
        this.b = null;
        this.c = null;
        this.b = context;
        this.c = context.getFilesDir().getAbsolutePath();
    }

    public static void a(Context context) {
        if (ConectivityUtils.getNetType(context) == "unknown") {
            return;
        }
        try {
            com.baidu.webkit.internal.daemon.a.a(new b(context));
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Log.d("siteinfo", "FSO updateSiteInfo rules: https://browserkernel.baidu.com/siteinfo/site_info_t7_60.txt");
            d dVar = new d(this.b, "https://browserkernel.baidu.com/siteinfo/site_info_t7_60.txt", new a(this, (byte) 0));
            dVar.a(Headers.CACHE_CONTROL, "max-age=0");
            File file = new File(this.c + "/site_info_t7_60.txt");
            if (file.exists()) {
                Date date = new Date(file.lastModified());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                String format = simpleDateFormat.format(date);
                String substring = format.endsWith("+00:00") ? format.substring(0, format.length() - 6) : format;
                dVar.a("If-Modified-Since", substring);
                Log.d("siteinfo", "FSO updateSiteInfo lastmodified = " + format + ", modified = " + substring);
            }
            dVar.a = 5000;
            dVar.b = 10000;
            dVar.a();
        } catch (Exception e) {
            Log.e("siteinfo", "update failed");
        }
    }
}

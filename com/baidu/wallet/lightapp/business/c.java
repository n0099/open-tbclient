package com.baidu.wallet.lightapp.business;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.wallet.analytics.Tracker;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.VerSig;
import com.baidu.wallet.lightapp.base.statistics.LightAppStatEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes5.dex */
public final class c {

    /* loaded from: classes5.dex */
    public interface a {
        void a(String[] strArr);
    }

    /* loaded from: classes5.dex */
    public static class b extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        public final HttpURLConnection f24812a;

        public b(HttpURLConnection httpURLConnection) {
            super(c.b(httpURLConnection));
            this.f24812a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            this.f24812a.disconnect();
        }
    }

    public static String[] c(String str, String[] strArr, Context context) throws IOException {
        LogUtil.i("WebViewCacheManager", "START: load cache");
        return a(str, strArr, context, true, false);
    }

    public static String[] d(String str, String[] strArr, Context context) throws IOException {
        LogUtil.i("WebViewCacheManager", "START: load network");
        return a(str, strArr, context, false, true);
    }

    public static String b(String str) {
        String name = new File(URI.create(str).getPath()).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf > 0 ? name.substring(0, lastIndexOf) : name;
    }

    public static boolean b(CharSequence[] charSequenceArr) {
        if (charSequenceArr == null) {
            return true;
        }
        for (CharSequence charSequence : charSequenceArr) {
            if (!TextUtils.isEmpty(charSequence)) {
                return false;
            }
        }
        return true;
    }

    public static void a(final String str, final Context context, final String[] strArr, final a aVar) {
        new Thread() { // from class: com.baidu.wallet.lightapp.business.c.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                LogUtil.i("WebViewCacheManager", "ZipFileLoader load: " + str);
                String[] strArr2 = new String[0];
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    strArr2 = c.c(str, strArr, context);
                    LogUtil.i("WebViewCacheManager", "END: cache duration: " + (SystemClock.uptimeMillis() - uptimeMillis));
                } catch (IOException e2) {
                    LogUtil.e("WebViewCacheManager", "EXCEPTION on load from cache", e2);
                    Tracker.send(LightAppStatEvent.OFFLINECACHE_DOWNLOAD_JSHOOK_FILE_FAILED, Arrays.asList(str, "EXCEPTION on load from cache", e2.toString()), context);
                }
                if (c.b(strArr2)) {
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    try {
                        String str2 = str;
                        String[] strArr3 = strArr;
                        Context context2 = context;
                        strArr2 = c.b(str2, strArr3, context2, c.b(str) + File.separatorChar);
                        LogUtil.i("WebViewCacheManager", "END: local duration: " + (SystemClock.uptimeMillis() - uptimeMillis2));
                    } catch (IOException e3) {
                        LogUtil.e("WebViewCacheManager", "EXCEPTION on load from local", e3);
                        if (!(e3 instanceof FileNotFoundException)) {
                            Tracker.send(LightAppStatEvent.OFFLINECACHE_DOWNLOAD_JSHOOK_FILE_FAILED, Arrays.asList(str, "EXCEPTION on load from local", e3.toString()), context);
                        }
                    }
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(strArr2);
                        LogUtil.i("WebViewCacheManager", "RESULT: load from local, is empty: " + c.b(strArr2));
                    }
                    try {
                        long uptimeMillis3 = SystemClock.uptimeMillis();
                        c.d(str, strArr, context);
                        LogUtil.i("WebViewCacheManager", "END: network duration: " + (SystemClock.uptimeMillis() - uptimeMillis3));
                        return;
                    } catch (IOException e4) {
                        LogUtil.e("WebViewCacheManager", "EXCEPTION on load from network", e4);
                        Tracker.send(LightAppStatEvent.OFFLINECACHE_DOWNLOAD_JSHOOK_FILE_FAILED, Arrays.asList(str, "EXCEPTION on load from network", e4.toString()), context);
                        return;
                    }
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(strArr2);
                    LogUtil.i("WebViewCacheManager", "RESULT: load from cache, is empty: " + c.b(strArr2));
                }
            }
        }.start();
    }

    public static String[] b(String str, String[] strArr, Context context, String str2) throws IOException {
        if (strArr == null) {
            return new String[0];
        }
        String[] strArr2 = new String[strArr.length];
        LogUtil.i("WebViewCacheManager", "START: load local");
        String str3 = null;
        boolean z = false;
        for (int i = 0; i < strArr.length; i++) {
            byte[] a2 = a(context.getAssets().open(str2 + strArr[i] + ".sig"), true);
            byte[] a3 = a(context.getAssets().open(str2 + strArr[i]), true);
            if (VerSig.verify(a2, a3, "SHA-1")) {
                strArr2[i] = new String(a3);
                LogUtil.i("WebViewCacheManager", strArr[i] + " verify passed");
            } else {
                LogUtil.i("WebViewCacheManager", strArr[i] + " verify failed");
                str3 = TextUtils.isEmpty(str3) ? strArr[i] : str3 + StringUtil.ARRAY_ELEMENT_SEPARATOR + strArr[i];
                z = true;
            }
        }
        if (z) {
            String[] strArr3 = new String[0];
            a(str3, str, context);
            return strArr3;
        }
        return strArr2;
    }

    public static void a(String str, String str2, Context context) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("url", str2);
        linkedHashMap.put(com.baidu.fsg.face.base.b.c.f5592g, str);
        Tracker.send(LightAppStatEvent.JS_FILE_VERIFY_FAILED, linkedHashMap, context);
    }

    public static byte[] a(InputStream inputStream, boolean z) throws IOException {
        if (inputStream != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } finally {
                    if (z) {
                        inputStream.close();
                    }
                    byteArrayOutputStream.close();
                }
            }
            return byteArrayOutputStream.toByteArray();
        }
        throw new IOException("The input stream is null!");
    }

    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    public static String[] a(String str, String[] strArr, Context context, boolean z, boolean z2) throws IOException {
        int indexOf;
        if (strArr == null) {
            return new String[0];
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        ZipInputStream zipInputStream = null;
        String str2 = null;
        r4 = null;
        ZipInputStream zipInputStream2 = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setUseCaches(true);
            a(z, z2, httpURLConnection);
            LogUtil.i("WebViewCacheManager", "status code: " + httpURLConnection.getResponseCode() + ", msg: " + httpURLConnection.getResponseMessage());
            List asList = Arrays.asList(strArr);
            String[] strArr3 = new String[strArr.length];
            if (httpURLConnection.getResponseCode() == 200) {
                ZipInputStream zipInputStream3 = new ZipInputStream(new b(httpURLConnection));
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream3.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String name = nextEntry.getName();
                        int indexOf2 = asList.indexOf(name);
                        if (indexOf2 >= 0) {
                            strArr2[indexOf2] = new String(a(zipInputStream3, false));
                        }
                        if (name.endsWith(".sig") && (indexOf = asList.indexOf(name.substring(0, name.length() - 4))) >= 0) {
                            strArr3[indexOf] = new String(a(zipInputStream3, false));
                        }
                    } catch (Throwable th) {
                        th = th;
                        zipInputStream = zipInputStream3;
                        if (zipInputStream != null) {
                            zipInputStream.close();
                        }
                        throw th;
                    }
                }
                boolean z3 = false;
                for (int i = 0; i < length; i++) {
                    if (VerSig.verify(strArr3[i], strArr2[i], "SHA-1")) {
                        LogUtil.i("WebViewCacheManager", strArr[i] + " verify passed");
                    } else {
                        LogUtil.i("WebViewCacheManager", strArr[i] + " verify failed");
                        str2 = TextUtils.isEmpty(str2) ? strArr[i] : str2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + strArr[i];
                        z3 = true;
                    }
                }
                if (z3) {
                    String[] strArr4 = new String[0];
                    a(str2, str, context);
                    strArr2 = strArr4;
                }
                zipInputStream2 = zipInputStream3;
            } else if (!z) {
                Tracker.send(LightAppStatEvent.OFFLINECACHE_DOWNLOAD_JSHOOK_FILE_FAILED, Arrays.asList(str, httpURLConnection.getResponseMessage(), String.valueOf(httpURLConnection.getResponseCode())), context);
            }
            if (zipInputStream2 != null) {
                zipInputStream2.close();
            }
            return strArr2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(boolean z, boolean z2, HttpURLConnection httpURLConnection) {
        if (z && z2) {
            return;
        }
        if (z) {
            httpURLConnection.addRequestProperty("Cache-Control", "only-if-cached");
            httpURLConnection.addRequestProperty("Cache-Control", "max-stale=31536000");
        }
        if (z2) {
            httpURLConnection.addRequestProperty("Cache-Control", "no-cache");
        }
    }
}

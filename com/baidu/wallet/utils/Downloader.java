package com.baidu.wallet.utils;

import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class Downloader {

    /* renamed from: f  reason: collision with root package name */
    public static final int f26613f = 1;

    /* renamed from: a  reason: collision with root package name */
    public DownloadManager f26614a;

    /* renamed from: b  reason: collision with root package name */
    public final Pattern f26615b;

    /* renamed from: c  reason: collision with root package name */
    public final Pattern f26616c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f26617d;

    /* renamed from: e  reason: collision with root package name */
    public ContentResolver f26618e;

    /* renamed from: g  reason: collision with root package name */
    public final String f26619g;

    /* loaded from: classes5.dex */
    public interface DownloaderListener {
        void onProgress(String str, int i2, long j, long j2);
    }

    /* loaded from: classes5.dex */
    public final class a extends ContentObserver {

        /* renamed from: b  reason: collision with root package name */
        public long f26622b;

        /* renamed from: c  reason: collision with root package name */
        public DownloaderListener f26623c;

        /* renamed from: d  reason: collision with root package name */
        public String f26624d;

        /* renamed from: e  reason: collision with root package name */
        public final int f26625e;

        public a(Handler handler, String str, long j, DownloaderListener downloaderListener) {
            super(handler);
            this.f26625e = 24;
            this.f26624d = str;
            this.f26622b = j;
            this.f26623c = downloaderListener;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
            r11.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
            return;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0083  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(long j) {
            Cursor cursor;
            Cursor cursor2 = null;
            try {
                cursor = Downloader.this.f26614a.query(new DownloadManager.Query().setFilterById(j));
            } catch (Exception unused) {
                cursor = null;
            } catch (Throwable th) {
                th = th;
                if (cursor2 != null) {
                }
                throw th;
            }
            if (cursor != null) {
                try {
                    try {
                    } catch (Exception unused2) {
                        this.f26623c = null;
                        Downloader.this.f26618e.unregisterContentObserver(this);
                        if (cursor == null) {
                            return;
                        }
                        cursor.close();
                    }
                    if (cursor.getCount() != 0 && cursor.moveToFirst()) {
                        int columnIndexOrThrow = cursor.getColumnIndexOrThrow(PackageTable.TOTAL_SIZE);
                        int columnIndexOrThrow2 = cursor.getColumnIndexOrThrow("bytes_so_far");
                        int columnIndex = cursor.getColumnIndex("status");
                        long j2 = cursor.getLong(columnIndexOrThrow);
                        long j3 = cursor.getLong(columnIndexOrThrow2);
                        int i2 = cursor.getInt(columnIndex);
                        if (this.f26623c != null) {
                            this.f26623c.onProgress(this.f26624d, i2, j2, j3);
                        }
                        if ((i2 & 24) != 0) {
                            this.f26623c = null;
                            Downloader.this.f26618e.unregisterContentObserver(this);
                        }
                        if (cursor == null) {
                            return;
                        }
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            a(this.f26622b);
        }
    }

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public String f26626a;

        /* renamed from: b  reason: collision with root package name */
        public DownloaderListener f26627b;

        /* renamed from: c  reason: collision with root package name */
        public String f26628c;

        public b() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static Downloader f26630a = new Downloader();
    }

    public static Downloader getInstance() {
        return c.f26630a;
    }

    public void download(String str, String str2, DownloaderListener downloaderListener) {
        if (str != null ? this.f26616c.matcher(str).matches() : false) {
            b bVar = new b();
            bVar.f26626a = str;
            bVar.f26627b = downloaderListener;
            bVar.f26628c = str2;
            this.f26617d.obtainMessage(1, bVar).sendToTarget();
            return;
        }
        a(downloaderListener, str);
    }

    public void init(Context context) {
        if (this.f26614a != null || context == null) {
            return;
        }
        this.f26614a = (DownloadManager) context.getSystemService("download");
        this.f26618e = context.getContentResolver();
        HandlerThread handlerThread = new HandlerThread("downloader");
        handlerThread.start();
        this.f26617d = new Handler(handlerThread.getLooper()) { // from class: com.baidu.wallet.utils.Downloader.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (1 == message.what) {
                    b bVar = (b) message.obj;
                    if (Downloader.this.f26614a == null) {
                        Downloader.this.a(bVar.f26627b, bVar.f26626a);
                    } else {
                        Downloader.this.a(bVar.f26626a, bVar.f26627b, bVar.f26628c);
                    }
                }
            }
        };
    }

    public Downloader() {
        this.f26615b = Pattern.compile(".*\\/(.*)");
        this.f26616c = Pattern.compile("^(https?)://.*");
        this.f26619g = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    private String b(String str) {
        String str2 = str.startsWith(this.f26619g) ? null : this.f26619g;
        File parentFile = new File(str2, str).getParentFile();
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            return str2 == null ? str.substring(this.f26619g.length()) : str;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, DownloaderListener downloaderListener, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = a(str);
        }
        if (str2 == null) {
            a(downloaderListener, str);
            return;
        }
        String b2 = b(str2);
        if (b2 == null) {
            a(downloaderListener, str);
            return;
        }
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setNotificationVisibility(2);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, b2);
            request.setAllowedNetworkTypes(2);
            long enqueue = this.f26614a.enqueue(request);
            a aVar = new a(this.f26617d, str, enqueue, downloaderListener);
            this.f26618e.registerContentObserver(Uri.parse("content://downloads/my_downloads/" + enqueue), true, aVar);
        } catch (Exception e2) {
            a(downloaderListener, str);
            PayStatisticsUtil.onEventWithValue("WRC_downloadFail", str);
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloaderListener downloaderListener, String str) {
        if (downloaderListener != null) {
            downloaderListener.onProgress(str, 16, 0L, 0L);
        }
    }

    private String a(String str) {
        Matcher matcher = this.f26615b.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }
}

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
    public static final int f26521f = 1;

    /* renamed from: a  reason: collision with root package name */
    public DownloadManager f26522a;

    /* renamed from: b  reason: collision with root package name */
    public final Pattern f26523b;

    /* renamed from: c  reason: collision with root package name */
    public final Pattern f26524c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f26525d;

    /* renamed from: e  reason: collision with root package name */
    public ContentResolver f26526e;

    /* renamed from: g  reason: collision with root package name */
    public final String f26527g;

    /* loaded from: classes5.dex */
    public interface DownloaderListener {
        void onProgress(String str, int i, long j, long j2);
    }

    /* loaded from: classes5.dex */
    public final class a extends ContentObserver {

        /* renamed from: b  reason: collision with root package name */
        public long f26530b;

        /* renamed from: c  reason: collision with root package name */
        public DownloaderListener f26531c;

        /* renamed from: d  reason: collision with root package name */
        public String f26532d;

        /* renamed from: e  reason: collision with root package name */
        public final int f26533e;

        public a(Handler handler, String str, long j, DownloaderListener downloaderListener) {
            super(handler);
            this.f26533e = 24;
            this.f26532d = str;
            this.f26530b = j;
            this.f26531c = downloaderListener;
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
                cursor = Downloader.this.f26522a.query(new DownloadManager.Query().setFilterById(j));
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
                        this.f26531c = null;
                        Downloader.this.f26526e.unregisterContentObserver(this);
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
                        int i = cursor.getInt(columnIndex);
                        if (this.f26531c != null) {
                            this.f26531c.onProgress(this.f26532d, i, j2, j3);
                        }
                        if ((i & 24) != 0) {
                            this.f26531c = null;
                            Downloader.this.f26526e.unregisterContentObserver(this);
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
            a(this.f26530b);
        }
    }

    /* loaded from: classes5.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        public String f26534a;

        /* renamed from: b  reason: collision with root package name */
        public DownloaderListener f26535b;

        /* renamed from: c  reason: collision with root package name */
        public String f26536c;

        public b() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static Downloader f26538a = new Downloader();
    }

    public static Downloader getInstance() {
        return c.f26538a;
    }

    public void download(String str, String str2, DownloaderListener downloaderListener) {
        if (str != null ? this.f26524c.matcher(str).matches() : false) {
            b bVar = new b();
            bVar.f26534a = str;
            bVar.f26535b = downloaderListener;
            bVar.f26536c = str2;
            this.f26525d.obtainMessage(1, bVar).sendToTarget();
            return;
        }
        a(downloaderListener, str);
    }

    public void init(Context context) {
        if (this.f26522a != null || context == null) {
            return;
        }
        this.f26522a = (DownloadManager) context.getSystemService("download");
        this.f26526e = context.getContentResolver();
        HandlerThread handlerThread = new HandlerThread("downloader");
        handlerThread.start();
        this.f26525d = new Handler(handlerThread.getLooper()) { // from class: com.baidu.wallet.utils.Downloader.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (1 == message.what) {
                    b bVar = (b) message.obj;
                    if (Downloader.this.f26522a == null) {
                        Downloader.this.a(bVar.f26535b, bVar.f26534a);
                    } else {
                        Downloader.this.a(bVar.f26534a, bVar.f26535b, bVar.f26536c);
                    }
                }
            }
        };
    }

    public Downloader() {
        this.f26523b = Pattern.compile(".*\\/(.*)");
        this.f26524c = Pattern.compile("^(https?)://.*");
        this.f26527g = Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DOWNLOADS + File.separator;
    }

    private String b(String str) {
        String str2 = str.startsWith(this.f26527g) ? null : this.f26527g;
        File parentFile = new File(str2, str).getParentFile();
        parentFile.mkdirs();
        if (parentFile.isDirectory()) {
            return str2 == null ? str.substring(this.f26527g.length()) : str;
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
            long enqueue = this.f26522a.enqueue(request);
            a aVar = new a(this.f26525d, str, enqueue, downloaderListener);
            this.f26526e.registerContentObserver(Uri.parse("content://downloads/my_downloads/" + enqueue), true, aVar);
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
        Matcher matcher = this.f26523b.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }
}

package com.baidu.zeus;

import android.os.Process;
import android.os.SystemClock;
import org.apache.http.HttpHost;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class IdleCache {
    private static final int CHECK_INTERVAL = 2000;
    private static final int EMPTY_CHECK_MAX = 5;
    private static final int IDLE_CACHE_MAX = 8;
    private static final int TIMEOUT = 6000;
    private Entry[] mEntries = new Entry[8];
    private int mCount = 0;
    private IdleReaper mThread = null;
    private int mCached = 0;
    private int mReused = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Entry {
        Connection mConnection;
        HttpHost mHost;
        long mTimeout;

        Entry() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IdleCache() {
        for (int i = 0; i < 8; i++) {
            this.mEntries[i] = new Entry();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
        r4.mHost = r8;
        r4.mConnection = r9;
        r4.mTimeout = 6000 + r2;
        r7.mCount++;
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r7.mThread != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        r7.mThread = new com.baidu.zeus.IdleCache.IdleReaper(r7, null);
        r7.mThread.start();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean cacheConnection(HttpHost httpHost, Connection connection) {
        boolean z = false;
        synchronized (this) {
            if (this.mCount < 8) {
                long uptimeMillis = SystemClock.uptimeMillis();
                int i = 0;
                while (true) {
                    if (i >= 8) {
                        break;
                    }
                    Entry entry = this.mEntries[i];
                    if (entry.mHost == null) {
                        break;
                    }
                    i++;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
        r0 = r2.mConnection;
        r2.mHost = null;
        r2.mConnection = null;
        r4.mCount--;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Connection getConnection(HttpHost httpHost) {
        Connection connection = null;
        synchronized (this) {
            if (this.mCount > 0) {
                int i = 0;
                while (true) {
                    if (i < 8) {
                        Entry entry = this.mEntries[i];
                        HttpHost httpHost2 = entry.mHost;
                        if (httpHost2 != null && httpHost2.equals(httpHost)) {
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
        return connection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void clear() {
        for (int i = 0; this.mCount > 0 && i < 8; i++) {
            Entry entry = this.mEntries[i];
            if (entry.mHost != null) {
                entry.mHost = null;
                entry.mConnection.closeConnection();
                entry.mConnection = null;
                this.mCount--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void clearIdle() {
        if (this.mCount > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i = 0; i < 8; i++) {
                Entry entry = this.mEntries[i];
                if (entry.mHost != null && uptimeMillis > entry.mTimeout) {
                    entry.mHost = null;
                    entry.mConnection.closeConnection();
                    entry.mConnection = null;
                    this.mCount--;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class IdleReaper extends Thread {
        private IdleReaper() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("IdleReaper");
            Process.setThreadPriority(10);
            synchronized (IdleCache.this) {
                int i = 0;
                while (i < 5) {
                    try {
                        IdleCache.this.wait(2000L);
                    } catch (InterruptedException e) {
                    }
                    if (IdleCache.this.mCount != 0) {
                        IdleCache.this.clearIdle();
                        i = 0;
                    } else {
                        i++;
                    }
                }
                IdleCache.this.mThread = null;
            }
        }
    }
}

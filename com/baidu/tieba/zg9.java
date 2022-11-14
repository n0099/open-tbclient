package com.baidu.tieba;

import com.baidu.ugc.download.exception.DownloadException;
/* loaded from: classes6.dex */
public interface zg9 extends Runnable {

    /* loaded from: classes6.dex */
    public interface a {
        void b(DownloadException downloadException);

        void onConnectCanceled();

        void onConnectPaused();

        void onConnected(long j, long j2, boolean z);

        void onConnecting();
    }

    void cancel();

    boolean isCanceled();

    boolean isPaused();

    void pause();
}

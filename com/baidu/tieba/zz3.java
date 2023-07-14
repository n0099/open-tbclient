package com.baidu.tieba;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.tieba.qz3;
/* loaded from: classes8.dex */
public interface zz3 {
    void a(DownloadInfo downloadInfo);

    void b(DownloadInfo downloadInfo);

    void c(DownloadInfo downloadInfo);

    void d(DownloadInfo downloadInfo);

    void destroy();

    void f(@NonNull String str, @NonNull Uri uri, @NonNull qz3.d<Boolean> dVar);

    DownloadInfo g(String str);
}

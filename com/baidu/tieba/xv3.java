package com.baidu.tieba;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.baidu.swan.game.ad.downloader.model.DownloadInfo;
import com.baidu.tieba.ov3;
/* loaded from: classes7.dex */
public interface xv3 {
    void a(DownloadInfo downloadInfo);

    void b(DownloadInfo downloadInfo);

    void c(DownloadInfo downloadInfo);

    void d(DownloadInfo downloadInfo);

    void destroy();

    void f(@NonNull String str, @NonNull Uri uri, @NonNull ov3.d<Boolean> dVar);

    DownloadInfo g(String str);
}

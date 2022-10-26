package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
/* loaded from: classes5.dex */
public interface sr3 {
    void a(String str);

    void b(DownloadState downloadState);

    sr3 c(Context context, DownloadParams downloadParams, nr3 nr3Var);

    void d(int i);

    void e(Object obj);

    void f();

    View getRealView();
}

package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
/* loaded from: classes5.dex */
public interface ps3<VIEW extends View> {
    void a(String str);

    void b(DownloadState downloadState);

    ps3 c(Context context, DownloadParams downloadParams, ks3 ks3Var);

    void d(int i);

    void e(Object obj);

    void f();

    VIEW getRealView();
}

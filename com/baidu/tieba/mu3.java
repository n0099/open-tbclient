package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
/* loaded from: classes7.dex */
public interface mu3<VIEW extends View> {
    void a(String str);

    void b(DownloadState downloadState);

    mu3 c(Context context, DownloadParams downloadParams, hu3 hu3Var);

    void d(int i);

    void e(Object obj);

    void f();

    VIEW getRealView();
}

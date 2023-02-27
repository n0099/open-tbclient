package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
/* loaded from: classes6.dex */
public interface sx3<VIEW extends View> {
    void a(String str);

    void b(DownloadState downloadState);

    sx3 c(Context context, DownloadParams downloadParams, nx3 nx3Var);

    void d(int i);

    void e(Object obj);

    void f();

    VIEW getRealView();
}

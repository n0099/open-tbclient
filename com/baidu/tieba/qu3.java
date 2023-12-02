package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
/* loaded from: classes7.dex */
public interface qu3<VIEW extends View> {
    void a(String str);

    void b(DownloadState downloadState);

    qu3 c(Context context, DownloadParams downloadParams, lu3 lu3Var);

    void d(int i);

    void e(Object obj);

    void f();

    VIEW getRealView();
}

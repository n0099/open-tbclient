package com.baidu.tieba.recapp.b;

import android.widget.RemoteViews;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ d fbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.fbY = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        RemoteViews remoteViews;
        RemoteViews remoteViews2;
        remoteViews = this.fbY.fbX;
        if (remoteViews != null && aVar != null && aVar.kN() != null) {
            remoteViews2 = this.fbY.fbX;
            remoteViews2.setImageViewBitmap(w.h.app_icon, aVar.kN());
        }
    }
}

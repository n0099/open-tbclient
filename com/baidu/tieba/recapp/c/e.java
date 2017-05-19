package com.baidu.tieba.recapp.c;

import android.widget.RemoteViews;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ d eYq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.eYq = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        RemoteViews remoteViews;
        RemoteViews remoteViews2;
        remoteViews = this.eYq.eYp;
        if (remoteViews != null && aVar != null && aVar.kR() != null) {
            remoteViews2 = this.eYq.eYp;
            remoteViews2.setImageViewBitmap(w.h.app_icon, aVar.kR());
        }
    }
}

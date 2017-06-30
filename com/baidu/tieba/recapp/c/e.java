package com.baidu.tieba.recapp.c;

import android.widget.RemoteViews;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ d frj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.frj = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        RemoteViews remoteViews;
        RemoteViews remoteViews2;
        remoteViews = this.frj.fri;
        if (remoteViews != null && aVar != null && aVar.kP() != null) {
            remoteViews2 = this.frj.fri;
            remoteViews2.setImageViewBitmap(w.h.app_icon, aVar.kP());
        }
    }
}

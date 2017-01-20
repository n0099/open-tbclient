package com.baidu.tieba.recapp.b;

import android.widget.RemoteViews;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ d eXU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.eXU = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        RemoteViews remoteViews;
        RemoteViews remoteViews2;
        remoteViews = this.eXU.eXT;
        if (remoteViews != null && aVar != null && aVar.jT() != null) {
            remoteViews2 = this.eXU.eXT;
            remoteViews2.setImageViewBitmap(r.h.app_icon, aVar.jT());
        }
    }
}

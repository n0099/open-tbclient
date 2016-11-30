package com.baidu.tieba.recapp.b;

import android.widget.RemoteViews;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    final /* synthetic */ d fkU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.fkU = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        RemoteViews remoteViews;
        RemoteViews remoteViews2;
        remoteViews = this.fkU.fkT;
        if (remoteViews != null && aVar != null && aVar.jV() != null) {
            remoteViews2 = this.fkU.fkT;
            remoteViews2.setImageViewBitmap(r.g.app_icon, aVar.jV());
        }
    }
}

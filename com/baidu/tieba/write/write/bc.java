package com.baidu.tieba.write.write;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements Runnable {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.write.view.PhotoLiveView.a aVar;
        GridView gridView;
        aVar = this.glP.gla;
        aVar.notifyDataSetChanged();
        gridView = this.glP.gkZ;
        gridView.invalidateViews();
    }
}

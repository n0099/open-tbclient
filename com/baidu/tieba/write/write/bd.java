package com.baidu.tieba.write.write;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements Runnable {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.write.view.PhotoLiveView.a aVar;
        GridView gridView;
        aVar = this.dqi.dpP;
        aVar.notifyDataSetChanged();
        gridView = this.dqi.dpO;
        gridView.invalidateViews();
    }
}

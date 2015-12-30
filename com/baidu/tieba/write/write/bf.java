package com.baidu.tieba.write.write;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements Runnable {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.write.view.PhotoLiveView.a aVar;
        GridView gridView;
        aVar = this.dYD.dYj;
        aVar.notifyDataSetChanged();
        gridView = this.dYD.dYi;
        gridView.invalidateViews();
    }
}

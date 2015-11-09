package com.baidu.tieba.write.write;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements Runnable {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.write.view.PhotoLiveView.a aVar;
        GridView gridView;
        aVar = this.dsa.drH;
        aVar.notifyDataSetChanged();
        gridView = this.dsa.drG;
        gridView.invalidateViews();
    }
}

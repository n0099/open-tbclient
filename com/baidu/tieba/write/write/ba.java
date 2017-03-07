package com.baidu.tieba.write.write;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements Runnable {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.write.view.PhotoLiveView.a aVar;
        GridView gridView;
        aVar = this.fQG.fPU;
        aVar.notifyDataSetChanged();
        gridView = this.fQG.fPT;
        gridView.invalidateViews();
    }
}

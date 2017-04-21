package com.baidu.tieba.write.write;

import android.widget.GridView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az implements Runnable {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tieba.write.view.PhotoLiveView.a aVar;
        GridView gridView;
        aVar = this.fUM.fUa;
        aVar.notifyDataSetChanged();
        gridView = this.fUM.fTZ;
        gridView.invalidateViews();
    }
}

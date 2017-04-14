package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ds implements Runnable {
    final /* synthetic */ dr emI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(dr drVar) {
        this.emI = drVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.emI.bqC;
        pbActivity = this.emI.emF;
        view.setBackgroundColor(pbActivity.getResources().getColor(w.e.common_color_10082));
    }
}

package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dt implements Runnable {
    final /* synthetic */ ds eyy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar) {
        this.eyy = dsVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.eyy.eyt;
        pbActivity = this.eyy.erE;
        view.setBackgroundColor(pbActivity.getResources().getColor(r.d.common_color_10082));
    }
}

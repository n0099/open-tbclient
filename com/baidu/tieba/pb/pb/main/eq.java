package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eq implements Runnable {
    final /* synthetic */ ep eqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(ep epVar) {
        this.eqM = epVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.eqM.bux;
        pbActivity = this.eqM.eqJ;
        view.setBackgroundColor(pbActivity.getResources().getColor(w.e.common_color_10082));
    }
}

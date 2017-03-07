package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class du implements Runnable {
    final /* synthetic */ dt eoB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public du(dt dtVar) {
        this.eoB = dtVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.eoB.bqJ;
        pbActivity = this.eoB.eoy;
        view.setBackgroundColor(pbActivity.getResources().getColor(w.e.common_color_10082));
    }
}

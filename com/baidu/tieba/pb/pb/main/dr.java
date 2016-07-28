package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements Runnable {
    final /* synthetic */ dq ees;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(dq dqVar) {
        this.ees = dqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.ees.een;
        pbActivity = this.ees.dXE;
        view.setBackgroundColor(pbActivity.getResources().getColor(u.d.common_color_10082));
    }
}

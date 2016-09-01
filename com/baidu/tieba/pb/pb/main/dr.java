package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements Runnable {
    final /* synthetic */ dq eqx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(dq dqVar) {
        this.eqx = dqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.eqx.eqs;
        pbActivity = this.eqx.ejJ;
        view.setBackgroundColor(pbActivity.getResources().getColor(t.d.common_color_10082));
    }
}

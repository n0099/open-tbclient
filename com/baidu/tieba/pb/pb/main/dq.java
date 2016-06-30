package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dq implements Runnable {
    final /* synthetic */ dp dSb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(dp dpVar) {
        this.dSb = dpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.dSb.dRW;
        pbActivity = this.dSb.dLv;
        view.setBackgroundColor(pbActivity.getResources().getColor(u.d.common_color_10082));
    }
}

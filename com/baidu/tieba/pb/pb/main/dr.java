package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dr implements Runnable {
    final /* synthetic */ dq esv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(dq dqVar) {
        this.esv = dqVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.esv.esq;
        pbActivity = this.esv.elH;
        view.setBackgroundColor(pbActivity.getResources().getColor(r.d.common_color_10082));
    }
}

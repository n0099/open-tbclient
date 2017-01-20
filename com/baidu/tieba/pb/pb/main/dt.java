package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dt implements Runnable {
    final /* synthetic */ ds elD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dt(ds dsVar) {
        this.elD = dsVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.elD.bjY;
        pbActivity = this.elD.elA;
        view.setBackgroundColor(pbActivity.getResources().getColor(r.e.common_color_10082));
    }
}

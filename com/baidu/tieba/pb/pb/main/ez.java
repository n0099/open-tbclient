package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ez implements Runnable {
    final /* synthetic */ ey ezX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ez(ey eyVar) {
        this.ezX = eyVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.ezX.bxT;
        pbActivity = this.ezX.ezU;
        view.setBackgroundColor(pbActivity.getResources().getColor(w.e.common_color_10082));
    }
}

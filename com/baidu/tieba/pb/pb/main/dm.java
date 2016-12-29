package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dm implements Runnable {
    final /* synthetic */ dl ecL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dm(dl dlVar) {
        this.ecL = dlVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.ecL.bai;
        pbActivity = this.ecL.ecI;
        view.setBackgroundColor(pbActivity.getResources().getColor(r.d.common_color_10082));
    }
}

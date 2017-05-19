package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eh implements Runnable {
    final /* synthetic */ eg ekZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh(eg egVar) {
        this.ekZ = egVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.ekZ.btr;
        pbActivity = this.ekZ.ekW;
        view.setBackgroundColor(pbActivity.getResources().getColor(w.e.common_color_10082));
    }
}

package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ds implements Runnable {
    final /* synthetic */ dr epb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ds(dr drVar) {
        this.epb = drVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view;
        PbActivity pbActivity;
        view = this.epb.bsT;
        pbActivity = this.epb.eoY;
        view.setBackgroundColor(pbActivity.getResources().getColor(w.e.common_color_10082));
    }
}

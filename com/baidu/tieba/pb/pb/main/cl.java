package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements View.OnClickListener {
    final /* synthetic */ cb cfj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(cb cbVar) {
        this.cfj = cbVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.cfj.cbx;
        if (pbActivity.checkUpIsLogin()) {
            this.cfj.Yv();
            if (this.cfj.cbh != null) {
                PbActivity.b bVar = this.cfj.cbh;
                z = this.cfj.cbG;
                bVar.eg(z);
            }
            this.cfj.aes();
        }
    }
}

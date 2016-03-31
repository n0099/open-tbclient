package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fq implements View.OnClickListener {
    final /* synthetic */ eu dnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fq(eu euVar) {
        this.dnc = euVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.dnc.dfw;
        if (pbActivity.checkUpIsLogin()) {
            this.dnc.akp();
            if (this.dnc.dhf != null) {
                PbActivity.c cVar = this.dnc.dhf;
                z = this.dnc.ddr;
                cVar.fZ(z);
            }
            this.dnc.ayR();
        }
    }
}

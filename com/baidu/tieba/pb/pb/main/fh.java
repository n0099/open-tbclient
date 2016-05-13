package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fh implements View.OnClickListener {
    final /* synthetic */ el dpu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fh(el elVar) {
        this.dpu = elVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.dpu.dhY;
        if (pbActivity.checkUpIsLogin()) {
            this.dpu.akx();
            if (this.dpu.djq != null) {
                PbActivity.c cVar = this.dpu.djq;
                z = this.dpu.dfL;
                cVar.gB(z);
            }
            this.dpu.azn();
        }
    }
}

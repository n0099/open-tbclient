package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements View.OnClickListener {
    final /* synthetic */ cc clJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cc ccVar) {
        this.clJ = ccVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.clJ.ciU;
        if (pbActivity.checkUpIsLogin()) {
            this.clJ.Zb();
            if (this.clJ.ciD != null) {
                PbActivity.b bVar = this.clJ.ciD;
                z = this.clJ.cgM;
                bVar.ev(z);
            }
            this.clJ.agA();
        }
    }
}

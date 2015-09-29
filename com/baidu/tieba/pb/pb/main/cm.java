package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements View.OnClickListener {
    final /* synthetic */ cc cly;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cc ccVar) {
        this.cly = ccVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.cly.ciJ;
        if (pbActivity.checkUpIsLogin()) {
            this.cly.Zf();
            if (this.cly.cis != null) {
                PbActivity.b bVar = this.cly.cis;
                z = this.cly.cgB;
                bVar.ev(z);
            }
            this.cly.agE();
        }
    }
}

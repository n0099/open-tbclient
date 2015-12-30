package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class eg implements View.OnClickListener {
    final /* synthetic */ dk cKg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(dk dkVar) {
        this.cKg = dkVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.cKg.cGj;
        if (pbActivity.checkUpIsLogin()) {
            this.cKg.adL();
            if (this.cKg.cFJ != null) {
                PbActivity.b bVar = this.cKg.cFJ;
                z = this.cKg.cDs;
                bVar.fa(z);
            }
            this.cKg.amS();
        }
    }
}

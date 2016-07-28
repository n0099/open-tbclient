package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class fs implements View.OnClickListener {
    final /* synthetic */ ew eiu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fs(ew ewVar) {
        this.eiu = ewVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.eiu.eat;
        if (pbActivity.checkUpIsLogin()) {
            this.eiu.atw();
            if (this.eiu.ebF != null) {
                PbActivity.c cVar = this.eiu.ebF;
                z = this.eiu.dZq;
                cVar.hF(z);
            }
            this.eiu.aKJ();
        }
    }
}

package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ft implements View.OnClickListener {
    final /* synthetic */ ex euB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ft(ex exVar) {
        this.euB = exVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.euB.emy;
        if (pbActivity.checkUpIsLogin()) {
            this.euB.ayk();
            if (this.euB.enN != null) {
                PbActivity.c cVar = this.euB.enN;
                z = this.euB.elu;
                cVar.ia(z);
            }
            this.euB.aPA();
        }
    }
}

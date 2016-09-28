package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ft implements View.OnClickListener {
    final /* synthetic */ ex ewH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ft(ex exVar) {
        this.ewH = exVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.ewH.eow;
        if (pbActivity.checkUpIsLogin()) {
            this.ewH.ayI();
            if (this.ewH.epM != null) {
                PbActivity.c cVar = this.ewH.epM;
                z = this.ewH.enr;
                cVar.id(z);
            }
            this.ewH.aQj();
        }
    }
}

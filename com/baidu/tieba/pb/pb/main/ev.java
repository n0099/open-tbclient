package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ev implements View.OnClickListener {
    final /* synthetic */ dz cSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ev(dz dzVar) {
        this.cSw = dzVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.cSw.cNL;
        if (pbActivity.checkUpIsLogin()) {
            this.cSw.agV();
            if (this.cSw.cNh != null) {
                PbActivity.c cVar = this.cSw.cNh;
                z = this.cSw.cKa;
                cVar.fp(z);
            }
            this.cSw.arr();
        }
    }
}

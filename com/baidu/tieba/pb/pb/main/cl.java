package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cl implements View.OnClickListener {
    final /* synthetic */ cb cgg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(cb cbVar) {
        this.cgg = cbVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.cgg.ccs;
        if (pbActivity.checkUpIsLogin()) {
            this.cgg.Yx();
            if (this.cgg.ccc != null) {
                PbActivity.b bVar = this.cgg.ccc;
                z = this.cgg.ccB;
                bVar.en(z);
            }
            this.cgg.aeG();
        }
    }
}

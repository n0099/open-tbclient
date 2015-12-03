package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dw implements View.OnClickListener {
    final /* synthetic */ da cGh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dw(da daVar) {
        this.cGh = daVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.cGh.cCy;
        if (pbActivity.checkUpIsLogin()) {
            this.cGh.acC();
            if (this.cGh.cCd != null) {
                PbActivity.b bVar = this.cGh.cCd;
                z = this.cGh.czN;
                bVar.fb(z);
            }
            this.cGh.alG();
        }
    }
}

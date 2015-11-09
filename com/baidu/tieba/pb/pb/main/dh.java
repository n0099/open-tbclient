package com.baidu.tieba.pb.pb.main;

import android.view.View;
import com.baidu.tieba.pb.pb.main.PbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dh implements View.OnClickListener {
    final /* synthetic */ ct cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(ct ctVar) {
        this.cmY = ctVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PbActivity pbActivity;
        boolean z;
        pbActivity = this.cmY.cjZ;
        if (pbActivity.checkUpIsLogin()) {
            this.cmY.Zw();
            if (this.cmY.cjG != null) {
                PbActivity.b bVar = this.cmY.cjG;
                z = this.cmY.chq;
                bVar.ey(z);
            }
            this.cmY.ahg();
        }
    }
}

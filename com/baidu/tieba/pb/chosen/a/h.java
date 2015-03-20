package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ e bGv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.bGv = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        ImageView imageView;
        Animation YF;
        i iVar;
        i iVar2;
        boolean z2;
        z = this.bGv.bGu;
        if (!z) {
            this.bGv.bGu = true;
            imageView = this.bGv.bGn;
            YF = this.bGv.YF();
            imageView.startAnimation(YF);
            iVar = this.bGv.bGr;
            if (iVar != null) {
                iVar2 = this.bGv.bGr;
                z2 = this.bGv.bGs;
                iVar2.dC(z2);
            }
        }
    }
}

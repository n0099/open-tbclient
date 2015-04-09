package com.baidu.tieba.pb.chosen.a;

import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ e bGI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.bGI = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        ImageView imageView;
        Animation YR;
        i iVar;
        i iVar2;
        boolean z2;
        z = this.bGI.bGH;
        if (!z) {
            this.bGI.bGH = true;
            imageView = this.bGI.bGA;
            YR = this.bGI.YR();
            imageView.startAnimation(YR);
            iVar = this.bGI.bGE;
            if (iVar != null) {
                iVar2 = this.bGI.bGE;
                z2 = this.bGI.bGF;
                iVar2.dA(z2);
            }
        }
    }
}

package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tieba.pb.chosen.a.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i cCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cCF = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Context context;
        ImageView imageView;
        Animation akB;
        i.a aVar;
        i.a aVar2;
        z = this.cCF.cCE;
        if (!z) {
            context = this.cCF.context;
            if (bj.ah(context)) {
                this.cCF.cCE = true;
                imageView = this.cCF.cCx;
                akB = this.cCF.akB();
                imageView.startAnimation(akB);
                aVar = this.cCF.cCA;
                if (aVar != null) {
                    aVar2 = this.cCF.cCA;
                    aVar2.eM(this.cCF.cCB);
                }
            }
        }
    }
}

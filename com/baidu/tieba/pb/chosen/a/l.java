package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.pb.chosen.a.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ i bZP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.bZP = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Context context;
        ImageView imageView;
        Animation acE;
        i.a aVar;
        i.a aVar2;
        boolean z2;
        z = this.bZP.bZL;
        if (!z) {
            context = this.bZP.context;
            if (bb.ah(context)) {
                this.bZP.bZL = true;
                imageView = this.bZP.bZF;
                acE = this.bZP.acE();
                imageView.startAnimation(acE);
                aVar = this.bZP.bZI;
                if (aVar != null) {
                    aVar2 = this.bZP.bZI;
                    z2 = this.bZP.bZJ;
                    aVar2.dX(z2);
                }
            }
        }
    }
}

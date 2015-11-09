package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.pb.chosen.a.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ i cgB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.cgB = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Context context;
        ImageView imageView;
        Animation afb;
        i.a aVar;
        i.a aVar2;
        boolean z2;
        z = this.cgB.cgx;
        if (!z) {
            context = this.cgB.context;
            if (bd.ah(context)) {
                this.cgB.cgx = true;
                imageView = this.cgB.cgq;
                afb = this.cgB.afb();
                imageView.startAnimation(afb);
                aVar = this.cgB.cgt;
                if (aVar != null) {
                    aVar2 = this.cgB.cgt;
                    z2 = this.cgB.cgu;
                    aVar2.el(z2);
                }
            }
        }
    }
}

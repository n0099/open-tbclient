package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ h bJB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bJB = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Context context;
        ImageView imageView;
        Animation aap;
        k kVar;
        k kVar2;
        boolean z2;
        z = this.bJB.bJA;
        if (!z) {
            context = this.bJB.context;
            if (bq.ae(context)) {
                this.bJB.bJA = true;
                imageView = this.bJB.bJu;
                aap = this.bJB.aap();
                imageView.startAnimation(aap);
                kVar = this.bJB.bJx;
                if (kVar != null) {
                    kVar2 = this.bJB.bJx;
                    z2 = this.bJB.bJy;
                    kVar2.dM(z2);
                }
            }
        }
    }
}

package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ h bJC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar) {
        this.bJC = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Context context;
        ImageView imageView;
        Animation aaq;
        k kVar;
        k kVar2;
        boolean z2;
        z = this.bJC.bJB;
        if (!z) {
            context = this.bJC.context;
            if (bq.ae(context)) {
                this.bJC.bJB = true;
                imageView = this.bJC.bJv;
                aaq = this.bJC.aaq();
                imageView.startAnimation(aaq);
                kVar = this.bJC.bJy;
                if (kVar != null) {
                    kVar2 = this.bJC.bJy;
                    z2 = this.bJC.bJz;
                    kVar2.dM(z2);
                }
            }
        }
    }
}

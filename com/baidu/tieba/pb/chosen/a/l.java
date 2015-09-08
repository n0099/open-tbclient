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
    final /* synthetic */ i caJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.caJ = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Context context;
        ImageView imageView;
        Animation acN;
        i.a aVar;
        i.a aVar2;
        boolean z2;
        z = this.caJ.caF;
        if (!z) {
            context = this.caJ.context;
            if (bb.ah(context)) {
                this.caJ.caF = true;
                imageView = this.caJ.caz;
                acN = this.caJ.acN();
                imageView.startAnimation(acN);
                aVar = this.caJ.caC;
                if (aVar != null) {
                    aVar2 = this.caJ.caC;
                    z2 = this.caJ.caD;
                    aVar2.ee(z2);
                }
            }
        }
    }
}

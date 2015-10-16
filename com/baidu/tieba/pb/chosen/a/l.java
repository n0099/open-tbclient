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
    final /* synthetic */ i cfZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.cfZ = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Context context;
        ImageView imageView;
        Animation aeK;
        i.a aVar;
        i.a aVar2;
        boolean z2;
        z = this.cfZ.cfV;
        if (!z) {
            context = this.cfZ.context;
            if (bd.ah(context)) {
                this.cfZ.cfV = true;
                imageView = this.cfZ.cfP;
                aeK = this.cfZ.aeK();
                imageView.startAnimation(aeK);
                aVar = this.cfZ.cfS;
                if (aVar != null) {
                    aVar2 = this.cfZ.cfS;
                    z2 = this.cfZ.cfT;
                    aVar2.ej(z2);
                }
            }
        }
    }
}

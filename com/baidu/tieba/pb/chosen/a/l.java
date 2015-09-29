package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.pb.chosen.a.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ i cfO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar) {
        this.cfO = iVar;
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
        z = this.cfO.cfK;
        if (!z) {
            context = this.cfO.context;
            if (bc.ah(context)) {
                this.cfO.cfK = true;
                imageView = this.cfO.cfE;
                aeK = this.cfO.aeK();
                imageView.startAnimation(aeK);
                aVar = this.cfO.cfH;
                if (aVar != null) {
                    aVar2 = this.cfO.cfH;
                    z2 = this.cfO.cfI;
                    aVar2.ej(z2);
                }
            }
        }
    }
}

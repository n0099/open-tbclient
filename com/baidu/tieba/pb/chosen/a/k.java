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
    final /* synthetic */ i cyZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cyZ = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Context context;
        ImageView imageView;
        Animation ajt;
        i.a aVar;
        i.a aVar2;
        z = this.cyZ.cyY;
        if (!z) {
            context = this.cyZ.context;
            if (bj.ah(context)) {
                this.cyZ.cyY = true;
                imageView = this.cyZ.cyR;
                ajt = this.cyZ.ajt();
                imageView.startAnimation(ajt);
                aVar = this.cyZ.cyU;
                if (aVar != null) {
                    aVar2 = this.cyZ.cyU;
                    aVar2.eN(this.cyZ.cyV);
                }
            }
        }
    }
}

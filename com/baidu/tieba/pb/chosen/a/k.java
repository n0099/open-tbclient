package com.baidu.tieba.pb.chosen.a;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tieba.pb.chosen.a.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i cJk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cJk = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        Context context;
        ImageView imageView;
        Animation aoz;
        i.a aVar;
        i.a aVar2;
        z = this.cJk.cJj;
        if (!z) {
            context = this.cJk.context;
            if (bi.ah(context)) {
                this.cJk.cJj = true;
                imageView = this.cJk.cJc;
                aoz = this.cJk.aoz();
                imageView.startAnimation(aoz);
                aVar = this.cJk.cJf;
                if (aVar != null) {
                    aVar2 = this.cJk.cJf;
                    aVar2.fa(this.cJk.cJg);
                }
            }
        }
    }
}

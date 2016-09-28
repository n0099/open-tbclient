package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.write.write.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r.b ggv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r.b bVar) {
        this.ggv = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        r rVar;
        r rVar2;
        rVar = r.this;
        if (rVar.ggn != null) {
            rVar2 = r.this;
            rVar2.ggn.btJ();
        }
    }
}

package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.write.write.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q.b dov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q.b bVar) {
        this.dov = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = q.this;
        if (qVar.don != null) {
            qVar2 = q.this;
            qVar2.don.aCQ();
        }
    }
}

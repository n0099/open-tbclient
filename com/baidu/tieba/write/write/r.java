package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tieba.write.write.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ q.b dqK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q.b bVar) {
        this.dqK = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = q.this;
        if (qVar.dqC != null) {
            qVar2 = q.this;
            qVar2.dqC.aDO();
        }
    }
}

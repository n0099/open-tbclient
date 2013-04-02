package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.tieba.a.af;
import com.baidu.tieba.c.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ n a;
    private final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, af afVar) {
        this.a = nVar;
        this.b = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ai.c(this.a.a, this.b.c());
    }
}

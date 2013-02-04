package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.tieba.a.af;
import com.baidu.tieba.c.ag;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l a;
    private final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, af afVar) {
        this.a = lVar;
        this.b = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ag.c(this.a.a, this.b.c());
    }
}

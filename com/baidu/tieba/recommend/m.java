package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.tieba.a.ad;
import com.baidu.tieba.c.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l a;
    private final /* synthetic */ ad b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, ad adVar) {
        this.a = lVar;
        this.b = adVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ai.c(this.a.a, this.b.c());
    }
}

package com.baidu.tieba.recommend;

import android.view.View;
import com.baidu.tieba.a.ag;
import com.baidu.tieba.c.ah;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ l a;
    private final /* synthetic */ ag b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, ag agVar) {
        this.a = lVar;
        this.b = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ah.c(this.a.a, this.b.c());
    }
}

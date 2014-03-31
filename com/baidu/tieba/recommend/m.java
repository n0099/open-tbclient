package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
final class m implements View.OnClickListener {
    final /* synthetic */ j a;
    private final /* synthetic */ com.baidu.tieba.data.l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar, com.baidu.tieba.data.l lVar) {
        this.a = jVar;
        this.b = lVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Activity activity;
        bg a = bg.a();
        activity = this.a.i;
        a.a(activity, new String[]{this.b.a()});
    }
}

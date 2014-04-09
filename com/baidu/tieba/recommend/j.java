package com.baidu.tieba.recommend;

import android.app.Activity;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
/* loaded from: classes.dex */
final class j implements View.OnClickListener {
    final /* synthetic */ i a;
    private final /* synthetic */ com.baidu.tieba.data.l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, com.baidu.tieba.data.l lVar) {
        this.a = iVar;
        this.b = lVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Activity activity;
        Activity activity2;
        activity = this.a.b;
        TiebaStatic.a(activity, "recommend_to_pb", "click");
        bg a = bg.a();
        activity2 = this.a.b;
        a.a(activity2, new String[]{this.b.a()});
    }
}

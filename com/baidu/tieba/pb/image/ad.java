package com.baidu.tieba.pb.image;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ad implements View.OnClickListener {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.a = acVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        Context context;
        ac acVar = this.a;
        i = this.a.q;
        ac.a(acVar, i);
        context = this.a.b;
        TiebaStatic.a(context, "pic_pb", "");
    }
}

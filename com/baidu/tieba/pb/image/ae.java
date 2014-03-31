package com.baidu.tieba.pb.image;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ae implements View.OnClickListener {
    final /* synthetic */ ad a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar) {
        this.a = adVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        Context context;
        ad adVar = this.a;
        i = this.a.q;
        ad.a(adVar, i);
        context = this.a.b;
        TiebaStatic.a(context, "pic_pb", "");
    }
}

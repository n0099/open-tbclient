package com.baidu.tieba.pb.image;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ ac a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.a = acVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        Context context;
        ac acVar = this.a;
        i = this.a.n;
        acVar.a(i);
        context = this.a.a;
        TiebaStatic.eventStat(context, "pic_pb", "");
    }
}

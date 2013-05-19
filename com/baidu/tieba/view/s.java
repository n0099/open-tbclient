package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.a = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        activity = this.a.q;
        ((FrsActivity) activity).m();
    }
}

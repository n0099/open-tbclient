package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ q f1529a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.f1529a = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        activity = this.f1529a.q;
        ((FrsActivity) activity).m();
    }
}

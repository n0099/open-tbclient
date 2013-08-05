package com.baidu.tieba.view;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f1850a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.f1850a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        activity = this.f1850a.u;
        ((FrsActivity) activity).k();
    }
}

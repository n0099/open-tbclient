package com.baidu.tieba.im.validate;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ p bog;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.bog = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        validateActivity = this.bog.bnX;
        validateActivity.finish();
    }
}

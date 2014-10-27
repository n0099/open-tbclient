package com.baidu.tieba.im.validate;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r bje;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.bje = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ValidateActivity validateActivity;
        validateActivity = this.bje.biS;
        validateActivity.finish();
    }
}

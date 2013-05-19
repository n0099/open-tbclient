package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ LabelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(LabelActivity labelActivity) {
        this.a = labelActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a(false);
    }
}

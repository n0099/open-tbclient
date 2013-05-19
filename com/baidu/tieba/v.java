package com.baidu.tieba;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ LabelActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(LabelActivity labelActivity) {
        this.a = labelActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.b();
    }
}

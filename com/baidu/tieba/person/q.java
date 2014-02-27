package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LinearLayout linearLayout;
        Button button;
        linearLayout = this.a.t;
        linearLayout.setVisibility(8);
        button = this.a.l;
        button.setVisibility(0);
    }
}

package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f1608a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EditHeadActivity editHeadActivity) {
        this.f1608a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        Button button;
        linearLayout = this.f1608a.t;
        linearLayout.setVisibility(8);
        button = this.f1608a.l;
        button.setVisibility(0);
    }
}

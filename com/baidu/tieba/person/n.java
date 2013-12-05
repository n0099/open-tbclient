package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(EditHeadActivity editHeadActivity) {
        this.f2359a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        Button button;
        linearLayout = this.f2359a.u;
        linearLayout.setVisibility(8);
        button = this.f2359a.m;
        button.setVisibility(0);
    }
}

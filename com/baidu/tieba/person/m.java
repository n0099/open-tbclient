package com.baidu.tieba.person;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ EditHeadActivity f2255a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(EditHeadActivity editHeadActivity) {
        this.f2255a = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        Button button;
        linearLayout = this.f2255a.u;
        linearLayout.setVisibility(0);
        button = this.f2255a.m;
        button.setVisibility(8);
    }
}

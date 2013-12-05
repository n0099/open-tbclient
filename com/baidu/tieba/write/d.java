package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f2806a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AtListActivity atListActivity) {
        this.f2806a = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        AtListActivity atListActivity = this.f2806a;
        editText = this.f2806a.b;
        com.baidu.adp.lib.h.g.a(atListActivity, editText);
        this.f2806a.finish();
    }
}

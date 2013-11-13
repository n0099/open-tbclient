package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AtListActivity f2704a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AtListActivity atListActivity) {
        this.f2704a = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        AtListActivity atListActivity = this.f2704a;
        editText = this.f2704a.b;
        UtilHelper.a(atListActivity, editText);
        this.f2704a.finish();
    }
}

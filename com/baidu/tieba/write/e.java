package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
final class e implements View.OnClickListener {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        AtListActivity atListActivity = this.a;
        editText = this.a.b;
        com.baidu.adp.lib.util.i.a(atListActivity, editText);
        this.a.finish();
    }
}

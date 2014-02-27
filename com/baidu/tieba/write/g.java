package com.baidu.tieba.write;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
final class g implements View.OnClickListener {
    final /* synthetic */ AtListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AtListActivity atListActivity) {
        this.a = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        editText = this.a.b;
        editText.getText().clear();
    }
}

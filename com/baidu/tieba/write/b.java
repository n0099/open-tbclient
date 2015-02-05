package com.baidu.tieba.write;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ AtListActivity cfx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AtListActivity atListActivity) {
        this.cfx = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        Activity pageActivity = this.cfx.getPageContext().getPageActivity();
        editText = this.cfx.mEditText;
        com.baidu.adp.lib.util.l.c(pageActivity, editText);
        this.cfx.finish();
    }
}

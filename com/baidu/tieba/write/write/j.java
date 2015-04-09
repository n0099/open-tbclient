package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ AtListActivity cxb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AtListActivity atListActivity) {
        this.cxb = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        textView = this.cxb.cwX;
        textView.setVisibility(8);
        view2 = this.cxb.btj;
        view2.setVisibility(8);
        view3 = this.cxb.bti;
        view3.setVisibility(0);
        editText = this.cxb.mEditText;
        editText.requestFocus();
    }
}

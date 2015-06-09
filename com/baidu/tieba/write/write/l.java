package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity cBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.cBu = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        textView = this.cBu.cBp;
        textView.setVisibility(8);
        view2 = this.cBu.bvU;
        view2.setVisibility(8);
        view3 = this.cBu.bvT;
        view3.setVisibility(0);
        editText = this.cBu.mEditText;
        editText.requestFocus();
    }
}

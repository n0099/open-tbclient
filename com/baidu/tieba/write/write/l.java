package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ AtListActivity cBt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(AtListActivity atListActivity) {
        this.cBt = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        textView = this.cBt.cBo;
        textView.setVisibility(8);
        view2 = this.cBt.bvT;
        view2.setVisibility(8);
        view3 = this.cBt.bvS;
        view3.setVisibility(0);
        editText = this.cBt.mEditText;
        editText.requestFocus();
    }
}

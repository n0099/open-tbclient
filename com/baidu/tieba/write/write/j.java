package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ AtListActivity cwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AtListActivity atListActivity) {
        this.cwI = atListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TextView textView;
        View view2;
        View view3;
        EditText editText;
        textView = this.cwI.cwE;
        textView.setVisibility(8);
        view2 = this.cwI.bsT;
        view2.setVisibility(8);
        view3 = this.cwI.bsS;
        view3.setVisibility(0);
        editText = this.cwI.mEditText;
        editText.requestFocus();
    }
}

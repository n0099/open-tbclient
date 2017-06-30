package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements View.OnClickListener {
    final /* synthetic */ cq gnc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cq cqVar) {
        this.gnc = cqVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        View view2;
        TextView textView;
        editText = this.gnc.gmX;
        editText.setText("");
        view2 = this.gnc.gmY;
        view2.setVisibility(8);
        textView = this.gnc.gmZ;
        textView.setEnabled(false);
    }
}

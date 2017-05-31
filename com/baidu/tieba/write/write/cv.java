package com.baidu.tieba.write.write;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements View.OnClickListener {
    final /* synthetic */ cs gce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cs csVar) {
        this.gce = csVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        View view2;
        TextView textView;
        editText = this.gce.gbZ;
        editText.setText("");
        view2 = this.gce.gca;
        view2.setVisibility(8);
        textView = this.gce.gcb;
        textView.setEnabled(false);
    }
}

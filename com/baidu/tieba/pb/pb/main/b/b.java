package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a dWp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dWp = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        radioButton = this.dWp.dWo;
        if (radioButton != null) {
            radioButton2 = this.dWp.dWo;
            radioButton2.toggle();
        }
    }
}

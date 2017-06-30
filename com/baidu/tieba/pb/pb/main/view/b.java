package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a eGi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eGi = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        radioButton = this.eGi.eGh;
        if (radioButton != null) {
            radioButton2 = this.eGi.eGh;
            radioButton2.toggle();
        }
    }
}

package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a ewM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ewM = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        radioButton = this.ewM.ewL;
        if (radioButton != null) {
            radioButton2 = this.ewM.ewL;
            radioButton2.toggle();
        }
    }
}

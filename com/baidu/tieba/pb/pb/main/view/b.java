package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a ehA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ehA = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        radioButton = this.ehA.ehz;
        if (radioButton != null) {
            radioButton2 = this.ehA.ehz;
            radioButton2.toggle();
        }
    }
}

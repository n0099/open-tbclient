package com.baidu.tieba.pb.pb.main.view;

import android.view.View;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a eDz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eDz = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        radioButton = this.eDz.eDy;
        if (radioButton != null) {
            radioButton2 = this.eDz.eDy;
            radioButton2.toggle();
        }
    }
}

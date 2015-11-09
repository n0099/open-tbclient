package com.baidu.tieba.pb.pb.main.b;

import android.view.View;
import android.widget.RadioButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cni = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RadioButton radioButton;
        RadioButton radioButton2;
        radioButton = this.cni.cnh;
        if (radioButton != null) {
            radioButton2 = this.cni.cnh;
            radioButton2.toggle();
        }
    }
}

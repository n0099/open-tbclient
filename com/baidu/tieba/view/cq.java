package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements View.OnClickListener {
    final /* synthetic */ TbCheckBox a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(TbCheckBox tbCheckBox) {
        this.a = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean d;
        TbCheckBox tbCheckBox = this.a;
        d = this.a.d();
        tbCheckBox.setChecked(!d);
    }
}

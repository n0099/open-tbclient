package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cp implements View.OnClickListener {
    final /* synthetic */ TbCheckBox a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cp(TbCheckBox tbCheckBox) {
        this.a = tbCheckBox;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean d;
        TbCheckBox tbCheckBox = this.a;
        d = this.a.d();
        tbCheckBox.setChecked(!d);
    }
}

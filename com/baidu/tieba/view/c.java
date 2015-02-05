package com.baidu.tieba.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a ceE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.ceE = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.ceE.TF();
    }
}

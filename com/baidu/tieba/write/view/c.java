package com.baidu.tieba.write.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a fAR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.fAR = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.fAR.atx();
    }
}

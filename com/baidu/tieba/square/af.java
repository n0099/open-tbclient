package com.baidu.tieba.square;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ aa bMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(aa aaVar) {
        this.bMQ = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        baseFragmentActivity = this.bMQ.axV;
        if (baseFragmentActivity instanceof SingleSquareActivity) {
            baseFragmentActivity2 = this.bMQ.axV;
            ((SingleSquareActivity) baseFragmentActivity2).closeActivity();
        }
    }
}

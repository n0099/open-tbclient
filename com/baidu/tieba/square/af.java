package com.baidu.tieba.square;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ aa bNf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(aa aaVar) {
        this.bNf = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        baseFragmentActivity = this.bNf.aye;
        if (baseFragmentActivity instanceof SingleSquareActivity) {
            baseFragmentActivity2 = this.bNf.aye;
            ((SingleSquareActivity) baseFragmentActivity2).closeActivity();
        }
    }
}

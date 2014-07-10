package com.baidu.tieba.square;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ af a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(af afVar) {
        this.a = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        baseFragmentActivity = this.a.h;
        if (baseFragmentActivity instanceof SingleSquareActivity) {
            baseFragmentActivity2 = this.a.h;
            ((SingleSquareActivity) baseFragmentActivity2).g();
        }
    }
}

package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ ab bLN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.bLN = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        baseActivity = this.bLN.mActivity;
        baseActivity.finish();
    }
}

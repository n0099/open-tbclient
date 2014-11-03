package com.baidu.tieba.signall;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ ab bMc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ab abVar) {
        this.bMc = abVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseActivity baseActivity;
        baseActivity = this.bMc.mActivity;
        baseActivity.finish();
    }
}

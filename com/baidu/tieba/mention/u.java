package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ r bnT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(r rVar) {
        this.bnT = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        BaseFragmentActivity baseFragmentActivity2;
        BaseFragmentActivity baseFragmentActivity3;
        baseFragmentActivity = this.bnT.aye;
        View currentFocus = baseFragmentActivity.getCurrentFocus();
        if (currentFocus != null) {
            baseFragmentActivity3 = this.bnT.aye;
            com.baidu.adp.lib.util.m.b(baseFragmentActivity3, currentFocus);
        }
        baseFragmentActivity2 = this.bnT.aye;
        baseFragmentActivity2.onBackPressed();
    }
}

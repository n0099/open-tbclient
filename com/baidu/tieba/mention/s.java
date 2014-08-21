package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.core.BaseFragmentActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        this.a = pVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        BaseFragmentActivity baseFragmentActivity;
        baseFragmentActivity = this.a.l;
        baseFragmentActivity.finish();
    }
}

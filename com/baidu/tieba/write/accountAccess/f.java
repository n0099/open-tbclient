package com.baidu.tieba.write.accountAccess;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c fGD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.fGD = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        BaseActivity baseActivity;
        aVar = this.fGD.fGw;
        aVar.onPostThreadCancle();
        baseActivity = this.fGD.mContext;
        baseActivity.finish();
    }
}

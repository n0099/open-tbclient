package com.baidu.tieba.write.accountAccess;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c fPc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.fPc = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        BaseActivity baseActivity;
        aVar = this.fPc.fOV;
        aVar.onPostThreadCancle();
        baseActivity = this.fPc.mContext;
        baseActivity.finish();
    }
}

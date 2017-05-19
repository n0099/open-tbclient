package com.baidu.tieba.write.accountAccess;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c fLP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.fLP = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        BaseActivity baseActivity;
        aVar = this.fLP.fLI;
        aVar.onPostThreadCancle();
        baseActivity = this.fLP.mContext;
        baseActivity.finish();
    }
}

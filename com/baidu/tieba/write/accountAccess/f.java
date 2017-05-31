package com.baidu.tieba.write.accountAccess;

import android.view.View;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ c fTw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.fTw = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        BaseActivity baseActivity;
        aVar = this.fTw.fTp;
        aVar.onPostThreadCancle();
        baseActivity = this.fTw.mContext;
        baseActivity.finish();
    }
}

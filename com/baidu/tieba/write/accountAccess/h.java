package com.baidu.tieba.write.accountAccess;

import android.content.DialogInterface;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements DialogInterface.OnCancelListener {
    final /* synthetic */ c fMG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.fMG = cVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        BaseActivity baseActivity;
        baseActivity = this.fMG.mContext;
        baseActivity.finish();
    }
}

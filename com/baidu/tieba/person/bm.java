package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
class bm implements bx {
    final /* synthetic */ PersonListActivity bDh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PersonListActivity personListActivity) {
        this.bDh = personListActivity;
    }

    @Override // com.baidu.tieba.person.bx
    public void D(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.bDh.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.bDh.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.bDh.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bx
    public com.baidu.tieba.data.aj d(com.baidu.tieba.data.aj ajVar, boolean z) {
        this.bDh.a(ajVar, z);
        return null;
    }
}

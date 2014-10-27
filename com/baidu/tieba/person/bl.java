package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
class bl implements bw {
    final /* synthetic */ PersonListActivity bCT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(PersonListActivity personListActivity) {
        this.bCT = personListActivity;
    }

    @Override // com.baidu.tieba.person.bw
    public void D(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.bCT.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.bCT.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.bCT.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bw
    public com.baidu.tieba.data.aj d(com.baidu.tieba.data.aj ajVar, boolean z) {
        this.bCT.a(ajVar, z);
        return null;
    }
}

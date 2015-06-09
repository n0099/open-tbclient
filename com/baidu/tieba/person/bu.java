package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
class bu implements cf {
    final /* synthetic */ PersonListActivity bTv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(PersonListActivity personListActivity) {
        this.bTv = personListActivity;
    }

    @Override // com.baidu.tieba.person.cf
    public void A(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.bTv.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.bTv.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.bTv.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.cf
    public com.baidu.tieba.person.a.a d(com.baidu.tieba.person.a.a aVar, boolean z) {
        this.bTv.a(aVar, z);
        return null;
    }
}

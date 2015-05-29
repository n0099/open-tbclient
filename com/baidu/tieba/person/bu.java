package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
class bu implements cf {
    final /* synthetic */ PersonListActivity bTu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(PersonListActivity personListActivity) {
        this.bTu = personListActivity;
    }

    @Override // com.baidu.tieba.person.cf
    public void A(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.bTu.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.bTu.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.bTu.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.cf
    public com.baidu.tieba.person.a.a d(com.baidu.tieba.person.a.a aVar, boolean z) {
        this.bTu.a(aVar, z);
        return null;
    }
}

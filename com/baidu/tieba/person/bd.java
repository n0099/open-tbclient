package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
class bd implements bo {
    final /* synthetic */ PersonListActivity bIs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(PersonListActivity personListActivity) {
        this.bIs = personListActivity;
    }

    @Override // com.baidu.tieba.person.bo
    public void A(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.bIs.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.bIs.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.bIs.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bo
    public com.baidu.tbadk.core.data.r d(com.baidu.tbadk.core.data.r rVar, boolean z) {
        this.bIs.a(rVar, z);
        return null;
    }
}

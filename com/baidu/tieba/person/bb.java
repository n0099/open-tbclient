package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
class bb implements bm {
    final /* synthetic */ PersonListActivity bQP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PersonListActivity personListActivity) {
        this.bQP = personListActivity;
    }

    @Override // com.baidu.tieba.person.bm
    public void A(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.bQP.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.bQP.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.bQP.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bm
    public com.baidu.tieba.person.a.a d(com.baidu.tieba.person.a.a aVar, boolean z) {
        this.bQP.a(aVar, z);
        return null;
    }
}

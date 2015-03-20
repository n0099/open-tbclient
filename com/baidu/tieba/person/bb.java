package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
class bb implements bm {
    final /* synthetic */ PersonListActivity bQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(PersonListActivity personListActivity) {
        this.bQz = personListActivity;
    }

    @Override // com.baidu.tieba.person.bm
    public void A(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.bQz.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.bQz.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.bQz.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bm
    public com.baidu.tieba.person.a.a d(com.baidu.tieba.person.a.a aVar, boolean z) {
        this.bQz.a(aVar, z);
        return null;
    }
}

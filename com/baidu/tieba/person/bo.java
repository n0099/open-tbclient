package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.tieba.person.bv;
/* loaded from: classes.dex */
class bo implements bv.a {
    final /* synthetic */ PersonListActivity cZq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PersonListActivity personListActivity) {
        this.cZq = personListActivity;
    }

    @Override // com.baidu.tieba.person.bv.a
    public void F(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.cZq.aNo;
            if (progressBar.isShown()) {
                progressBar2 = this.cZq.aNo;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.cZq.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bv.a
    public com.baidu.tieba.person.data.r d(com.baidu.tieba.person.data.r rVar, boolean z) {
        this.cZq.a(rVar, z);
        return null;
    }
}

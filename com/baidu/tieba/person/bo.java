package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.tieba.person.bv;
/* loaded from: classes.dex */
class bo implements bv.a {
    final /* synthetic */ PersonListActivity dtT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(PersonListActivity personListActivity) {
        this.dtT = personListActivity;
    }

    @Override // com.baidu.tieba.person.bv.a
    public void G(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.dtT.aQj;
            if (progressBar.isShown()) {
                progressBar2 = this.dtT.aQj;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.dtT.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bv.a
    public com.baidu.tieba.person.data.r d(com.baidu.tieba.person.data.r rVar, boolean z) {
        this.dtT.a(rVar, z);
        return null;
    }
}

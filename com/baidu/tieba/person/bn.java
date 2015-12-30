package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.tieba.person.bu;
/* loaded from: classes.dex */
class bn implements bu.a {
    final /* synthetic */ PersonListActivity cPT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PersonListActivity personListActivity) {
        this.cPT = personListActivity;
    }

    @Override // com.baidu.tieba.person.bu.a
    public void F(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.cPT.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.cPT.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.cPT.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bu.a
    public com.baidu.tieba.person.data.p d(com.baidu.tieba.person.data.p pVar, boolean z) {
        this.cPT.a(pVar, z);
        return null;
    }
}

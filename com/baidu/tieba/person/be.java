package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
class be implements bp {
    final /* synthetic */ PersonListActivity bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(PersonListActivity personListActivity) {
        this.bGG = personListActivity;
    }

    @Override // com.baidu.tieba.person.bp
    public void B(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.bGG.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.bGG.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.bGG.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bp
    public com.baidu.tbadk.core.data.q d(com.baidu.tbadk.core.data.q qVar, boolean z) {
        this.bGG.a(qVar, z);
        return null;
    }
}

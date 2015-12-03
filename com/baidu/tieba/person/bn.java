package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.tieba.person.bu;
/* loaded from: classes.dex */
class bn implements bu.a {
    final /* synthetic */ PersonListActivity cLD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(PersonListActivity personListActivity) {
        this.cLD = personListActivity;
    }

    @Override // com.baidu.tieba.person.bu.a
    public void G(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.cLD.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.cLD.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.cLD.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bu.a
    public com.baidu.tieba.person.data.n d(com.baidu.tieba.person.data.n nVar, boolean z) {
        this.cLD.a(nVar, z);
        return null;
    }
}

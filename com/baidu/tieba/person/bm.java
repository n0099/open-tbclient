package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.tieba.person.bt;
/* loaded from: classes.dex */
class bm implements bt.a {
    final /* synthetic */ PersonListActivity cqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PersonListActivity personListActivity) {
        this.cqN = personListActivity;
    }

    @Override // com.baidu.tieba.person.bt.a
    public void E(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.cqN.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.cqN.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.cqN.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bt.a
    public com.baidu.tieba.person.data.a d(com.baidu.tieba.person.data.a aVar, boolean z) {
        this.cqN.a(aVar, z);
        return null;
    }
}

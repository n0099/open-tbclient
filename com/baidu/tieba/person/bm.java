package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.tieba.person.bt;
/* loaded from: classes.dex */
class bm implements bt.a {
    final /* synthetic */ PersonListActivity cqC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PersonListActivity personListActivity) {
        this.cqC = personListActivity;
    }

    @Override // com.baidu.tieba.person.bt.a
    public void E(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.cqC.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.cqC.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.cqC.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bt.a
    public com.baidu.tieba.person.data.a d(com.baidu.tieba.person.data.a aVar, boolean z) {
        this.cqC.a(aVar, z);
        return null;
    }
}

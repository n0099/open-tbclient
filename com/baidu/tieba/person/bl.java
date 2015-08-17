package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.tieba.person.bs;
/* loaded from: classes.dex */
class bl implements bs.a {
    final /* synthetic */ PersonListActivity ckd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(PersonListActivity personListActivity) {
        this.ckd = personListActivity;
    }

    @Override // com.baidu.tieba.person.bs.a
    public void B(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.ckd.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.ckd.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.ckd.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bs.a
    public com.baidu.tieba.person.a.a d(com.baidu.tieba.person.a.a aVar, boolean z) {
        this.ckd.a(aVar, z);
        return null;
    }
}

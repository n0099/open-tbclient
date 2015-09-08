package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.tieba.person.bs;
/* loaded from: classes.dex */
class bl implements bs.a {
    final /* synthetic */ PersonListActivity ckY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(PersonListActivity personListActivity) {
        this.ckY = personListActivity;
    }

    @Override // com.baidu.tieba.person.bs.a
    public void D(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.ckY.mProgress;
            if (progressBar.isShown()) {
                progressBar2 = this.ckY.mProgress;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.ckY.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.bs.a
    public com.baidu.tieba.person.a.a d(com.baidu.tieba.person.a.a aVar, boolean z) {
        this.ckY.a(aVar, z);
        return null;
    }
}

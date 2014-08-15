package com.baidu.tieba.person;

import android.text.TextUtils;
import android.widget.ProgressBar;
/* loaded from: classes.dex */
class dl implements dw {
    final /* synthetic */ PersonListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(PersonListActivity personListActivity) {
        this.a = personListActivity;
    }

    @Override // com.baidu.tieba.person.dw
    public void a(String str, boolean z) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (!z) {
            progressBar = this.a.g;
            if (progressBar.isShown()) {
                progressBar2 = this.a.g;
                progressBar2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.a.showToast(str);
            }
        }
    }

    @Override // com.baidu.tieba.person.dw
    public com.baidu.tieba.data.am a(com.baidu.tieba.data.am amVar, boolean z) {
        this.a.a(amVar, z);
        return null;
    }
}

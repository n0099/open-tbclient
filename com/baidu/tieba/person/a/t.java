package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class t implements View.OnClickListener {
    private final /* synthetic */ UserData bJd;
    final /* synthetic */ r cMC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar, UserData userData) {
        this.cMC = rVar;
        this.bJd = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cMC.e(this.bJd);
    }
}

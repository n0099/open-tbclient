package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    private final /* synthetic */ UserData bqm;
    final /* synthetic */ ac coL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar, UserData userData) {
        this.coL = acVar;
        this.bqm = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.coL.n(this.bqm);
    }
}

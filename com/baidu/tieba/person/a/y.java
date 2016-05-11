package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    private final /* synthetic */ UserData cbH;
    final /* synthetic */ w dyb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar, UserData userData) {
        this.dyb = wVar;
        this.cbH = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dyb.e(this.cbH);
    }
}

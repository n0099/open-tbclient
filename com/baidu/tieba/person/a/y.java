package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    private final /* synthetic */ UserData cHd;
    final /* synthetic */ w egx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar, UserData userData) {
        this.egx = wVar;
        this.cHd = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.egx.e(this.cHd);
    }
}

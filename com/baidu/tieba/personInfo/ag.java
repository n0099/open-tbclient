package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    private final /* synthetic */ UserData bty;
    final /* synthetic */ ae cuI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, UserData userData) {
        this.cuI = aeVar;
        this.bty = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cuI.p(this.bty);
    }
}

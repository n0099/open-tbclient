package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    private final /* synthetic */ UserData btY;
    final /* synthetic */ ae cwe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, UserData userData) {
        this.cwe = aeVar;
        this.btY = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cwe.p(this.btY);
    }
}

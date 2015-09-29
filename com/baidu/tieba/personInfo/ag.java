package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ag implements View.OnClickListener {
    private final /* synthetic */ UserData btn;
    final /* synthetic */ ae cux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, UserData userData) {
        this.cux = aeVar;
        this.btn = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cux.p(this.btn);
    }
}

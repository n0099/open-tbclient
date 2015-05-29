package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ z bWQ;
    private final /* synthetic */ UserData bbS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, UserData userData) {
        this.bWQ = zVar;
        this.bbS = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bWQ.m(this.bbS);
    }
}

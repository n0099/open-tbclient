package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ z bWR;
    private final /* synthetic */ UserData bbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, UserData userData) {
        this.bWR = zVar;
        this.bbT = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bWR.m(this.bbT);
    }
}

package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    private final /* synthetic */ UserData aPX;
    final /* synthetic */ z bGF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, UserData userData) {
        this.bGF = zVar;
        this.aPX = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bGF.j(this.aPX);
    }
}

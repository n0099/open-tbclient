package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    private final /* synthetic */ UserData aSO;
    final /* synthetic */ z bLK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, UserData userData) {
        this.bLK = zVar;
        this.aSO = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bLK.n(this.aSO);
    }
}

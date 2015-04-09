package com.baidu.tieba.personInfo;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    private final /* synthetic */ UserData aZl;
    final /* synthetic */ z bUj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, UserData userData) {
        this.bUj = zVar;
        this.aZl = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bUj.m(this.aZl);
    }
}

package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class w implements View.OnClickListener {
    private final /* synthetic */ UserData cJS;
    final /* synthetic */ u eqw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, UserData userData) {
        this.eqw = uVar;
        this.cJS = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eqw.e(this.cJS);
    }
}

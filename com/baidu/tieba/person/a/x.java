package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    private final /* synthetic */ UserData bQJ;
    final /* synthetic */ v daD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar, UserData userData) {
        this.daD = vVar;
        this.bQJ = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.daD.e(this.bQJ);
    }
}

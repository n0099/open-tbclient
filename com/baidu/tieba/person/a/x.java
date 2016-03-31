package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    private final /* synthetic */ UserData cbc;
    final /* synthetic */ v dvf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar, UserData userData) {
        this.dvf = vVar;
        this.cbc = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.dvf.e(this.cbc);
    }
}

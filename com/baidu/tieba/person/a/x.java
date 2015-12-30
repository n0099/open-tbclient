package com.baidu.tieba.person.a;

import android.view.View;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    private final /* synthetic */ UserData bML;
    final /* synthetic */ v cQW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(v vVar, UserData userData) {
        this.cQW = vVar;
        this.bML = userData;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cQW.e(this.bML);
    }
}

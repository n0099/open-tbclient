package com.baidu.tieba.pb.account.forbid;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e bII;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bII = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bII.bIH = ((g) view.getTag()).mIndex;
        this.bII.notifyDataSetChanged();
    }
}

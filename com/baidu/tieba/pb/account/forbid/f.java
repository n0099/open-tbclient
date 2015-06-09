package com.baidu.tieba.pb.account.forbid;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bIJ = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bIJ.bII = ((g) view.getTag()).mIndex;
        this.bIJ.notifyDataSetChanged();
    }
}

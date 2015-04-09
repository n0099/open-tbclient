package com.baidu.tieba.pb.account.forbid;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e bFN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bFN = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bFN.bFM = ((g) view.getTag()).mIndex;
        this.bFN.notifyDataSetChanged();
    }
}

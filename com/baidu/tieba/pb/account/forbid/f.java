package com.baidu.tieba.pb.account.forbid;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e bFA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.bFA = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bFA.bFz = ((g) view.getTag()).mIndex;
        this.bFA.notifyDataSetChanged();
    }
}

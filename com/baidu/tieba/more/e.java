package com.baidu.tieba.more;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountActivity accountActivity) {
        this.a = accountActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i iVar;
        com.baidu.tieba.a.a aVar = (com.baidu.tieba.a.a) view.getTag();
        if (aVar != null) {
            this.a.l = new i(this.a, aVar);
            iVar = this.a.l;
            iVar.execute(new Object[0]);
        }
    }
}

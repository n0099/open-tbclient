package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class eh implements DialogInterface.OnClickListener {
    final /* synthetic */ ee a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eh(ee eeVar) {
        this.a = eeVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}

package com.baidu.tieba.im.validate;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.editortool.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements Runnable {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t tVar;
        ab abVar;
        tVar = this.a.b;
        BdListView d = tVar.d();
        abVar = this.a.h;
        ac.a(d, abVar, 0, 1);
    }
}

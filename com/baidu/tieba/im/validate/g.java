package com.baidu.tieba.im.validate;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortool.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    final /* synthetic */ ValidateActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ValidateActivity validateActivity) {
        this.a = validateActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        t tVar;
        aa aaVar;
        tVar = this.a.b;
        BdListView c = tVar.c();
        aaVar = this.a.h;
        aj.a(c, aaVar, 0, 1);
    }
}

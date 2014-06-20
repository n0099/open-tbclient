package com.baidu.tieba.im.validate;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.editortool.ab;
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
        ab abVar;
        tVar = this.a.b;
        BdListView c = tVar.c();
        abVar = this.a.h;
        ag.a(c, abVar, 0, 1);
    }
}

package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.pb.pb.main.view.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements c.a {
    final /* synthetic */ NewSubPbActivity eEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewSubPbActivity newSubPbActivity) {
        this.eEs = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.c.a
    public void i(com.baidu.tieba.tbadkCore.data.q qVar) {
        ao aoVar;
        ao aoVar2;
        aoVar = this.eEs.eEd;
        aoVar.k(qVar);
        aoVar2 = this.eEs.eEd;
        aoVar2.d((BdListView.e) null);
    }
}

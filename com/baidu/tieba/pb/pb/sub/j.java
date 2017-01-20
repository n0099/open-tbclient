package com.baidu.tieba.pb.pb.sub;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements PbFakeFloorModel.a {
    final /* synthetic */ NewSubPbActivity erC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(NewSubPbActivity newSubPbActivity) {
        this.erC = newSubPbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
    public void h(com.baidu.tieba.tbadkCore.data.p pVar) {
        ao aoVar;
        ao aoVar2;
        aoVar = this.erC.ern;
        aoVar.j(pVar);
        aoVar2 = this.erC.ern;
        aoVar2.a((BdListView.e) null);
    }
}

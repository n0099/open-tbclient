package com.baidu.tieba.personInfo;

import com.baidu.adp.widget.ListView.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements BdExpandListView.a {
    final /* synthetic */ PersonInfoActivity csI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonInfoActivity personInfoActivity) {
        this.csI = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void nn() {
        y yVar;
        aj ajVar;
        aj ajVar2;
        yVar = this.csI.csv;
        yVar.ajQ();
        ajVar = this.csI.csw;
        if (ajVar.ajU() != null) {
            ajVar2 = this.csI.csw;
            ajVar2.ajU().nl();
        }
        this.csI.aje();
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void nm() {
        aj ajVar;
        aj ajVar2;
        ajVar = this.csI.csw;
        if (ajVar.ajU() != null) {
            ajVar2 = this.csI.csw;
            ajVar2.ajU().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void k(float f) {
        aj ajVar;
        aj ajVar2;
        ajVar = this.csI.csw;
        if (ajVar.ajU() != null) {
            ajVar2 = this.csI.csw;
            ajVar2.ajU().j(f);
        }
    }
}

package com.baidu.tieba.personInfo;

import com.baidu.adp.widget.ListView.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements BdExpandListView.a {
    final /* synthetic */ PersonInfoActivity csx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonInfoActivity personInfoActivity) {
        this.csx = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void nn() {
        y yVar;
        aj ajVar;
        aj ajVar2;
        yVar = this.csx.csk;
        yVar.ajU();
        ajVar = this.csx.csl;
        if (ajVar.ajY() != null) {
            ajVar2 = this.csx.csl;
            ajVar2.ajY().nl();
        }
        this.csx.aji();
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void nm() {
        aj ajVar;
        aj ajVar2;
        ajVar = this.csx.csl;
        if (ajVar.ajY() != null) {
            ajVar2 = this.csx.csl;
            ajVar2.ajY().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void k(float f) {
        aj ajVar;
        aj ajVar2;
        ajVar = this.csx.csl;
        if (ajVar.ajY() != null) {
            ajVar2 = this.csx.csl;
            ajVar2.ajY().j(f);
        }
    }
}

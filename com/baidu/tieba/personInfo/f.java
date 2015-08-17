package com.baidu.tieba.personInfo;

import com.baidu.adp.widget.ListView.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BdExpandListView.a {
    final /* synthetic */ PersonInfoActivity clO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PersonInfoActivity personInfoActivity) {
        this.clO = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void np() {
        w wVar;
        ag agVar;
        ag agVar2;
        wVar = this.clO.clC;
        wVar.ahB();
        agVar = this.clO.clD;
        if (agVar.ahF() != null) {
            agVar2 = this.clO.clD;
            agVar2.ahF().nn();
        }
        this.clO.agO();
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void no() {
        ag agVar;
        ag agVar2;
        agVar = this.clO.clD;
        if (agVar.ahF() != null) {
            agVar2 = this.clO.clD;
            agVar2.ahF().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void k(float f) {
        ag agVar;
        ag agVar2;
        agVar = this.clO.clD;
        if (agVar.ahF() != null) {
            agVar2 = this.clO.clD;
            agVar2.ahF().j(f);
        }
    }
}

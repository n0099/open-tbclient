package com.baidu.tieba.personInfo;

import com.baidu.adp.widget.ListView.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements BdExpandListView.a {
    final /* synthetic */ PersonInfoActivity cue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PersonInfoActivity personInfoActivity) {
        this.cue = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void no() {
        y yVar;
        aj ajVar;
        aj ajVar2;
        yVar = this.cue.ctR;
        yVar.akw();
        ajVar = this.cue.ctS;
        if (ajVar.akA() != null) {
            ajVar2 = this.cue.ctS;
            ajVar2.akA().nm();
        }
        this.cue.ajK();
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void nn() {
        aj ajVar;
        aj ajVar2;
        ajVar = this.cue.ctS;
        if (ajVar.akA() != null) {
            ajVar2 = this.cue.ctS;
            ajVar2.akA().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void k(float f) {
        aj ajVar;
        aj ajVar2;
        ajVar = this.cue.ctS;
        if (ajVar.akA() != null) {
            ajVar2 = this.cue.ctS;
            ajVar2.akA().j(f);
        }
    }
}

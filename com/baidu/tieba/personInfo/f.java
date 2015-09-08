package com.baidu.tieba.personInfo;

import com.baidu.adp.widget.ListView.BdExpandListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements BdExpandListView.a {
    final /* synthetic */ PersonInfoActivity cmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PersonInfoActivity personInfoActivity) {
        this.cmR = personInfoActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void nm() {
        w wVar;
        ag agVar;
        ag agVar2;
        wVar = this.cmR.cmF;
        wVar.ahT();
        agVar = this.cmR.cmG;
        if (agVar.ahX() != null) {
            agVar2 = this.cmR.cmG;
            agVar2.ahX().nk();
        }
        this.cmR.ahg();
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void nl() {
        ag agVar;
        ag agVar2;
        agVar = this.cmR.cmG;
        if (agVar.ahX() != null) {
            agVar2 = this.cmR.cmG;
            agVar2.ahX().hideProgress();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdExpandListView.a
    public void k(float f) {
        ag agVar;
        ag agVar2;
        agVar = this.cmR.cmG;
        if (agVar.ahX() != null) {
            agVar2 = this.cmR.cmG;
            agVar2.ahX().j(f);
        }
    }
}

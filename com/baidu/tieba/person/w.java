package com.baidu.tieba.person;
/* loaded from: classes.dex */
class w implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ o bBP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(o oVar) {
        this.bBP = oVar;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        PersonBarActivity ZO;
        ZO = this.bBP.ZO();
        if (ZO == null) {
            return;
        }
        this.bBP.Wa();
    }
}

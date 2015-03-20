package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ad implements com.baidu.tbadk.core.view.ae {
    final /* synthetic */ v bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(v vVar) {
        this.bPF = vVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        PersonBarActivity acW;
        acW = this.bPF.acW();
        if (acW != null) {
            this.bPF.bPw = 1;
            this.bPF.Vn();
        }
    }
}

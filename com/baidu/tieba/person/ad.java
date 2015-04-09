package com.baidu.tieba.person;
/* loaded from: classes.dex */
class ad implements com.baidu.tbadk.core.view.ae {
    final /* synthetic */ v bPV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(v vVar) {
        this.bPV = vVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        PersonBarActivity adl;
        adl = this.bPV.adl();
        if (adl != null) {
            this.bPV.bPM = 1;
            this.bPV.VA();
        }
    }
}

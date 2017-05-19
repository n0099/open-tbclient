package com.baidu.tieba.personPolymeric.d;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements BdListView.e {
    final /* synthetic */ ab eFx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ab abVar) {
        this.eFx = abVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void ln() {
        PbListView pbListView;
        com.baidu.tieba.model.a aVar;
        int i;
        int i2;
        PbListView pbListView2;
        com.baidu.tieba.model.a aVar2;
        PbListView pbListView3;
        com.baidu.tieba.model.a aVar3;
        pbListView = this.eFx.aSj;
        if (pbListView != null) {
            aVar = this.eFx.fIR;
            if (aVar != null) {
                i = this.eFx.boM;
                if (i == 0) {
                    pbListView3 = this.eFx.aSj;
                    pbListView3.wo();
                    aVar3 = this.eFx.fIR;
                    aVar3.g(false, false, false);
                    return;
                }
                i2 = this.eFx.boM;
                if (i2 == 1) {
                    pbListView2 = this.eFx.aSj;
                    pbListView2.wo();
                    aVar2 = this.eFx.fIR;
                    aVar2.g(true, false, false);
                }
            }
        }
    }
}

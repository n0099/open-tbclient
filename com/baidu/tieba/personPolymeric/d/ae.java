package com.baidu.tieba.personPolymeric.d;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements BdListView.e {
    final /* synthetic */ ac eYx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.eYx = acVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        PbListView pbListView;
        com.baidu.tieba.model.b bVar;
        int i;
        int i2;
        PbListView pbListView2;
        com.baidu.tieba.model.b bVar2;
        PbListView pbListView3;
        com.baidu.tieba.model.b bVar3;
        pbListView = this.eYx.bbP;
        if (pbListView != null) {
            bVar = this.eYx.gaz;
            if (bVar != null) {
                i = this.eYx.btF;
                if (i != 0) {
                    i2 = this.eYx.btF;
                    if (i2 == 1) {
                        pbListView2 = this.eYx.bbP;
                        pbListView2.wD();
                        bVar2 = this.eYx.gaz;
                        bVar2.d(true, false, false);
                        return;
                    }
                    return;
                }
                pbListView3 = this.eYx.bbP;
                pbListView3.wD();
                bVar3 = this.eYx.gaz;
                bVar3.d(false, false, false);
            }
        }
    }
}

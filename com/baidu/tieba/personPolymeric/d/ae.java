package com.baidu.tieba.personPolymeric.d;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.PbListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements BdListView.e {
    final /* synthetic */ ac eOh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ac acVar) {
        this.eOh = acVar;
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
        pbListView = this.eOh.aZY;
        if (pbListView != null) {
            bVar = this.eOh.fQI;
            if (bVar != null) {
                i = this.eOh.bpT;
                if (i != 0) {
                    i2 = this.eOh.bpT;
                    if (i2 == 1) {
                        pbListView2 = this.eOh.aZY;
                        pbListView2.wl();
                        bVar2 = this.eOh.fQI;
                        bVar2.d(true, false, false);
                        return;
                    }
                    return;
                }
                pbListView3 = this.eOh.aZY;
                pbListView3.wl();
                bVar3 = this.eOh.fQI;
                bVar3.d(false, false, false);
            }
        }
    }
}

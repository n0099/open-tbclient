package com.baidu.tieba.personInfo;

import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements BdListView.e {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jA() {
        com.baidu.tieba.person.god.h hVar;
        bj bjVar;
        bg bgVar;
        bg bgVar2;
        com.baidu.tieba.person.god.h hVar2;
        com.baidu.tieba.person.god.h hVar3;
        bg bgVar3;
        bj bjVar2;
        bj bjVar3;
        bg bgVar4;
        com.baidu.tieba.person.god.h hVar4;
        bj bjVar4;
        bg bgVar5;
        bj bjVar5;
        bj bjVar6;
        hVar = this.this$0.dzV;
        if (hVar != null) {
            bjVar = this.this$0.dFA;
            if (bjVar != null) {
                bgVar = this.this$0.dyP;
                if (bgVar != null) {
                    bgVar2 = this.this$0.dyP;
                    if (!bgVar2.aDZ()) {
                        bgVar5 = this.this$0.dyP;
                        if (com.baidu.tbadk.core.util.y.s(bgVar5.aDC())) {
                            bjVar6 = this.this$0.dFA;
                            bjVar6.aEj();
                            return;
                        }
                        bjVar5 = this.this$0.dFA;
                        bjVar5.aCA();
                        return;
                    }
                    hVar2 = this.this$0.dzV;
                    if (!hVar2.isLoading()) {
                        hVar3 = this.this$0.dzV;
                        if (hVar3.hasMore()) {
                            bgVar4 = this.this$0.dyP;
                            long c = com.baidu.adp.lib.h.b.c(bgVar4.getId(), 0L);
                            hVar4 = this.this$0.dzV;
                            hVar4.bG(c);
                            bjVar4 = this.this$0.dFA;
                            bjVar4.OL();
                            return;
                        }
                        bgVar3 = this.this$0.dyP;
                        if (com.baidu.tbadk.core.util.y.s(bgVar3.aDC())) {
                            bjVar3 = this.this$0.dFA;
                            bjVar3.aEj();
                            return;
                        }
                        bjVar2 = this.this$0.dFA;
                        bjVar2.aCA();
                    }
                }
            }
        }
    }
}

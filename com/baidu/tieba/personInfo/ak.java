package com.baidu.tieba.personInfo;

import com.baidu.tieba.person.god.h;
import java.util.List;
import tbclient.ThreadInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements h.a {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(f fVar) {
        this.this$0 = fVar;
    }

    @Override // com.baidu.tieba.person.god.h.a
    public void d(int i, List<ThreadInfo> list) {
        bj bjVar;
        bg bgVar;
        bg bgVar2;
        bj bjVar2;
        bjVar = this.this$0.dFA;
        if (bjVar != null) {
            bgVar = this.this$0.dyP;
            if (bgVar != null) {
                bgVar2 = this.this$0.dyP;
                bgVar2.bR(list);
                bjVar2 = this.this$0.dFA;
                bjVar2.aEj();
            }
        }
    }

    @Override // com.baidu.tieba.person.god.h.a
    public void fz(String str) {
        com.baidu.tieba.person.god.h hVar;
        bj bjVar;
        bg bgVar;
        bj bjVar2;
        bj bjVar3;
        hVar = this.this$0.dzV;
        if (hVar != null) {
            bjVar = this.this$0.dFA;
            if (bjVar != null) {
                bgVar = this.this$0.dyP;
                if (com.baidu.tbadk.core.util.y.s(bgVar.aDz())) {
                    bjVar3 = this.this$0.dFA;
                    bjVar3.aEg();
                    return;
                }
                bjVar2 = this.this$0.dFA;
                bjVar2.aCx();
            }
        }
    }
}

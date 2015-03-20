package com.baidu.tieba.recommendfrs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements com.baidu.tbadk.core.flow.a.d<com.baidu.tieba.recommendfrs.data.a> {
    final /* synthetic */ b bXH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.bXH = bVar;
    }

    @Override // com.baidu.tbadk.core.flow.a.d
    public void m(int i, String str) {
        TiebaStatic.eventStat(this.bXH.getFragmentActivity(), "kantie_banner", "loc", i, new Object[0]);
        this.bXH.aS(str, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.flow.a.d
    public void a(int i, com.baidu.tieba.recommendfrs.data.a aVar) {
        com.baidu.tieba.recommendfrs.b.c cVar;
        com.baidu.tieba.recommendfrs.b.c cVar2;
        if (aVar != null) {
            cVar = this.bXH.bXB;
            if (cVar != null) {
                cVar2 = this.bXH.bXB;
                cVar2.setTitle(UtilHelper.getFixedText(aVar.afz(), 14, true));
            }
        }
    }
}

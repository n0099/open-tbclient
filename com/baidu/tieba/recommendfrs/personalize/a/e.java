package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.card.a.n;
import com.baidu.tieba.card.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements aq<n> {
    final /* synthetic */ d dqm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.dqm = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.aq
    public void a(View view, n nVar) {
        com.baidu.tieba.recommendfrs.control.a.f fVar;
        com.baidu.tieba.recommendfrs.control.a.f fVar2;
        fVar = this.dqm.dqk;
        if (fVar != null && nVar != null && nVar.Iv() != null && !StringUtils.isNull(nVar.Iv().getTid()) && (view.getTag() instanceof String) && !com.baidu.tieba.recommendfrs.d.bE(com.baidu.adp.lib.h.b.c(nVar.Iv().getTid(), 0L))) {
            com.baidu.tieba.recommendfrs.d.bD(com.baidu.adp.lib.h.b.c(nVar.Iv().getTid(), 0L));
            fVar2 = this.dqm.dqk;
            fVar2.a(com.baidu.adp.lib.h.b.c(nVar.Iv().getTid(), 0L), nVar.getWeight(), nVar.getSource(), nVar.Is(), nVar.Iu(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
        }
    }
}

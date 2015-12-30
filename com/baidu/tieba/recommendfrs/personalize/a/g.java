package com.baidu.tieba.recommendfrs.personalize.a;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.card.a.p;
import com.baidu.tieba.card.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements aq<p> {
    final /* synthetic */ f dqp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.dqp = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.aq
    public void a(View view, p pVar) {
        com.baidu.tieba.recommendfrs.control.a.f fVar;
        com.baidu.tieba.recommendfrs.control.a.f fVar2;
        fVar = this.dqp.dqk;
        if (fVar != null && pVar != null && pVar.Iv() != null && !StringUtils.isNull(pVar.Iv().getTid()) && (view.getTag() instanceof String) && !com.baidu.tieba.recommendfrs.d.bE(com.baidu.adp.lib.h.b.c(pVar.Iv().getTid(), 0L))) {
            com.baidu.tieba.recommendfrs.d.bD(com.baidu.adp.lib.h.b.c(pVar.Iv().getTid(), 0L));
            fVar2 = this.dqp.dqk;
            fVar2.a(com.baidu.adp.lib.h.b.c(pVar.Iv().getTid(), 0L), pVar.getWeight(), pVar.getSource(), pVar.Is(), pVar.Iu(), com.baidu.adp.lib.h.b.g((String) view.getTag(), 1));
        }
    }
}

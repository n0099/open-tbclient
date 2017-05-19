package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends cd<CardPersonDynamicThreadData> {
    final /* synthetic */ k eBP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.eBP = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        boolean z;
        as asVar = new as("c12042");
        z = this.eBP.bjW;
        TiebaStatic.log(asVar.s("obj_type", z ? 1 : 2));
    }
}

package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.ci;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends ci<CardPersonDynamicThreadData> {
    final /* synthetic */ k eUA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.eUA = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.ci
    public void a(View view, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        boolean z;
        au auVar = new au("c12042");
        z = this.eUA.boT;
        TiebaStatic.log(auVar.r("obj_type", z ? 1 : 2));
    }
}

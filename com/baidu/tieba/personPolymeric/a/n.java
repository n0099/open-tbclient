package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes.dex */
class n extends cf<CardPersonDynamicThreadData> {
    final /* synthetic */ k eEm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.eEm = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cf
    public void a(View view, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (!cardPersonDynamicThreadData.bho) {
            TiebaStatic.log(new as("c11595"));
        }
    }
}

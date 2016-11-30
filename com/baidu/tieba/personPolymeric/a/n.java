package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes.dex */
class n extends bz<CardPersonDynamicThreadData> {
    final /* synthetic */ k ePx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.ePx = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.bz
    public void a(View view, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (!cardPersonDynamicThreadData.bfT) {
            TiebaStatic.log(new av("c11595"));
        }
    }
}

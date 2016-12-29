package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.cb;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes.dex */
class n extends cb<CardPersonDynamicThreadData> {
    final /* synthetic */ k esT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.esT = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cb
    public void a(View view, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (!cardPersonDynamicThreadData.bfj) {
            TiebaStatic.log(new at("c11595"));
        }
    }
}

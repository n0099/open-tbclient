package com.baidu.tieba.personPolymeric.a;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.cd;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
/* loaded from: classes.dex */
class n extends cd<CardPersonDynamicThreadData> {
    final /* synthetic */ k eIY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.eIY = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.cd
    public void a(View view, CardPersonDynamicThreadData cardPersonDynamicThreadData) {
        if (!cardPersonDynamicThreadData.bcU) {
            TiebaStatic.log(new ax("c11595"));
        }
    }
}

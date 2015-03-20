package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ int bIB;
    final /* synthetic */ WriteActivity cyc;
    private final /* synthetic */ SpannableStringBuilder cyg;
    private final /* synthetic */ EmotionGroupType cyh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
        this.cyc = writeActivity;
        this.cyg = spannableStringBuilder;
        this.bIB = i;
        this.cyh = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((bi) aVar, str, i);
        if (aVar == null) {
            return;
        }
        this.cyc.a(this.cyg, this.bIB, aVar, this.cyh);
    }
}

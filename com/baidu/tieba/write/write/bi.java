package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ SpannableStringBuilder cyB;
    private final /* synthetic */ int cyC;
    private final /* synthetic */ EmotionGroupType cyD;
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
        this.cyx = writeActivity;
        this.cyB = spannableStringBuilder;
        this.cyC = i;
        this.cyD = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((bi) aVar, str, i);
        if (aVar == null) {
            return;
        }
        this.cyx.a(this.cyB, this.cyC, aVar, this.cyD);
    }
}

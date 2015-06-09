package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity cCQ;
    private final /* synthetic */ SpannableStringBuilder cCU;
    private final /* synthetic */ int cCV;
    private final /* synthetic */ EmotionGroupType cCW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
        this.cCQ = writeActivity;
        this.cCU = spannableStringBuilder;
        this.cCV = i;
        this.cCW = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((bj) aVar, str, i);
        if (aVar == null) {
            return;
        }
        this.cCQ.a(this.cCU, this.cCV, aVar, this.cCW);
    }
}

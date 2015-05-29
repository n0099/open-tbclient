package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity cCP;
    private final /* synthetic */ SpannableStringBuilder cCT;
    private final /* synthetic */ int cCU;
    private final /* synthetic */ EmotionGroupType cCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
        this.cCP = writeActivity;
        this.cCT = spannableStringBuilder;
        this.cCU = i;
        this.cCV = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((bj) aVar, str, i);
        if (aVar == null) {
            return;
        }
        this.cCP.a(this.cCT, this.cCU, aVar, this.cCV);
    }
}

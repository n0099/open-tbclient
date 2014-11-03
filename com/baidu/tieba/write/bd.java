package com.baidu.tieba.write;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity bUm;
    private final /* synthetic */ SpannableStringBuilder bUq;
    private final /* synthetic */ EmotionGroupType bUr;
    private final /* synthetic */ int val$pos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
        this.bUm = writeActivity;
        this.bUq = spannableStringBuilder;
        this.val$pos = i;
        this.bUr = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((bd) aVar, str, i);
        if (aVar == null) {
            return;
        }
        this.bUm.a(this.bUq, this.val$pos, aVar, this.bUr);
    }
}

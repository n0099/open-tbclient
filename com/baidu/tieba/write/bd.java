package com.baidu.tieba.write;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity cgR;
    private final /* synthetic */ SpannableStringBuilder cgV;
    private final /* synthetic */ int cgW;
    private final /* synthetic */ EmotionGroupType cgX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
        this.cgR = writeActivity;
        this.cgV = spannableStringBuilder;
        this.cgW = i;
        this.cgX = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((bd) aVar, str, i);
        if (aVar == null) {
            return;
        }
        this.cgR.a(this.cgV, this.cgW, aVar, this.cgX);
    }
}

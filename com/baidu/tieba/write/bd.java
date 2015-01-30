package com.baidu.tieba.write;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.lib.f.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity cgS;
    private final /* synthetic */ SpannableStringBuilder cgW;
    private final /* synthetic */ int cgX;
    private final /* synthetic */ EmotionGroupType cgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
        this.cgS = writeActivity;
        this.cgW = spannableStringBuilder;
        this.cgX = i;
        this.cgY = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.c
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.onLoaded((bd) aVar, str, i);
        if (aVar == null) {
            return;
        }
        this.cgS.a(this.cgW, this.cgX, aVar, this.cgY);
    }
}

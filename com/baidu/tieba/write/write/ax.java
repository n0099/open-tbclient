package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ SpannableStringBuilder bVA;
    private final /* synthetic */ int bVB;
    private final /* synthetic */ EmotionGroupType bVC;
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
        this.cUM = writeActivity;
        this.bVA = spannableStringBuilder;
        this.bVB = i;
        this.bVC = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((ax) aVar, str, i);
        if (aVar == null) {
            return;
        }
        this.cUM.a(this.bVA, this.bVB, aVar, this.bVC);
    }
}

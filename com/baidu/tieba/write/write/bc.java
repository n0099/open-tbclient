package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ SpannableStringBuilder caE;
    private final /* synthetic */ EmotionGroupType caG;
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.dsa = writeActivity;
        this.caE = spannableStringBuilder;
        this.caG = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText aEm;
        super.a((bc) aVar, str, i);
        if (aVar == null) {
            return;
        }
        aEm = this.dsa.aEm();
        this.dsa.a(this.caE, aEm.getSelectionStart(), aVar, this.caG);
    }
}

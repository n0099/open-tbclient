package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ SpannableStringBuilder aAE;
    private final /* synthetic */ EmotionGroupType aAF;
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.fUM = writeActivity;
        this.aAE = spannableStringBuilder;
        this.aAF = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bqs;
        super.onLoaded((au) aVar, str, i);
        if (aVar == null) {
            return;
        }
        bqs = this.fUM.bqs();
        this.fUM.a(this.aAE, bqs.getSelectionStart(), aVar, this.aAF);
    }
}

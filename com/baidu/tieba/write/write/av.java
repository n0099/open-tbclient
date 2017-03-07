package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ SpannableStringBuilder aAm;
    private final /* synthetic */ EmotionGroupType aAn;
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.fQG = writeActivity;
        this.aAm = spannableStringBuilder;
        this.aAn = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText boI;
        super.onLoaded((av) aVar, str, i);
        if (aVar == null) {
            return;
        }
        boI = this.fQG.boI();
        this.fQG.a(this.aAm, boI.getSelectionStart(), aVar, this.aAn);
    }
}

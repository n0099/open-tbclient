package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.lib.f.b<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ SpannableStringBuilder aBr;
    private final /* synthetic */ EmotionGroupType aBs;
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.glP = writeActivity;
        this.aBr = spannableStringBuilder;
        this.aBs = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.f.b
    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bus;
        super.onLoaded((aw) aVar, str, i);
        if (aVar == null) {
            return;
        }
        bus = this.glP.bus();
        this.glP.a(this.aBr, bus.getSelectionStart(), aVar, this.aBs);
    }
}

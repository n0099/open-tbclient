package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ SpannableStringBuilder arg;
    private final /* synthetic */ EmotionGroupType arh;
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.feb = writeActivity;
        this.arg = spannableStringBuilder;
        this.arh = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bdN;
        super.a((bb) aVar, str, i);
        if (aVar == null) {
            return;
        }
        bdN = this.feb.bdN();
        this.feb.a(this.arg, bdN.getSelectionStart(), aVar, this.arh);
    }
}

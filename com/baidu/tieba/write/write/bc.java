package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ SpannableStringBuilder atP;
    private final /* synthetic */ EmotionGroupType atQ;
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.dYD = writeActivity;
        this.atP = spannableStringBuilder;
        this.atQ = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText aMe;
        super.a((bc) aVar, str, i);
        if (aVar == null) {
            return;
        }
        aMe = this.dYD.aMe();
        this.dYD.a(this.atP, aMe.getSelectionStart(), aVar, this.atQ);
    }
}

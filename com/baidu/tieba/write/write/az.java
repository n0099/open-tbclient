package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ SpannableStringBuilder auH;
    private final /* synthetic */ EmotionGroupType auI;
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.ets = writeActivity;
        this.auH = spannableStringBuilder;
        this.auI = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText aUY;
        super.a((az) aVar, str, i);
        if (aVar == null) {
            return;
        }
        aUY = this.ets.aUY();
        this.ets.a(this.auH, aUY.getSelectionStart(), aVar, this.auI);
    }
}

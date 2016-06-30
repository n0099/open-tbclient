package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ SpannableStringBuilder arW;
    private final /* synthetic */ EmotionGroupType arX;
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.fJw = writeActivity;
        this.arW = spannableStringBuilder;
        this.arX = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bmp;
        super.a((ax) aVar, str, i);
        if (aVar == null) {
            return;
        }
        bmp = this.fJw.bmp();
        this.fJw.a(this.arW, bmp.getSelectionStart(), aVar, this.arX);
    }
}

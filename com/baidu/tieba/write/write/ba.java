package com.baidu.tieba.write.write;

import android.text.SpannableStringBuilder;
import android.widget.EditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.lib.g.b<com.baidu.adp.widget.a.a> {
    private final /* synthetic */ SpannableStringBuilder avh;
    private final /* synthetic */ EmotionGroupType avi;
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, EmotionGroupType emotionGroupType) {
        this.eNd = writeActivity;
        this.avh = spannableStringBuilder;
        this.avi = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.g.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        EditText bby;
        super.a((ba) aVar, str, i);
        if (aVar == null) {
            return;
        }
        bby = this.eNd.bby();
        this.eNd.a(this.avh, bby.getSelectionStart(), aVar, this.avi);
    }
}

package com.baidu.tieba.write;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av extends com.baidu.adp.lib.resourceLoader.c<com.baidu.adp.widget.a.a> {
    final /* synthetic */ WriteActivity a;
    private final /* synthetic */ SpannableStringBuilder b;
    private final /* synthetic */ int c;
    private final /* synthetic */ EmotionGroupType d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
        this.a = writeActivity;
        this.b = spannableStringBuilder;
        this.c = i;
        this.d = emotionGroupType;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.resourceLoader.c
    public void a(com.baidu.adp.widget.a.a aVar, String str, int i) {
        super.a((av) aVar, str, i);
        if (aVar == null) {
            return;
        }
        this.a.a(this.b, this.c, aVar, this.d);
    }
}

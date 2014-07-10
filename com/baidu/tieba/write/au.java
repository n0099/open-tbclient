package com.baidu.tieba.write;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ WriteActivity a;
    private final /* synthetic */ SpannableStringBuilder b;
    private final /* synthetic */ int c;
    private final /* synthetic */ EmotionGroupType d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
        this.a = writeActivity;
        this.b = spannableStringBuilder;
        this.c = i;
        this.d = emotionGroupType;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        if (aVar == null) {
            return;
        }
        this.a.a(this.b, this.c, aVar, this.d);
    }
}

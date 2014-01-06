package com.baidu.tieba.write;

import android.text.SpannableStringBuilder;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.imageManager.c {
    final /* synthetic */ SpannableStringBuilder a;
    final /* synthetic */ int b;
    final /* synthetic */ WritableEmotionGroup.EmotionGroupType c;
    final /* synthetic */ WriteActivity d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, int i, WritableEmotionGroup.EmotionGroupType emotionGroupType) {
        this.d = writeActivity;
        this.a = spannableStringBuilder;
        this.b = i;
        this.c = emotionGroupType;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.d dVar, String str, boolean z) {
        if (dVar != null) {
            this.d.a(this.a, this.b, dVar, this.c);
        }
    }
}

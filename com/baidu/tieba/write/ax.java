package com.baidu.tieba.write;

import android.text.SpannableStringBuilder;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ WriteActivity a;
    private final /* synthetic */ SpannableStringBuilder b;
    private final /* synthetic */ int c;
    private final /* synthetic */ WritableEmotionGroup.EmotionGroupType d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, int i, WritableEmotionGroup.EmotionGroupType emotionGroupType) {
        this.a = writeActivity;
        this.b = spannableStringBuilder;
        this.c = i;
        this.d = emotionGroupType;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar == null) {
            return;
        }
        this.a.a(this.b, this.c, bVar, this.d);
    }
}

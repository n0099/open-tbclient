package com.baidu.tieba.write;

import android.text.SpannableStringBuilder;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class at implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ WriteActivity a;
    private final /* synthetic */ SpannableStringBuilder b;
    private final /* synthetic */ int c;
    private final /* synthetic */ EmotionGroupType d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(WriteActivity writeActivity, SpannableStringBuilder spannableStringBuilder, int i, EmotionGroupType emotionGroupType) {
        this.a = writeActivity;
        this.b = spannableStringBuilder;
        this.c = i;
        this.d = emotionGroupType;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            WriteActivity writeActivity = this.a;
            SpannableStringBuilder spannableStringBuilder = this.b;
            int i = this.c;
            EmotionGroupType emotionGroupType = this.d;
            writeActivity.a(spannableStringBuilder, i, bVar);
        }
    }
}

package com.baidu.tieba.pb.pb.main.emotion;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ PbSearchEmotionActivity evD;
    private final /* synthetic */ EmotionImageData evF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbSearchEmotionActivity pbSearchEmotionActivity, EmotionImageData emotionImageData) {
        this.evD = pbSearchEmotionActivity;
        this.evF = emotionImageData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.evD.a(this.evF);
    }
}

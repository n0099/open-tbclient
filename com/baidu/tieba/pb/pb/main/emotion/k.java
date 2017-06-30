package com.baidu.tieba.pb.pb.main.emotion;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.b {
    final /* synthetic */ PbSearchEmotionActivity eET;
    private final /* synthetic */ EmotionImageData eEV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbSearchEmotionActivity pbSearchEmotionActivity, EmotionImageData emotionImageData) {
        this.eET = pbSearchEmotionActivity;
        this.eEV = emotionImageData;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        aVar.dismiss();
        this.eET.a(this.eEV);
    }
}

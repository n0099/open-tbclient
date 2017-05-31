package com.baidu.tieba.pb.pb.main.emotion;

import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
/* loaded from: classes.dex */
class e implements a {
    final /* synthetic */ PbSearchEmotionActivity evD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbSearchEmotionActivity pbSearchEmotionActivity) {
        this.evD = pbSearchEmotionActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.a
    public void b(EmotionImageData emotionImageData) {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        if (bVar.getBoolean("search_emotion_first_send", true)) {
            bVar.putBoolean("search_emotion_first_send", false);
            this.evD.d(emotionImageData);
            return;
        }
        this.evD.a(emotionImageData);
    }
}

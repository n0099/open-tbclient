package com.baidu.tieba.pb.pb.main.emotion;

import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
/* loaded from: classes.dex */
class e implements a {
    final /* synthetic */ PbSearchEmotionActivity eET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PbSearchEmotionActivity pbSearchEmotionActivity) {
        this.eET = pbSearchEmotionActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.a
    public void b(EmotionImageData emotionImageData) {
        com.baidu.tbadk.core.sharedPref.b bVar = com.baidu.tbadk.core.sharedPref.b.getInstance();
        if (bVar.getBoolean("search_emotion_first_send", true)) {
            bVar.putBoolean("search_emotion_first_send", false);
            this.eET.d(emotionImageData);
            return;
        }
        this.eET.a(emotionImageData);
    }
}

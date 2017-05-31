package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.emotion.data.EmotionImageData;
/* loaded from: classes.dex */
class p implements com.baidu.tieba.pb.pb.main.emotion.a {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.emotion.a
    public void b(EmotionImageData emotionImageData) {
        this.enc.a(emotionImageData);
    }
}

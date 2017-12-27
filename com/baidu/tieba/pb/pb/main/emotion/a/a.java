package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> djY;
    private List<String> fSc;
    private SingleBarEmotionRecommendData fSd;

    public SingleBarEmotionRecommendData beq() {
        return this.fSd;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fSd = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> apm() {
        return this.djY;
    }

    public void aW(List<EmotionImageData> list) {
        this.djY = list;
    }

    public List<String> ber() {
        return this.fSc;
    }

    public void cY(List<String> list) {
        this.fSc = list;
    }
}

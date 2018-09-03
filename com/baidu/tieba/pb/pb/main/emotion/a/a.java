package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> cVq;
    private List<String> fHY;
    private SingleBarEmotionRecommendData fHZ;

    public SingleBarEmotionRecommendData beR() {
        return this.fHZ;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fHZ = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> apB() {
        return this.cVq;
    }

    public void aX(List<EmotionImageData> list) {
        this.cVq = list;
    }

    public List<String> beS() {
        return this.fHY;
    }

    public void cY(List<String> list) {
        this.fHY = list;
    }
}

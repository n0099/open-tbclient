package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<EmotionImageData> gaF;
    private List<String> iRN;
    private SingleBarEmotionRecommendData iRO;

    public SingleBarEmotionRecommendData cqP() {
        return this.iRO;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.iRO = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bzQ() {
        return this.gaF;
    }

    public void bQ(List<EmotionImageData> list) {
        this.gaF = list;
    }

    public List<String> cqQ() {
        return this.iRN;
    }

    public void dJ(List<String> list) {
        this.iRN = list;
    }
}

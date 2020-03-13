package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<EmotionImageData> gaS;
    private List<String> iRZ;
    private SingleBarEmotionRecommendData iSa;

    public SingleBarEmotionRecommendData cqQ() {
        return this.iSa;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.iSa = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bzR() {
        return this.gaS;
    }

    public void bQ(List<EmotionImageData> list) {
        this.gaS = list;
    }

    public List<String> cqR() {
        return this.iRZ;
    }

    public void dJ(List<String> list) {
        this.iRZ = list;
    }
}

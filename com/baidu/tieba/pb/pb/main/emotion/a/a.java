package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<EmotionImageData> fhG;
    private List<String> hYD;
    private SingleBarEmotionRecommendData hYE;

    public SingleBarEmotionRecommendData bWx() {
        return this.hYE;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.hYE = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bfR() {
        return this.fhG;
    }

    public void bY(List<EmotionImageData> list) {
        this.fhG = list;
    }

    public List<String> bWy() {
        return this.hYD;
    }

    public void dY(List<String> list) {
        this.hYD = list;
    }
}

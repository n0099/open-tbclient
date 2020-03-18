package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<EmotionImageData> gbA;
    private List<String> iTA;
    private SingleBarEmotionRecommendData iTB;

    public SingleBarEmotionRecommendData crl() {
        return this.iTB;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.iTB = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bzX() {
        return this.gbA;
    }

    public void bQ(List<EmotionImageData> list) {
        this.gbA = list;
    }

    public List<String> crm() {
        return this.iTA;
    }

    public void dJ(List<String> list) {
        this.iTA = list;
    }
}

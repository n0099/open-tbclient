package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<EmotionImageData> gaD;
    private List<String> iRL;
    private SingleBarEmotionRecommendData iRM;

    public SingleBarEmotionRecommendData cqN() {
        return this.iRM;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.iRM = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bzO() {
        return this.gaD;
    }

    public void bQ(List<EmotionImageData> list) {
        this.gaD = list;
    }

    public List<String> cqO() {
        return this.iRL;
    }

    public void dJ(List<String> list) {
        this.iRL = list;
    }
}

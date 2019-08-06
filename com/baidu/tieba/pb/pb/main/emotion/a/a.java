package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<EmotionImageData> fdj;
    private List<String> hXY;
    private SingleBarEmotionRecommendData hXZ;

    public SingleBarEmotionRecommendData bYI() {
        return this.hXZ;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.hXZ = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bho() {
        return this.fdj;
    }

    public void bL(List<EmotionImageData> list) {
        this.fdj = list;
    }

    public List<String> bYJ() {
        return this.hXY;
    }

    public void dL(List<String> list) {
        this.hXY = list;
    }
}

package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<EmotionImageData> feW;
    private List<String> hZV;
    private SingleBarEmotionRecommendData hZW;

    public SingleBarEmotionRecommendData bZv() {
        return this.hZW;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.hZW = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bhZ() {
        return this.feW;
    }

    public void bL(List<EmotionImageData> list) {
        this.feW = list;
    }

    public List<String> bZw() {
        return this.hZV;
    }

    public void dL(List<String> list) {
        this.hZV = list;
    }
}

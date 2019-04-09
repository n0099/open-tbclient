package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<EmotionImageData> eHy;
    private List<String> hzb;
    private SingleBarEmotionRecommendData hzc;

    public SingleBarEmotionRecommendData bNG() {
        return this.hzc;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.hzc = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> aXH() {
        return this.eHy;
    }

    public void bB(List<EmotionImageData> list) {
        this.eHy = list;
    }

    public List<String> bNH() {
        return this.hzb;
    }

    public void dC(List<String> list) {
        this.hzb = list;
    }
}

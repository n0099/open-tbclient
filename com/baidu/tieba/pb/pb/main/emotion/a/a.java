package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<EmotionImageData> eHx;
    private List<String> hza;
    private SingleBarEmotionRecommendData hzb;

    public SingleBarEmotionRecommendData bNG() {
        return this.hzb;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.hzb = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> aXH() {
        return this.eHx;
    }

    public void bB(List<EmotionImageData> list) {
        this.eHx = list;
    }

    public List<String> bNH() {
        return this.hza;
    }

    public void dC(List<String> list) {
        this.hza = list;
    }
}

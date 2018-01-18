package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> doz;
    private List<String> fTC;
    private SingleBarEmotionRecommendData fTD;

    public SingleBarEmotionRecommendData beu() {
        return this.fTD;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fTD = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> aqp() {
        return this.doz;
    }

    public void aU(List<EmotionImageData> list) {
        this.doz = list;
    }

    public List<String> bev() {
        return this.fTC;
    }

    public void cS(List<String> list) {
        this.fTC = list;
    }
}

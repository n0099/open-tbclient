package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<EmotionImageData> eXI;
    private List<String> hQP;
    private SingleBarEmotionRecommendData hQQ;

    public SingleBarEmotionRecommendData bVD() {
        return this.hQQ;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.hQQ = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bfe() {
        return this.eXI;
    }

    public void bJ(List<EmotionImageData> list) {
        this.eXI = list;
    }

    public List<String> bVE() {
        return this.hQP;
    }

    public void dK(List<String> list) {
        this.hQP = list;
    }
}

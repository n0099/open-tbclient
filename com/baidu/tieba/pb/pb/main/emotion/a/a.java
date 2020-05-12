package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<EmotionImageData> gKP;
    private List<String> jDN;
    private SingleBarEmotionRecommendData jDO;

    public SingleBarEmotionRecommendData cBP() {
        return this.jDO;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.jDO = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bKx() {
        return this.gKP;
    }

    public void cc(List<EmotionImageData> list) {
        this.gKP = list;
    }

    public List<String> cBQ() {
        return this.jDN;
    }

    public void dU(List<String> list) {
        this.jDN = list;
    }
}

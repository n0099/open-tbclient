package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<EmotionImageData> gZB;
    private List<String> jVm;
    private SingleBarEmotionRecommendData jVn;

    public SingleBarEmotionRecommendData cIM() {
        return this.jVn;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.jVn = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bQS() {
        return this.gZB;
    }

    public void bZ(List<EmotionImageData> list) {
        this.gZB = list;
    }

    public List<String> cIN() {
        return this.jVm;
    }

    public void ea(List<String> list) {
        this.jVm = list;
    }
}

package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> cSH;
    private List<String> fHQ;
    private SingleBarEmotionRecommendData fHR;

    public SingleBarEmotionRecommendData bgD() {
        return this.fHR;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fHR = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> apa() {
        return this.cSH;
    }

    public void aY(List<EmotionImageData> list) {
        this.cSH = list;
    }

    public List<String> bgE() {
        return this.fHQ;
    }

    public void dc(List<String> list) {
        this.fHQ = list;
    }
}

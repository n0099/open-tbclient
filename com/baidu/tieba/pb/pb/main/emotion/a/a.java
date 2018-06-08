package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> cUF;
    private List<String> fDP;
    private SingleBarEmotionRecommendData fDQ;

    public SingleBarEmotionRecommendData bfV() {
        return this.fDQ;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fDQ = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> apG() {
        return this.cUF;
    }

    public void aX(List<EmotionImageData> list) {
        this.cUF = list;
    }

    public List<String> bfW() {
        return this.fDP;
    }

    public void cY(List<String> list) {
        this.fDP = list;
    }
}

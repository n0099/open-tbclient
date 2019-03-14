package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<EmotionImageData> eHL;
    private List<String> hzo;
    private SingleBarEmotionRecommendData hzp;

    public SingleBarEmotionRecommendData bNJ() {
        return this.hzp;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.hzp = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> aXK() {
        return this.eHL;
    }

    public void bD(List<EmotionImageData> list) {
        this.eHL = list;
    }

    public List<String> bNK() {
        return this.hzo;
    }

    public void dF(List<String> list) {
        this.hzo = list;
    }
}

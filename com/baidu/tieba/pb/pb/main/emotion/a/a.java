package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<EmotionImageData> eHP;
    private List<String> hzt;
    private SingleBarEmotionRecommendData hzu;

    public SingleBarEmotionRecommendData bNI() {
        return this.hzu;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.hzu = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> aXK() {
        return this.eHP;
    }

    public void bD(List<EmotionImageData> list) {
        this.eHP = list;
    }

    public List<String> bNJ() {
        return this.hzt;
    }

    public void dF(List<String> list) {
        this.hzt = list;
    }
}

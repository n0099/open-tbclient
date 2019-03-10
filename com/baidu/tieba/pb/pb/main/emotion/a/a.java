package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<EmotionImageData> eHP;
    private List<String> hzu;
    private SingleBarEmotionRecommendData hzv;

    public SingleBarEmotionRecommendData bNJ() {
        return this.hzv;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.hzv = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> aXL() {
        return this.eHP;
    }

    public void bD(List<EmotionImageData> list) {
        this.eHP = list;
    }

    public List<String> bNK() {
        return this.hzu;
    }

    public void dF(List<String> list) {
        this.hzu = list;
    }
}

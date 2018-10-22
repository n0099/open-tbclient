package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<EmotionImageData> djt;
    private List<String> fXf;
    private SingleBarEmotionRecommendData fXg;

    public SingleBarEmotionRecommendData bkH() {
        return this.fXg;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fXg = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> auM() {
        return this.djt;
    }

    public void bo(List<EmotionImageData> list) {
        this.djt = list;
    }

    public List<String> bkI() {
        return this.fXf;
    }

    public void dn(List<String> list) {
        this.fXf = list;
    }
}

package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<EmotionImageData> djt;
    private List<String> fXe;
    private SingleBarEmotionRecommendData fXf;

    public SingleBarEmotionRecommendData bkH() {
        return this.fXf;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fXf = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> auL() {
        return this.djt;
    }

    public void bo(List<EmotionImageData> list) {
        this.djt = list;
    }

    public List<String> bkI() {
        return this.fXe;
    }

    public void dn(List<String> list) {
        this.fXe = list;
    }
}

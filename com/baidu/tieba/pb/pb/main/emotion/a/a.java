package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<EmotionImageData> fcJ;
    private List<String> hXc;
    private SingleBarEmotionRecommendData hXd;

    public SingleBarEmotionRecommendData bYr() {
        return this.hXd;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.hXd = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bhh() {
        return this.fcJ;
    }

    public void bL(List<EmotionImageData> list) {
        this.fcJ = list;
    }

    public List<String> bYs() {
        return this.hXc;
    }

    public void dM(List<String> list) {
        this.hXc = list;
    }
}

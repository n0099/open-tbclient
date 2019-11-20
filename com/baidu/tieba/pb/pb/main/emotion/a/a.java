package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<EmotionImageData> fgP;
    private List<String> hXM;
    private SingleBarEmotionRecommendData hXN;

    public SingleBarEmotionRecommendData bWv() {
        return this.hXN;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.hXN = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bfP() {
        return this.fgP;
    }

    public void bY(List<EmotionImageData> list) {
        this.fgP = list;
    }

    public List<String> bWw() {
        return this.hXM;
    }

    public void dY(List<String> list) {
        this.hXM = list;
    }
}

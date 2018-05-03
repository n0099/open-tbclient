package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> cKs;
    private List<String> frq;
    private SingleBarEmotionRecommendData frr;

    public SingleBarEmotionRecommendData baW() {
        return this.frr;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.frr = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> alA() {
        return this.cKs;
    }

    public void aR(List<EmotionImageData> list) {
        this.cKs = list;
    }

    public List<String> baX() {
        return this.frq;
    }

    public void cQ(List<String> list) {
        this.frq = list;
    }
}

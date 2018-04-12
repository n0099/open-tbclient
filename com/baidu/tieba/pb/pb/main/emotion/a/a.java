package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> cKv;
    private List<String> fru;
    private SingleBarEmotionRecommendData frv;

    public SingleBarEmotionRecommendData baW() {
        return this.frv;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.frv = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> alA() {
        return this.cKv;
    }

    public void aR(List<EmotionImageData> list) {
        this.cKv = list;
    }

    public List<String> baX() {
        return this.fru;
    }

    public void cQ(List<String> list) {
        this.fru = list;
    }
}

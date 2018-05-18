package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> cLz;
    private List<String> fsy;
    private SingleBarEmotionRecommendData fsz;

    public SingleBarEmotionRecommendData baW() {
        return this.fsz;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fsz = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> alA() {
        return this.cLz;
    }

    public void aU(List<EmotionImageData> list) {
        this.cLz = list;
    }

    public List<String> baX() {
        return this.fsy;
    }

    public void cT(List<String> list) {
        this.fsy = list;
    }
}

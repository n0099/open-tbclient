package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> iUs;
    private List<String> mfy;
    private SingleBarEmotionRecommendData mfz;

    public SingleBarEmotionRecommendData dso() {
        return this.mfz;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.mfz = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> cyt() {
        return this.iUs;
    }

    public void cV(List<EmotionImageData> list) {
        this.iUs = list;
    }

    public List<String> dsp() {
        return this.mfy;
    }

    public void fp(List<String> list) {
        this.mfy = list;
    }
}

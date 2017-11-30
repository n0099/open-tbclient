package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> cvp;
    private List<String> fed;
    private SingleBarEmotionRecommendData fee;

    public SingleBarEmotionRecommendData aWT() {
        return this.fee;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fee = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> ahF() {
        return this.cvp;
    }

    public void aL(List<EmotionImageData> list) {
        this.cvp = list;
    }

    public List<String> aWU() {
        return this.fed;
    }

    public void cM(List<String> list) {
        this.fed = list;
    }
}

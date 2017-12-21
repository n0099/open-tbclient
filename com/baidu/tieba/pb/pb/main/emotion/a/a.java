package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> cvC;
    private List<String> ffj;
    private SingleBarEmotionRecommendData ffk;

    public SingleBarEmotionRecommendData aXc() {
        return this.ffk;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.ffk = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> ahM() {
        return this.cvC;
    }

    public void aL(List<EmotionImageData> list) {
        this.cvC = list;
    }

    public List<String> aXd() {
        return this.ffj;
    }

    public void cN(List<String> list) {
        this.ffj = list;
    }
}

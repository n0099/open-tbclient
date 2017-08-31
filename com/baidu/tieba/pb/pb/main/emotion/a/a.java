package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> ceo;
    private List<String> eRS;
    private SingleBarEmotionRecommendData eRT;

    public SingleBarEmotionRecommendData aTO() {
        return this.eRT;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.eRT = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> adM() {
        return this.ceo;
    }

    public void ay(List<EmotionImageData> list) {
        this.ceo = list;
    }

    public List<String> aTP() {
        return this.eRS;
    }

    public void cE(List<String> list) {
        this.eRS = list;
    }
}

package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> cmB;
    private List<String> eVJ;
    private SingleBarEmotionRecommendData eVK;

    public SingleBarEmotionRecommendData aVz() {
        return this.eVK;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.eVK = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> afU() {
        return this.cmB;
    }

    public void az(List<EmotionImageData> list) {
        this.cmB = list;
    }

    public List<String> aVA() {
        return this.eVJ;
    }

    public void cz(List<String> list) {
        this.eVJ = list;
    }
}

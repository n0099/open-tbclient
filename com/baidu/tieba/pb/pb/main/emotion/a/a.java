package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> drE;
    private List<String> fXo;
    private SingleBarEmotionRecommendData fXp;

    public SingleBarEmotionRecommendData bfZ() {
        return this.fXp;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fXp = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> ark() {
        return this.drE;
    }

    public void aW(List<EmotionImageData> list) {
        this.drE = list;
    }

    public List<String> bga() {
        return this.fXo;
    }

    public void cY(List<String> list) {
        this.fXo = list;
    }
}

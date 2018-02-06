package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> drN;
    private List<String> fXj;
    private SingleBarEmotionRecommendData fXk;

    public SingleBarEmotionRecommendData bfZ() {
        return this.fXk;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fXk = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> ark() {
        return this.drN;
    }

    public void aW(List<EmotionImageData> list) {
        this.drN = list;
    }

    public List<String> bga() {
        return this.fXj;
    }

    public void cY(List<String> list) {
        this.fXj = list;
    }
}

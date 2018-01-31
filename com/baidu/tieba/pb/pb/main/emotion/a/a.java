package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> doU;
    private List<String> fTX;
    private SingleBarEmotionRecommendData fTY;

    public SingleBarEmotionRecommendData bez() {
        return this.fTY;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fTY = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> aqu() {
        return this.doU;
    }

    public void aU(List<EmotionImageData> list) {
        this.doU = list;
    }

    public List<String> beA() {
        return this.fTX;
    }

    public void cS(List<String> list) {
        this.fTX = list;
    }
}

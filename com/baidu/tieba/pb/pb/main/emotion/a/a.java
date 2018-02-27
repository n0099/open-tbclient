package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> drB;
    private List<String> fWY;
    private SingleBarEmotionRecommendData fWZ;

    public SingleBarEmotionRecommendData bfY() {
        return this.fWZ;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fWZ = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> arj() {
        return this.drB;
    }

    public void aW(List<EmotionImageData> list) {
        this.drB = list;
    }

    public List<String> bfZ() {
        return this.fWY;
    }

    public void cY(List<String> list) {
        this.fWY = list;
    }
}

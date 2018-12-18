package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<EmotionImageData> dra;
    private List<String> gfv;
    private SingleBarEmotionRecommendData gfw;

    public SingleBarEmotionRecommendData blW() {
        return this.gfw;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.gfw = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> avV() {
        return this.dra;
    }

    public void bo(List<EmotionImageData> list) {
        this.dra = list;
    }

    public List<String> blX() {
        return this.gfv;
    }

    public void dp(List<String> list) {
        this.gfv = list;
    }
}

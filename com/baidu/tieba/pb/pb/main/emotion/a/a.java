package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<EmotionImageData> hlY;
    private List<String> kqi;
    private SingleBarEmotionRecommendData kqj;

    public SingleBarEmotionRecommendData cNu() {
        return this.kqj;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.kqj = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bTR() {
        return this.hlY;
    }

    public void ci(List<EmotionImageData> list) {
        this.hlY = list;
    }

    public List<String> cNv() {
        return this.kqi;
    }

    public void eq(List<String> list) {
        this.kqi = list;
    }
}

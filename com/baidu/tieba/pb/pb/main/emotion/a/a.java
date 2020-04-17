package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<EmotionImageData> gKJ;
    private List<String> jDJ;
    private SingleBarEmotionRecommendData jDK;

    public SingleBarEmotionRecommendData cBR() {
        return this.jDK;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.jDK = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bKy() {
        return this.gKJ;
    }

    public void cc(List<EmotionImageData> list) {
        this.gKJ = list;
    }

    public List<String> cBS() {
        return this.jDJ;
    }

    public void dU(List<String> list) {
        this.jDJ = list;
    }
}

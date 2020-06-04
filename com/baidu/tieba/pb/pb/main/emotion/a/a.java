package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<EmotionImageData> gZM;
    private List<String> jWs;
    private SingleBarEmotionRecommendData jWt;

    public SingleBarEmotionRecommendData cJc() {
        return this.jWt;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.jWt = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bQU() {
        return this.gZM;
    }

    public void bZ(List<EmotionImageData> list) {
        this.gZM = list;
    }

    public List<String> cJd() {
        return this.jWs;
    }

    public void ec(List<String> list) {
        this.jWs = list;
    }
}

package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<EmotionImageData> eXH;
    private List<String> hQL;
    private SingleBarEmotionRecommendData hQM;

    public SingleBarEmotionRecommendData bVz() {
        return this.hQM;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.hQM = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bfb() {
        return this.eXH;
    }

    public void bJ(List<EmotionImageData> list) {
        this.eXH = list;
    }

    public List<String> bVA() {
        return this.hQL;
    }

    public void dK(List<String> list) {
        this.hQL = list;
    }
}

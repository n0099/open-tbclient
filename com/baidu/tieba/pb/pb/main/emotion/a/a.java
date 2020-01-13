package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<EmotionImageData> fYD;
    private List<String> iQq;
    private SingleBarEmotionRecommendData iQr;

    public SingleBarEmotionRecommendData cpu() {
        return this.iQr;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.iQr = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bym() {
        return this.fYD;
    }

    public void bU(List<EmotionImageData> list) {
        this.fYD = list;
    }

    public List<String> cpv() {
        return this.iQq;
    }

    public void dN(List<String> list) {
        this.iQq = list;
    }
}

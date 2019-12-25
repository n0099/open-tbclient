package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<EmotionImageData> fVu;
    private List<String> iMM;
    private SingleBarEmotionRecommendData iMN;

    public SingleBarEmotionRecommendData con() {
        return this.iMN;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.iMN = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bxk() {
        return this.fVu;
    }

    public void bU(List<EmotionImageData> list) {
        this.fVu = list;
    }

    public List<String> coo() {
        return this.iMM;
    }

    public void dN(List<String> list) {
        this.iMM = list;
    }
}

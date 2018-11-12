package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<EmotionImageData> dky;
    private List<String> fYE;
    private SingleBarEmotionRecommendData fYF;

    public SingleBarEmotionRecommendData bke() {
        return this.fYF;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fYF = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> auk() {
        return this.dky;
    }

    public void bm(List<EmotionImageData> list) {
        this.dky = list;
    }

    public List<String> bkf() {
        return this.fYE;
    }

    public void dl(List<String> list) {
        this.fYE = list;
    }
}

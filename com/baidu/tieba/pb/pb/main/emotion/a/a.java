package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> iRv;
    private List<String> lYH;
    private SingleBarEmotionRecommendData lYI;

    public SingleBarEmotionRecommendData dtB() {
        return this.lYI;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.lYI = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> cAM() {
        return this.iRv;
    }

    public void da(List<EmotionImageData> list) {
        this.iRv = list;
    }

    public List<String> dtC() {
        return this.lYH;
    }

    public void fr(List<String> list) {
        this.lYH = list;
    }
}

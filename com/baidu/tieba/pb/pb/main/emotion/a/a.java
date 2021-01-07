package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> iRv;
    private List<String> lYG;
    private SingleBarEmotionRecommendData lYH;

    public SingleBarEmotionRecommendData dtC() {
        return this.lYH;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.lYH = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> cAN() {
        return this.iRv;
    }

    public void da(List<EmotionImageData> list) {
        this.iRv = list;
    }

    public List<String> dtD() {
        return this.lYG;
    }

    public void fr(List<String> list) {
        this.lYG = list;
    }
}

package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private List<EmotionImageData> hMh;
    private List<String> kXw;
    private SingleBarEmotionRecommendData kXx;

    public SingleBarEmotionRecommendData dfC() {
        return this.kXx;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.kXx = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> ckU() {
        return this.hMh;
    }

    public void cv(List<EmotionImageData> list) {
        this.hMh = list;
    }

    public List<String> dfD() {
        return this.kXw;
    }

    public void eM(List<String> list) {
        this.kXw = list;
    }
}

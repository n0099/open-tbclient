package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<EmotionImageData> duy;
    private List<String> gjs;
    private SingleBarEmotionRecommendData gjt;

    public SingleBarEmotionRecommendData bnq() {
        return this.gjt;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.gjt = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> axh() {
        return this.duy;
    }

    public void bq(List<EmotionImageData> list) {
        this.duy = list;
    }

    public List<String> bnr() {
        return this.gjs;
    }

    public void dr(List<String> list) {
        this.gjs = list;
    }
}

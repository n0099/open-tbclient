package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<EmotionImageData> dux;
    private List<String> gjr;
    private SingleBarEmotionRecommendData gjs;

    public SingleBarEmotionRecommendData bnq() {
        return this.gjs;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.gjs = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> axh() {
        return this.dux;
    }

    public void bq(List<EmotionImageData> list) {
        this.dux = list;
    }

    public List<String> bnr() {
        return this.gjr;
    }

    public void dr(List<String> list) {
        this.gjr = list;
    }
}

package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private List<EmotionImageData> iup;
    private List<String> lFA;
    private SingleBarEmotionRecommendData lFB;

    public SingleBarEmotionRecommendData dou() {
        return this.lFB;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.lFB = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> ctD() {
        return this.iup;
    }

    public void cP(List<EmotionImageData> list) {
        this.iup = list;
    }

    public List<String> dov() {
        return this.lFA;
    }

    public void fg(List<String> list) {
        this.lFA = list;
    }
}

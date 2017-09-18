package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> cfg;
    private List<String> eSM;
    private SingleBarEmotionRecommendData eSN;

    public SingleBarEmotionRecommendData aTZ() {
        return this.eSN;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.eSN = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> adX() {
        return this.cfg;
    }

    public void ay(List<EmotionImageData> list) {
        this.cfg = list;
    }

    public List<String> aUa() {
        return this.eSM;
    }

    public void cF(List<String> list) {
        this.eSM = list;
    }
}

package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private List<EmotionImageData> hFa;
    private List<String> kON;
    private SingleBarEmotionRecommendData kOO;

    public SingleBarEmotionRecommendData dbX() {
        return this.kOO;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.kOO = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> chG() {
        return this.hFa;
    }

    public void cp(List<EmotionImageData> list) {
        this.hFa = list;
    }

    public List<String> dbY() {
        return this.kON;
    }

    public void eE(List<String> list) {
        this.kON = list;
    }
}

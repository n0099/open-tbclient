package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private List<EmotionImageData> hFg;
    private List<String> kOU;
    private SingleBarEmotionRecommendData kOV;

    public SingleBarEmotionRecommendData dbY() {
        return this.kOV;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.kOV = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> chH() {
        return this.hFg;
    }

    public void cp(List<EmotionImageData> list) {
        this.hFg = list;
    }

    public List<String> dbZ() {
        return this.kOU;
    }

    public void eE(List<String> list) {
        this.kOU = list;
    }
}

package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private List<EmotionImageData> hrK;
    private List<String> kzg;
    private SingleBarEmotionRecommendData kzh;

    public SingleBarEmotionRecommendData cRh() {
        return this.kzh;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.kzh = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bXk() {
        return this.hrK;
    }

    public void cn(List<EmotionImageData> list) {
        this.hrK = list;
    }

    public List<String> cRi() {
        return this.kzg;
    }

    public void ew(List<String> list) {
        this.kzg = list;
    }
}

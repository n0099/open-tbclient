package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private List<EmotionImageData> hrK;
    private List<String> kzi;
    private SingleBarEmotionRecommendData kzj;

    public SingleBarEmotionRecommendData cRh() {
        return this.kzj;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.kzj = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> bXk() {
        return this.hrK;
    }

    public void cn(List<EmotionImageData> list) {
        this.hrK = list;
    }

    public List<String> cRi() {
        return this.kzi;
    }

    public void ew(List<String> list) {
        this.kzi = list;
    }
}

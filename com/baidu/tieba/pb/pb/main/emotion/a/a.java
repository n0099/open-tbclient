package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> iMO;
    private List<String> lUc;
    private SingleBarEmotionRecommendData lUd;

    public SingleBarEmotionRecommendData dpK() {
        return this.lUd;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.lUd = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> cwV() {
        return this.iMO;
    }

    public void da(List<EmotionImageData> list) {
        this.iMO = list;
    }

    public List<String> dpL() {
        return this.lUc;
    }

    public void fr(List<String> list) {
        this.lUc = list;
    }
}

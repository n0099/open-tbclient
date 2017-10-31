package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> cmi;
    private List<String> eVo;
    private SingleBarEmotionRecommendData eVp;

    public SingleBarEmotionRecommendData aVr() {
        return this.eVp;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.eVp = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> afG() {
        return this.cmi;
    }

    public void az(List<EmotionImageData> list) {
        this.cmi = list;
    }

    public List<String> aVs() {
        return this.eVo;
    }

    public void cy(List<String> list) {
        this.eVo = list;
    }
}

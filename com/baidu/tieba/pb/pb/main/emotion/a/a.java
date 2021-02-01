package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> iSv;
    private List<String> mdg;
    private SingleBarEmotionRecommendData mdh;

    public SingleBarEmotionRecommendData drY() {
        return this.mdh;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.mdh = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> cyg() {
        return this.iSv;
    }

    public void cV(List<EmotionImageData> list) {
        this.iSv = list;
    }

    public List<String> drZ() {
        return this.mdg;
    }

    public void fp(List<String> list) {
        this.mdg = list;
    }
}

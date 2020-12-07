package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private List<EmotionImageData> iFh;
    private List<String> lTt;
    private SingleBarEmotionRecommendData lTu;

    public SingleBarEmotionRecommendData dtL() {
        return this.lTu;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.lTu = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> cxS() {
        return this.iFh;
    }

    public void cT(List<EmotionImageData> list) {
        this.iFh = list;
    }

    public List<String> dtM() {
        return this.lTt;
    }

    public void fr(List<String> list) {
        this.lTt = list;
    }
}

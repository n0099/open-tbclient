package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private List<EmotionImageData> iFj;
    private List<String> lTv;
    private SingleBarEmotionRecommendData lTw;

    public SingleBarEmotionRecommendData dtM() {
        return this.lTw;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.lTw = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> cxT() {
        return this.iFj;
    }

    public void cT(List<EmotionImageData> list) {
        this.iFj = list;
    }

    public List<String> dtN() {
        return this.lTv;
    }

    public void fr(List<String> list) {
        this.lTv = list;
    }
}

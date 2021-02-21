package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> iSJ;
    private List<String> mdv;
    private SingleBarEmotionRecommendData mdw;

    public SingleBarEmotionRecommendData dsf() {
        return this.mdw;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.mdw = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> cyn() {
        return this.iSJ;
    }

    public void cV(List<EmotionImageData> list) {
        this.iSJ = list;
    }

    public List<String> dsg() {
        return this.mdv;
    }

    public void fp(List<String> list) {
        this.mdv = list;
    }
}

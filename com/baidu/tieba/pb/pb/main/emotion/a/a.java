package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private List<EmotionImageData> itB;
    private List<String> lFj;
    private SingleBarEmotionRecommendData lFk;

    public SingleBarEmotionRecommendData doV() {
        return this.lFk;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.lFk = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> cua() {
        return this.itB;
    }

    public void cP(List<EmotionImageData> list) {
        this.itB = list;
    }

    public List<String> doW() {
        return this.lFj;
    }

    public void fg(List<String> list) {
        this.lFj = list;
    }
}

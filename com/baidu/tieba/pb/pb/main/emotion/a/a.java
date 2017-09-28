package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> cfa;
    private List<String> eMI;
    private SingleBarEmotionRecommendData eMJ;

    public SingleBarEmotionRecommendData aSi() {
        return this.eMJ;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.eMJ = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> adD() {
        return this.cfa;
    }

    public void ax(List<EmotionImageData> list) {
        this.cfa = list;
    }

    public List<String> aSj() {
        return this.eMI;
    }

    public void cx(List<String> list) {
        this.eMI = list;
    }
}

package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private List<EmotionImageData> ceO;
    private List<String> eMu;
    private SingleBarEmotionRecommendData eMv;

    public SingleBarEmotionRecommendData aSd() {
        return this.eMv;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.eMv = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> adz() {
        return this.ceO;
    }

    public void ax(List<EmotionImageData> list) {
        this.ceO = list;
    }

    public List<String> aSe() {
        return this.eMu;
    }

    public void cx(List<String> list) {
        this.eMu = list;
    }
}

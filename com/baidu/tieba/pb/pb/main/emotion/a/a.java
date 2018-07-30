package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> cVu;
    private List<String> fIf;
    private SingleBarEmotionRecommendData fIg;

    public SingleBarEmotionRecommendData beW() {
        return this.fIg;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fIg = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> apB() {
        return this.cVu;
    }

    public void aX(List<EmotionImageData> list) {
        this.cVu = list;
    }

    public List<String> beX() {
        return this.fIf;
    }

    public void cY(List<String> list) {
        this.fIf = list;
    }
}

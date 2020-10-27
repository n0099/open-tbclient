package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private List<EmotionImageData> inE;
    private List<String> lzn;
    private SingleBarEmotionRecommendData lzo;

    public SingleBarEmotionRecommendData dms() {
        return this.lzo;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.lzo = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> crz() {
        return this.inE;
    }

    public void cH(List<EmotionImageData> list) {
        this.inE = list;
    }

    public List<String> dmt() {
        return this.lzn;
    }

    public void eY(List<String> list) {
        this.lzn = list;
    }
}

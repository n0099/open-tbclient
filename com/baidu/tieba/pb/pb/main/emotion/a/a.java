package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<EmotionImageData> dbj;
    private List<String> fPE;
    private SingleBarEmotionRecommendData fPF;

    public SingleBarEmotionRecommendData bhv() {
        return this.fPF;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.fPF = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> arp() {
        return this.dbj;
    }

    public void aY(List<EmotionImageData> list) {
        this.dbj = list;
    }

    public List<String> bhw() {
        return this.fPE;
    }

    public void cZ(List<String> list) {
        this.fPE = list;
    }
}

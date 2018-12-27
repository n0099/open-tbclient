package com.baidu.tieba.pb.pb.main.emotion.a;

import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.face.data.SingleBarEmotionRecommendData;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<EmotionImageData> dtO;
    private List<String> gio;
    private SingleBarEmotionRecommendData gip;

    public SingleBarEmotionRecommendData bmI() {
        return this.gip;
    }

    public void a(SingleBarEmotionRecommendData singleBarEmotionRecommendData) {
        this.gip = singleBarEmotionRecommendData;
    }

    public List<EmotionImageData> awK() {
        return this.dtO;
    }

    public void bp(List<EmotionImageData> list) {
        this.dtO = list;
    }

    public List<String> bmJ() {
        return this.gio;
    }

    public void dq(List<String> list) {
        this.gio = list;
    }
}

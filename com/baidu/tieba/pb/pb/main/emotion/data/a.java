package com.baidu.tieba.pb.pb.main.emotion.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bmI;
    private int bpT;
    private List<EmotionImageData> evN;

    public int getPage() {
        return this.bpT;
    }

    public void setPage(int i) {
        this.bpT = i;
    }

    public int ahP() {
        return this.bmI;
    }

    public void setHasMore(int i) {
        this.bmI = i;
    }

    public List<EmotionImageData> aNn() {
        return this.evN;
    }

    public void bX(List<EmotionImageData> list) {
        this.evN = list;
    }
}

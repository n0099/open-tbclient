package com.baidu.tieba.pb.pb.main.emotion.data;

import java.util.List;
/* loaded from: classes.dex */
public class a {
    private int bqy;
    private int btF;
    private List<EmotionImageData> eFd;

    public int getPage() {
        return this.btF;
    }

    public void setPage(int i) {
        this.btF = i;
    }

    public int alz() {
        return this.bqy;
    }

    public void setHasMore(int i) {
        this.bqy = i;
    }

    public List<EmotionImageData> aRm() {
        return this.eFd;
    }

    public void cm(List<EmotionImageData> list) {
        this.eFd = list;
    }
}

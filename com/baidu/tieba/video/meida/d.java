package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    int gQA;
    String gQz;

    public abstract void uj(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.gQz = str;
    }

    public void setSampleRate(int i) {
        this.gQA = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d uk(String str) {
        return new a(str);
    }
}

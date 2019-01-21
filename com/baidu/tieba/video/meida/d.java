package com.baidu.tieba.video.meida;
/* loaded from: classes5.dex */
public abstract class d {
    int channelCount;
    String hJP;
    int sampleRate;

    public abstract void xm(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.hJP = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d xn(String str) {
        return new a(str);
    }
}

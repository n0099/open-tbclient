package com.baidu.tieba.video.meida;
/* loaded from: classes17.dex */
public abstract class d {
    int channelCount;
    String mzE;
    int sampleRate;

    public abstract void RX(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.mzE = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d RY(String str) {
        return new a(str);
    }
}

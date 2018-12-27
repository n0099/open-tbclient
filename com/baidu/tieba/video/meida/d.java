package com.baidu.tieba.video.meida;
/* loaded from: classes5.dex */
public abstract class d {
    int channelCount;
    String hIH;
    int sampleRate;

    public abstract void wW(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.hIH = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d wX(String str) {
        return new a(str);
    }
}

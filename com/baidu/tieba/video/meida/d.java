package com.baidu.tieba.video.meida;
/* loaded from: classes22.dex */
public abstract class d {
    int channelCount;
    String nsF;
    int sampleRate;

    public abstract void TM(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.nsF = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d TN(String str) {
        return new a(str);
    }
}

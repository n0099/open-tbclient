package com.baidu.tieba.video.meida;
/* loaded from: classes8.dex */
public abstract class d {
    int channelCount;
    String nPE;
    int sampleRate;

    public abstract void UG(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.nPE = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d UH(String str) {
        return new a(str);
    }
}

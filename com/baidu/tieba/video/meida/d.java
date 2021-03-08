package com.baidu.tieba.video.meida;
/* loaded from: classes7.dex */
public abstract class d {
    int channelCount;
    String nRJ;
    int sampleRate;

    public abstract void UN(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.nRJ = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d UO(String str) {
        return new a(str);
    }
}

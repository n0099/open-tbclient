package com.baidu.tieba.video.meida;
/* loaded from: classes10.dex */
public abstract class d {
    int channelCount;
    String mak;
    int sampleRate;

    public abstract void Or(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.mak = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d Os(String str) {
        return new a(str);
    }
}

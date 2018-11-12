package com.baidu.tieba.video.meida;
/* loaded from: classes5.dex */
public abstract class d {
    int channelCount;
    String hyk;
    int sampleRate;

    public abstract void wq(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.hyk = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d wr(String str) {
        return new a(str);
    }
}

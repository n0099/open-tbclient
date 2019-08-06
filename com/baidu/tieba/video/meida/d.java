package com.baidu.tieba.video.meida;
/* loaded from: classes5.dex */
public abstract class d {
    int aCx;
    int channelCount;
    String jAq;

    public abstract void Ga(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.jAq = str;
    }

    public void setSampleRate(int i) {
        this.aCx = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d Gb(String str) {
        return new a(str);
    }
}

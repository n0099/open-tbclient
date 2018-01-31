package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String hsr;
    int hss;

    public abstract void tU(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.hsr = str;
    }

    public void setSampleRate(int i) {
        this.hss = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d tV(String str) {
        return new a(str);
    }
}

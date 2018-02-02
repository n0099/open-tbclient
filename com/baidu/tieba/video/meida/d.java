package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String hsr;
    int hss;

    public abstract void tV(String str);

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

    public static d tW(String str) {
        return new a(str);
    }
}

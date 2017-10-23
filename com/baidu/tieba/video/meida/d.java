package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    int gxA;
    String gxz;

    public abstract void sM(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.gxz = str;
    }

    public void setSampleRate(int i) {
        this.gxA = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d sN(String str) {
        return new a(str);
    }
}

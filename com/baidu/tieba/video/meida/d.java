package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String hpm;
    int hpn;

    public abstract void vK(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.hpm = str;
    }

    public void setSampleRate(int i) {
        this.hpn = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d vL(String str) {
        return new a(str);
    }
}

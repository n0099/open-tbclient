package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String gSC;
    int gSD;

    public abstract void um(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.gSC = str;
    }

    public void setSampleRate(int i) {
        this.gSD = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d un(String str) {
        return new a(str);
    }
}

package com.baidu.tieba.video.meida;
/* loaded from: classes5.dex */
public abstract class d {
    int aAT;
    int channelCount;
    String jac;

    public abstract void DM(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.jac = str;
    }

    public void setSampleRate(int i) {
        this.aAT = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d DN(String str) {
        return new a(str);
    }
}

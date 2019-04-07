package com.baidu.tieba.video.meida;
/* loaded from: classes5.dex */
public abstract class d {
    int aAS;
    int channelCount;
    String jab;

    public abstract void DM(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.jab = str;
    }

    public void setSampleRate(int i) {
        this.aAS = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d DN(String str) {
        return new a(str);
    }
}

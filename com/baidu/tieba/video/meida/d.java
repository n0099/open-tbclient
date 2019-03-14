package com.baidu.tieba.video.meida;
/* loaded from: classes5.dex */
public abstract class d {
    int aAP;
    int channelCount;
    String jan;

    public abstract void DN(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.jan = str;
    }

    public void setSampleRate(int i) {
        this.aAP = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d DO(String str) {
        return new a(str);
    }
}

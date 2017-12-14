package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String gVl;
    int gVm;

    public abstract void ur(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.gVl = str;
    }

    public void setSampleRate(int i) {
        this.gVm = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d us(String str) {
        return new a(str);
    }
}

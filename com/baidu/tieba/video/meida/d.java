package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String hhw;
    int hhx;

    public abstract void vb(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.hhw = str;
    }

    public void setSampleRate(int i) {
        this.hhx = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d vc(String str) {
        return new a(str);
    }
}

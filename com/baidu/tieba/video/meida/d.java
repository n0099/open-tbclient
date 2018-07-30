package com.baidu.tieba.video.meida;
/* loaded from: classes2.dex */
public abstract class d {
    int channelCount;
    String hhv;
    int hhw;

    public abstract void uX(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.hhv = str;
    }

    public void setSampleRate(int i) {
        this.hhw = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d uY(String str) {
        return new a(str);
    }
}

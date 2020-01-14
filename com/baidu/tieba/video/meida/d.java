package com.baidu.tieba.video.meida;
/* loaded from: classes8.dex */
public abstract class d {
    int channelCount;
    String kzl;
    int sampleRate;

    public abstract void JY(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.kzl = str;
    }

    public void setSampleRate(int i) {
        this.sampleRate = i;
    }

    public void setChannelCount(int i) {
        this.channelCount = i;
    }

    public static d JZ(String str) {
        return new a(str);
    }
}

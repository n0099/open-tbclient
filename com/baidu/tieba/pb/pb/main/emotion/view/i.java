package com.baidu.tieba.pb.pb.main.emotion.view;

import android.util.Log;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h eFU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.eFU = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbEmotionView pbEmotionView;
        boolean z;
        PbEmotionView pbEmotionView2;
        boolean aRq;
        PbEmotionView pbEmotionView3;
        boolean z2;
        PbEmotionView pbEmotionView4;
        boolean aRq2;
        PbEmotionView pbEmotionView5;
        StringBuilder sb = new StringBuilder();
        pbEmotionView = this.eFU.eFT;
        z = pbEmotionView.eFP;
        StringBuilder append = sb.append(z);
        pbEmotionView2 = this.eFU.eFT;
        aRq = pbEmotionView2.aRq();
        Log.e("WXD", append.append(aRq).toString());
        pbEmotionView3 = this.eFU.eFT;
        z2 = pbEmotionView3.eFP;
        if (z2) {
            pbEmotionView4 = this.eFU.eFT;
            aRq2 = pbEmotionView4.aRq();
            if (aRq2) {
                pbEmotionView5 = this.eFU.eFT;
                pbEmotionView5.aRr();
            }
        }
    }
}

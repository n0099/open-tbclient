package com.baidu.tieba.pb.pb.main.emotion.view;

import android.util.Log;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g ewy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.ewy = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PbEmotionView pbEmotionView;
        boolean z;
        PbEmotionView pbEmotionView2;
        boolean aNq;
        PbEmotionView pbEmotionView3;
        boolean z2;
        PbEmotionView pbEmotionView4;
        boolean aNq2;
        PbEmotionView pbEmotionView5;
        StringBuilder sb = new StringBuilder();
        pbEmotionView = this.ewy.ewx;
        z = pbEmotionView.ewt;
        StringBuilder append = sb.append(z);
        pbEmotionView2 = this.ewy.ewx;
        aNq = pbEmotionView2.aNq();
        Log.e("WXD", append.append(aNq).toString());
        pbEmotionView3 = this.ewy.ewx;
        z2 = pbEmotionView3.ewt;
        if (z2) {
            pbEmotionView4 = this.ewy.ewx;
            aNq2 = pbEmotionView4.aNq();
            if (aNq2) {
                pbEmotionView5 = this.ewy.ewx;
                pbEmotionView5.aNr();
            }
        }
    }
}

package com.baidu.tieba.pb.pb.main.emotion;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ PbSearchEmotionActivity evD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbSearchEmotionActivity pbSearchEmotionActivity) {
        this.evD = pbSearchEmotionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.evD.finish();
    }
}

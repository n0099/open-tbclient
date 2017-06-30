package com.baidu.tieba.pb.pb.main.emotion;

import android.view.View;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ PbSearchEmotionActivity eET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbSearchEmotionActivity pbSearchEmotionActivity) {
        this.eET = pbSearchEmotionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.eET.finish();
    }
}

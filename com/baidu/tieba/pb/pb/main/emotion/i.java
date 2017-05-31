package com.baidu.tieba.pb.pb.main.emotion;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ PbSearchEmotionActivity evD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbSearchEmotionActivity pbSearchEmotionActivity) {
        this.evD = pbSearchEmotionActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.evD.dCP;
        editText.setText("");
    }
}

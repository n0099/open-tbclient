package com.baidu.tieba.pb.pb.main.emotion;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ PbSearchEmotionActivity evD;
    private final /* synthetic */ String evE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbSearchEmotionActivity pbSearchEmotionActivity, String str) {
        this.evD = pbSearchEmotionActivity;
        this.evE = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.evD.dCP;
        editText.setText(this.evE);
        editText2 = this.evD.dCP;
        editText2.setSelection(this.evE.length());
        this.evD.og(this.evE);
        TiebaStatic.log("c12178");
    }
}

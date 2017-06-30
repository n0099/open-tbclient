package com.baidu.tieba.pb.pb.main.emotion;

import android.view.View;
import android.widget.EditText;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ PbSearchEmotionActivity eET;
    private final /* synthetic */ String eEU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbSearchEmotionActivity pbSearchEmotionActivity, String str) {
        this.eET = pbSearchEmotionActivity;
        this.eEU = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        editText = this.eET.dLj;
        editText.setText(this.eEU);
        editText2 = this.eET.dLj;
        editText2.setSelection(this.eEU.length());
        this.eET.pa(this.eEU);
        TiebaStatic.log("c12178");
    }
}

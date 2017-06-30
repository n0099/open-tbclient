package com.baidu.tieba.pb.pb.main.emotion;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements TextView.OnEditorActionListener {
    final /* synthetic */ PbSearchEmotionActivity eET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbSearchEmotionActivity pbSearchEmotionActivity) {
        this.eET = pbSearchEmotionActivity;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        EditText editText;
        if (i == 3) {
            editText = this.eET.dLj;
            String trim = editText.getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                this.eET.pa(trim);
            }
            return true;
        }
        return false;
    }
}

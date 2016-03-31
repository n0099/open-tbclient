package com.baidu.tieba.postsearch;

import android.view.KeyEvent;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements TextView.OnEditorActionListener {
    final /* synthetic */ a dSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.dSj = aVar;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        PostSearchActivity postSearchActivity;
        if (i == 2 || i == 6 || i == 4 || i == 3) {
            String charSequence = textView.getText().toString();
            if (!StringUtils.isNull(charSequence)) {
                postSearchActivity = this.dSj.dSg;
                postSearchActivity.kz(charSequence);
            }
            return true;
        }
        return false;
    }
}

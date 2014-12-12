package com.baidu.tieba.selectpoi;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements TextWatcher {
    final /* synthetic */ SearchLocationActivity bMX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SearchLocationActivity searchLocationActivity) {
        this.bMX = searchLocationActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextView textView;
        TextView textView2;
        if (StringUtils.isNull(this.bMX.abZ())) {
            textView2 = this.bMX.bMU;
            textView2.setEnabled(false);
            return;
        }
        textView = this.bMX.bMU;
        textView.setEnabled(true);
    }
}

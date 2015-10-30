package com.baidu.tieba.write.selectpoi;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements TextWatcher {
    final /* synthetic */ SearchLocationActivity dlO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(SearchLocationActivity searchLocationActivity) {
        this.dlO = searchLocationActivity;
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
        if (StringUtils.isNull(this.dlO.aqA())) {
            textView2 = this.dlO.dlK;
            textView2.setEnabled(false);
            return;
        }
        textView = this.dlO.dlK;
        textView.setEnabled(true);
    }
}
